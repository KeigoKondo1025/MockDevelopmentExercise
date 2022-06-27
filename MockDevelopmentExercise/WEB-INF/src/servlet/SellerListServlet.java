package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;


public class SellerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//エラー処理用の変数
		String error = "";
		String cmd = "";

		try {
			//セッション情報の取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			//セッション切れの場合
			if(user == null) {
				error = "セッション切れの為、ユーザー情報表示は行えません。";
				cmd = "logout";
				return;
			}

			//パラメータ情報の受け取り
			request.setCharacterEncoding("UTF-8");
			String strUserId = request.getParameter("userId");

			UserDAO userDao = new UserDAO();
			ItemDAO itemDao = new ItemDAO();
			User sellerUser = new User();
			if(strUserId != null) {
				int userId =Integer.parseInt(strUserId);
				sellerUser = userDao.searchByUserId(userId);
				request.setAttribute("sellerUser",sellerUser);
			}else {
				//購入済みの商品から重複の内容に出品者情報を検索するメソッドの呼び出し
				ArrayList<Integer> sellerUserId = itemDao.selectSellerList();
				//ユーザーの一覧を格納する変数
				ArrayList<User> sellerUserList = new ArrayList<User>();
				//上の結果をもとにユーザー一覧を取得しリクエストスコープに格納する
				for(int i = 0; i < sellerUserId.size(); i++) {
					sellerUser = userDao.searchByUserId(sellerUserId.get(i));
					sellerUserList.add(sellerUser);
				}
				request.setAttribute("sellerUserList", sellerUserList);
			}


		}catch (IllegalStateException e){
			error = "DB接続エラーの為、ユーザー情報は表示出来ません。";
			cmd = "logout";
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/salesList.jsp").forward(request, response);
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				//error.jspに遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}

