package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdatePayAndShipServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";

		try {



		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新は出来ません。";
		}


	}

}
