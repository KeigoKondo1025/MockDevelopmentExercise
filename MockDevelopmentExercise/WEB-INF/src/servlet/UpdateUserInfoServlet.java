package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateUserInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		bean.User user = new bean.User();
		String error = "";
		String cmd = "";
		int count = 0;
		dao.UserDAO userDao = new dao.UserDAO();
		try {
			request.setCharacterEncoding("UTF-8");
			//各setterメソッドを利用し、ユーザー情報を設定
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			user.setPassWord(request.getParameter("pass"));
			user.setUserName(request.getParameter("userName"));
			user.setFamilyName(request.getParameter("familyName"));
			user.setFirstName(request.getParameter("firstName"));
			user.setPostalCode(request.getParameter("postalCpde"));
			user.setPrefectureId(Integer.parseInt(request.getParameter("prefectureCode")));
			user.setAddress1(request.getParameter("address1"));
			user.setMail(request.getParameter("mail"));
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			count = userDao.update(user);
			session.setAttribute("user", user);
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、ユーザー情報の変更は行えませんでした。";
			cmd = "error";
		} finally {
			if (cmd.equals("")) {
				//UserInfoServletに遷移する
				request.getRequestDispatcher("/UserInfo").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				//error.jspに遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
