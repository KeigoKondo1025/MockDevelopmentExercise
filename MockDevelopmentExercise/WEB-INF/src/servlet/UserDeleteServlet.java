package servlet;

import java.io.*;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDeleteServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		String error = "";
		String cmd = "";
		bean.User user = new bean.User();
		dao.UserDAO userDao = new dao.UserDAO();
		try {
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			userDao.delete(user);
			session.setAttribute("user", user);
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、ユーザの削除は行えませんでした。";
			cmd = "logout";
		} finally {
			if (cmd.equals("")) {
				request.getRequestDispatcher("/view/myPage.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
