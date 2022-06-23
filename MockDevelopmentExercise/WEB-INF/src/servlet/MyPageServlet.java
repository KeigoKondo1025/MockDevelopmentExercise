// 出品者のsellerIdと一致する商品情報を取得機能
// myPage.jspに移動する前に経由

package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Item;
import bean.User;
import dao.ItemDAO;

@SuppressWarnings("serial")
public class MyPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";

		request.setCharacterEncoding("UTF-8");

		try {

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			if (user == null) {//セッション切れ判定
				request.setAttribute("error", "MyPageServletでのセッション切れ");
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				return;
			}

			ItemDAO itemDaoObj = new ItemDAO();
			String sellerId = "" + user.getUserId();
			ArrayList<Item> itemList = itemDaoObj.select(sellerId, "", "","");

			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher("/view/myPage.jsp").forward(request, response);

		} catch (IllegalStateException e) {
			error = "DB接続エラー";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		}
	}
}
