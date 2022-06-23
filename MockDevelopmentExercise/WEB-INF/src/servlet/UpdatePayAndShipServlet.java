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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

//		LocalDateTime nowDate = LocalDateTime.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");
//
//		String formatNowDate = dtf.format(nowDate);

		String error = "";
		String cmd = "";

		try {

			ItemDAO itemDao = new ItemDAO();
			UserDAO userDao = new UserDAO();

//			買った人と売った人のuserIdをリクエストスコープで取得する、このidは商品を検索するときに使う
			String buyerId = (String)request.getAttribute("buyerId");
			String sellerId = (String)request.getAttribute("sellerId");

//			ボタンを押された商品の商品idを格納する
			int itemId = (Integer.parseInt(request.getParameter("itemId")));

			//商品の取引情報を格納する変数
			//出品中→0、入金待ち→1、発送待ち→2、取引済→3
			int itemSituation = (Integer.parseInt(request.getParameter("itemSituation")));

			//商品の取引情報を更新
			itemDao.updateItemSituation(itemId, itemSituation);

//			buyerUserIdで購入した商品のArrayListを検索
			ArrayList<Item> boughtItemList = itemDao.select("",buyerId, "", "");
			request.setAttribute("boughtItemList", boughtItemList);

//			buyerUserIdで売った商品のArrayListを検索
			ArrayList<Item> soldItemList = itemDao.select(sellerId,"","", "");
			request.setAttribute("soldItemList", soldItemList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新は出来ません。";

		} finally {
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
//				エラーが無ければupdatePayAndShip.jspへ
				request.getRequestDispatcher("/view/updatePayAndShip.jsp").forward(request, response);
			}
		}


	}

}
