package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

import bean.*;
import dao.*;

public class ItemDeleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

		} catch(IllegalStateException e) {
			error = "DB接続エラーの為、表示できません。";
		} finally {

		}

	}
}
