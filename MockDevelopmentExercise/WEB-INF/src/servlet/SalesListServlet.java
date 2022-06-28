package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

import bean.*;
import dao.*;

public class SalesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		//エラー処理用の変数
		String error = "";
		String cmd = "";

		//使用する変数
		String sellerName = "";
		String buyerName = "";
		int categoryId = 0;

		try {
			//セッション情報の取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			//パラメータ情報の受け取り
			request.setCharacterEncoding("UTF-8");
			cmd = request.getParameter("cmd");
			if(!cmd.equals("sales")) {
				sellerName = request.getParameter("sellerName");
				buyerName = request.getParameter("buyerName");
				categoryId = Integer.parseInt(request.getParameter("category"));
			}

			//セッション切れの場合
			if(user == null) {
				error = "セッション切れの為、ユーザー情報表示は行えません。";
				cmd = "logout";
				return;
			}

			//検索結果を格納する変数の宣言
			ArrayList<Item> itemList = new ArrayList<Item>();

			if(!cmd.equals("searchSales")) {
				//購入済みの商品を全て検索するメソッドの呼び出し
				ItemDAO itemDao = new ItemDAO();
				itemList = itemDao.selectSales();
			}else {
				UserDAO userDao = new UserDAO();
				//購入者のuserIdのArrayListを受け取る
				ArrayList<Integer> buyerId = userDao.searchByUserName(buyerName);

				//出品者のuserIdのArrayListを受け取る
				ArrayList<Integer> sellerId = userDao.searchByUserName(sellerName);

				//購入済みの商品から引数の値で検索するメソッド
				ItemDAO itemDao = new ItemDAO();
				itemList = itemDao.selectSales(sellerId, categoryId, buyerId);
			}

			request.setAttribute("itemList", itemList);

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

