package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateUserInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		bean.User user = new bean.User();
		String error = "";
		String cmd = "";
		String postalCode = "";
		try {
			request.setCharacterEncoding("UTF-8");
			//各setterメソッドを利用し、ユーザー情報を設定
			user.setUserName(request.getParameter("userName"));
			user.setFamilyName(request.getParameter("familyName"));
			user.setFirstName(request.getParameter("firstName"));
			user.setGender(Integer.parseInt(request.getParameter("gender")));
			postalCode
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、ユーザー情報の変更は行えませんでした。";
			cmd = "error";
		}
	}
}
