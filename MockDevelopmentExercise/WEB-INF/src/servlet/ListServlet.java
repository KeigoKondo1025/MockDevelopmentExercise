package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Item;
import dao.ItemDAO;


public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String message = "";// 入力データが間違っていた場合ログイン画面に表示する

		ItemDAO itemDaoObj = new ItemDAO();


		try {
			ArrayList<Item> itemList = itemDaoObj.selectAll();
			request.setAttribute("item_list", itemList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
			cmd = "logout";
		} finally {

			if (!error.equals("")) {
//				エラーがあればerror.jspへ
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
//			エラーが無ければトップページへ
			} else {
				request.getRequestDispatcher("/view/index.jsp").forward(request, response);
			}
		}
	}
}
