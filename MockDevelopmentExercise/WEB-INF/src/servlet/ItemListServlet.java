package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

import bean.*;
import dao.*;

public class ItemListServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
		} finally {

		}

	}
}
