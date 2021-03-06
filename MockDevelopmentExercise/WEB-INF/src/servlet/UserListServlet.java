package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

/**
 * ユーザ一覧機能に関する処理をおこなうサーブレットクラス
 * @author 関優月
 */

public class UserListServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// UserDAOをインスタンス化
			UserDAO userDao = new UserDAO();

			// 関連メソッドを呼び出し、戻り値としてBookオブジェクトのリストを取得する
			ArrayList<User> userList = userDao.selectAll();

			// 取得したListをリクエストスコープに"book_list"という名前で格納する
			request.setAttribute("userList", userList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "menu";
		} finally {
			// � エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はuserList.jspにフォワード
				request.getRequestDispatcher("/view/userList.jsp").forward(request,response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
