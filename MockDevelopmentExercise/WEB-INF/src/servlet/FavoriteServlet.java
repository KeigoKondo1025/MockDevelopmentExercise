/*
 * お気に入り関連の機能(追加・削除・一覧)を持つサーブレット
 * cmdの値によって分岐処理
 */

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.User;
import dao.ItemDAO;
import dao.FavoriteDAO;

@SuppressWarnings("serial")
public class FavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		request.setCharacterEncoding("UTF-8");

		try {

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Item item = (Item) session.getAttribute("item");
			cmd = (String) request.getAttribute("cmd"); // cmdの値で操作を分ける

			if (user == null) {// セッション切れ判定
				request.setAttribute("error", "MyPageServletでのセッション切れ");
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				return;
			}

			if (error.equals("")) {

				FavoriteDAO favoriteDaoObj = new FavoriteDAO();

				if (cmd.equals("list")) {// リスト表示
					ArrayList<Integer> itemIdList = favoriteDaoObj.selectByUserId(user.getUserId());

					ArrayList<Item> favoriteList = new ArrayList<Item>();

					ItemDAO itemDaoObj = new ItemDAO();

					for(int i = 0; i < itemIdList.size(); i++){

						favoriteList.add(itemDaoObj.selectByItemId(itemIdList.get(i))); //取得したItemIDからItemクラスを取得favoriteListに格納
					}

					request.setAttribute("favoriteList", favoriteList);
					request.getRequestDispatcher("/view/favoriteList.jsp").forward(request, response);

				} else if (cmd.equals("insert")) {//登録ボタン押下

					favoriteDaoObj.insert(user.getUserId(), item.getItemId());
					cmd = "list";
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/FavoriteList").forward(request, response);

				} else if (cmd.equals("delete")) {//削除ボタン押下

					favoriteDaoObj.delete(favoriteDaoObj.selectFavoriteId(user.getUserId(), item.getItemId()));
					cmd = "list";
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/FavotriteList").forward(request, response);
				}

			}

		} catch (

		IllegalStateException e) {
			error = "DB接続エラー";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		}
	}

}
