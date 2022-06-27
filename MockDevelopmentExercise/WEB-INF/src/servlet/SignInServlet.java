package servlet;

/*
 * 作成者：高徳ちさと
 */
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

		User user = new User();

		UserDAO userDao = new UserDAO();

		HttpSession session = request.getSession();

		try {

			request.setCharacterEncoding("UTF-8");

			String mail = request.getParameter("mail");
			String password = request.getParameter("password");

			user = userDao.search(mail, password);

			if (user.getMail() == null) {
				message = "入力データが間違っています。";
				return;
			}

			session.setAttribute("user", user);

//			mail用クッキー
			Cookie useridCookie = new Cookie("mail", mail);
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
				request.setAttribute("message", message);
				request.getRequestDispatcher("/view/signIn.jsp").forward(request, response);
			} else if (user.getAuthority() == 2){
//				管理者の場合エラーが無ければマイページへ
				request.getRequestDispatcher("/MyPage").forward(request, response);
			} else if (user.getAuthority() == 1){
//				一般ユーザーの場合エラーが無ければマイページへ
				request.getRequestDispatcher("/Index").forward(request, response);
			}
		}
	}
}
