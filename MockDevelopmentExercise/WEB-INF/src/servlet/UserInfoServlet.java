package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		//エラー処理用の変数
		String error = "";
		String cmd = "";

		try {
			//セッション情報の取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			//セッション切れの場合
			if(user == null) {
				error = "セッション切れの為、ユーザー情報表示は行えません。";
				cmd = "logout";
				return;
			}

			//ユーザー情報をリクエストスコープに格納する
			request.setAttribute("user", user);


		}catch (IllegalStateException e){
			error = "DB接続エラーの為、ユーザー情報は表示出来ません。";
			cmd = "logout";
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/userInfo.jsp").forward(request, response);
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				//error.jspに遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}


	}
}
