package servlet;

import java.io.*;
import java.util.*;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String error = "";
		String cmd = "";
		bean.User user = new bean.User();
		dao.UserDAO userDao = new dao.UserDAO();
		try {
			//ユーザーIdの取得
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			//Itemオブジェクトを引数として、関連メソッドを呼び出す
			userDao.delete(user);
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、ユーザの削除は行えませんでした。";
			cmd = "logout";
		} finally {
			if (cmd.equals("")) {
				request.getRequestDispatcher("/UserList").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
