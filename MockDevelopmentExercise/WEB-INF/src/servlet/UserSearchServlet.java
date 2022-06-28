package servlet;
/*
 * 作成者：高徳ちさと
 */
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class UserSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			UserDAO userDao = new UserDAO();

			String userName = (String)request.getParameter("userName");

			ArrayList<Integer> userIdList = userDao.searchByUserName(userName);
			request.setAttribute("userIdList", userIdList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、検索出来ません。";
			cmd = "logout";
		} finally {

			if (!error.equals("")) {
//				エラーがあればerror.jspへ
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}else {
//				エラーが無ければトップページへ
				request.getRequestDispatcher("/view/userList.jsp").forward(request, response);
			}

		}

	}

}
