package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

import bean.*;
import dao.*;

public class ItemListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			UserDAO userDao = new UserDAO();
			ItemDAO itemDao = new ItemDAO();

			ArrayList<Item> itemList = itemDao.selectAll();

			request.setAttribute("itemList", itemList);


		} catch(IllegalStateException e) {
			error = "DB接続エラーの為、表示できません。";
			cmd = "logout";
		} finally {
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
//				エラーが無ければitemList.jspへ
				request.getRequestDispatcher("/view/itemList.jsp").forward(request, response);
			}


		}

	}
}
