package servlet;

import java.io.*;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;

public class ItemEntryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		bean.Item item = new bean.Item();
		String error = "";
		String cmd = "";
		//戻り値格納用
		int count = 0;
		int itemId = 0;
		try {
			//セッション情報の取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if (user == null) {
				error = "セッション切れの為、購入は出来ません。";
				cmd = "logout";
				return;
			}
			request.setCharacterEncoding("UTF-8");
			//各setterメソッドを利用し、出品情報を設定
			item.setItemName(request.getParameter("itemName"));
			item.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			item.setPrice(Integer.parseInt(request.getParameter("price")));
			item.setImage1(request.getParameter("image1"));
			item.setImage2(request.getParameter("image2"));
			item.setImage3(request.getParameter("image3"));
			item.setImage4(request.getParameter("image4"));
			item.setItemState(Integer.parseInt(request.getParameter("itemState")));
			item.setSellerId(user.getUserId());
			item.setSellerMessage(request.getParameter("sellerMessage"));
			item.setPrefectureId(Integer.parseInt(request.getParameter("prefectureId")));
			item.setItemSituation(Integer.parseInt(request.getParameter("itemSituation")));
			boolean boo = new Boolean(request.getParameter("deleteFlag"));
			item.setDeleteFlag(boo);
			//Itemオブジェクトを引数として、関連メソッドを呼び出し、変数countに戻り値を格納する
			dao.ItemDAO itemDao = new dao.ItemDAO();
			count = itemDao.insert(item);
			itemId = itemDao.newItemId();
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、出品は行えません";
			cmd = "logout";
		} finally {
			if (cmd.equals("")) {
				//商品詳細へ遷移
				request.getRequestDispatcher("/ItemDetail?itemId="+ itemId).forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
