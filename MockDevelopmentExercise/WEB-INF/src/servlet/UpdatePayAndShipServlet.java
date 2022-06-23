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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");

		String formatNowDate = dtf.format(nowDate);

		String error = "";
		String cmd = "";


		try {
			ItemDAO itemDao = new ItemDAO();
			UserDAO userDao = new UserDAO();

//			userIdをリクエストスコープで取得
			String buyerUserId = (String)request.getAttribute("buyerUserId");


//			buyerUserIdで買った商品のArrayListを検索
			ArrayList<Item> itemList = userDao.search(buyUserId, "", "");
			request.setAttribute("itemList", itemList);

			//商品の取引情報を格納する変数
			//出品中→0、入金待ち→1、発送待ち→2、取引済→3
			int itemSituation = (Integer.parseInt(request.getParameter("itemSituation")));

//			String strItemSituation = "";
//			if(itemSituation == 0) {//これはこのページに表示しない
//				strItemSituation = "出品中";
//			} else if (itemSituation == 1) {
//				strItemSituation = "入金待ち";
//			} else if (itemSituation == 2) {
//				strItemSituation = "発送待ち";
//			} else if (itemSituation == 3) {
//				strItemSituation = "取引済";
//			}

			//商品の取引情報を更新
			itemDao.updateItemSituation(itemId, itemSituation);

			request.setAttribute("formatNowDate", formatNowDate);



		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新は出来ません。";
		}


	}

}
