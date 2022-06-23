package servlet;

import java.io.*;
import java.util.*;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateUserInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		bean.User user = new bean.User();
		String error = "";
		String cmd = "";
		int count = 0;
		dao.UserDAO userDao = new dao.UserDAO();
		try {
			request.setCharacterEncoding("UTF-8");
			//各setterメソッドを利用し、ユーザー情報を設定
			user.setUserName(request.getParameter("userName"));
			user.setFamilyName(request.getParameter("familyName"));
			user.setFirstName(request.getParameter("firstName"));
			user.setGender(Integer.parseInt(request.getParameter("gender")));
			user.setPostalCode(request.getParameter("postalCode"));
			user.setPrefectureId(Integer.parseInt(request.getParameter("prefectureId")));
			user.setAddress1(request.getParameter("address1"));
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			user.setBirthday(birthday);
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			count = userDao.update(user);

		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、ユーザー情報の変更は行えませんでした。";
			cmd = "error";
		} finally {
			if (cmd.equals("")) {
				//UserInfoServletに遷移する
				request.getRequestDispatcher("/view/UserInfo").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				//error.jspに遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
