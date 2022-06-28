package servlet;

/*
 * 作成者：高徳ちさと
 */
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class UpdatePayAndShipServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		LocalDateTime nowDate = LocalDateTime.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");
//
//		String formatNowDate = dtf.format(nowDate);

		String error = "";
		String cmd = "";

		try {

			ItemDAO itemDao = new ItemDAO();
			UserDAO userDao = new UserDAO();

//			user情報をセッションから取得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

//			userIdは購入した商品と売った商品をつなぐのに使う
			int userId = user.getUserId();

			if (request.getParameter("itemSituation") != null) {//不正アクセス防止
//			ボタンを押された商品の商品idを格納する
				int itemId = (Integer.parseInt(request.getParameter("itemId")));

				// 商品の取引情報を格納する変数
				// 出品中→0、入金待ち→1、発送待ち→2、取引済→3
				int itemSituation = (Integer.parseInt(request.getParameter("itemSituation")));
				request.setAttribute("itemSituation", itemSituation);

				if (itemSituation != 2) {
					// 商品の取引情報を更新
					itemDao.updateItemSituation(itemId, itemSituation);
				} else {
					itemDao.updateBoughtTime(itemId, itemSituation);
				}
			}

//			buyerUserIdで購入した商品のArrayListを検索、jspで購入した商品を表示するのに使う
			ArrayList<Item> buyItemList = itemDao.selectBuyerId(userId);
			request.setAttribute("buyItemList", buyItemList);

//			buyerUserIdで売った商品のArrayListを検索、jspで売った商品を表示するのに使う
			ArrayList<Item> sellItemList = itemDao.selectSellerId(userId);
			request.setAttribute("sellItemList", sellItemList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新は出来ません。";
			cmd = "logout";
		} finally {
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
//				エラーが無ければupdatePayAndShip.jspへ
				request.getRequestDispatcher("/view/updatePayAndShip.jsp").forward(request, response);
			}
		}

	}

}
