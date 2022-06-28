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

		ItemDAO itemDaoObj = new ItemDAO();


		try {
			ArrayList<Item> itemList = itemDaoObj.select("","", "", "0");//出品中の商品のみ検索
			request.setAttribute("item_list", itemList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は出来ません。";
			cmd = "index";
		} finally {

			if (!error.equals("")) {
//				エラーがあればerror.jspへ
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
//			エラーが無ければトップページへ
			} else {
				request.getRequestDispatcher("/view/index.jsp").forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		ItemDAO itemDaoObj = new ItemDAO();


		try {
			ArrayList<Item> itemList = itemDaoObj.select("","", "", "0");//出品中の商品のみ検索
			request.setAttribute("item_list", itemList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は出来ません。";
			cmd = "cmd";
		} finally {

			if (!error.equals("")) {
//				エラーがあればerror.jspへ
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
//			エラーが無ければトップページへ
			} else {
				request.getRequestDispatcher("/view/index.jsp").forward(request, response);
			}
		}
	}
}
