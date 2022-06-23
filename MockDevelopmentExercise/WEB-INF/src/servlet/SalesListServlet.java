package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

import bean.*;
import dao.*;

public class SalesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
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

			//購入済みの商品を全て検索するメソッドの呼び出し
			ItemDAO itemDao = new ItemDAO();
			ArrayList<Item> itemList = itemDao.selectSales();

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

