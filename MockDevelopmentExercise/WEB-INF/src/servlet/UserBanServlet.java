package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class UserBanServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User user = new User();
		String error = "";
		String cmd = "";
		int count = 0;
		UserDAO userDao = new UserDAO();
		try {
			int userId = Integer.parseInt(request.getParameter("userId"));//GET送信されたuserIdを取得
			user = userDao.searchByUserId(userId);

			count = userDao.update(userId,!user.getIsUserBanned());//Banフラグを反転して更新

		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、ユーザーのBanは行えませんでした。";
			cmd = "error";
		} finally {
			if (cmd.equals("")) {
				//UserListServletに遷移する
				request.getRequestDispatcher("/UserList").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				//error.jspに遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
