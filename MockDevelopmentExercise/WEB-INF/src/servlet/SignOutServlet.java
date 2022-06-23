package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SignOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("message", "ログアウトしました。");
		request.getRequestDispatcher("/view/index.jsp").forward(request, response);
	}
}
