package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class SignInServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String message = "";// 入力データが間違っていた場合ログイン画面に表示する

		UserDAO = userDao = new UserDAO();

		HttpSession session = request.getSession();

		try {

			request.setCharacterEncoding("UTF-8");

			String mailAddress = request.getParameter("mailAddress");
			String password = request.getParameter("password");

			User user = userDao.selectByUser(mailAddress, password);

			if (user.getMailAddress() == null) {
				message = "入力データが間違っています。";
				request.setAttribute("messager", message);
				return;
			}

			session.setAttribute("user", user);

//			userid用クッキー
			Cookie useridCookie = new Cookie("mailAddress", mailAddress);
			useridCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(useridCookie);

//			password用クッキー
			Cookie passCookie = new Cookie("password", password);
			passCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(passCookie);
//

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
			cmd = "logout";
		} finally {

			if (!error.equals("")) {
//				エラーがあればerror.jspへ
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else if (!message.equals("")) {
//				User情報が無い場合(入力データが間違っている場合)login.jspへ
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

//			エラーが無ければトップページへ
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}
}
