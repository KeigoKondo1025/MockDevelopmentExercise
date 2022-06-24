package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String message = "";


		try {

			request.setCharacterEncoding("UTF-8");//文字コード指定

			ItemDAO itemDaoObj = new ItemDAO();
			int categoryId = Integer.parseInt(request.getParameter("category"));//カテゴリー
			String itemName = request.getParameter("item-name");//商品名
			int priceRange = Integer.parseInt(request.getParameter("price-range"));//価格範囲
			int prefectureId = Integer.parseInt(request.getParameter("prefecture-id"));//都道府県ID
			int minPrice = 0;//最小価格
			int maxPrice = 99999999;//最大価格
			switch(priceRange) {
				case 1:
					minPrice = 0;
					maxPrice = 999;
					break;
				case 2:
					minPrice = 1000;
					maxPrice = 2999;
					break;
				case 3:
					minPrice = 3000;
					maxPrice = 4999;
					break;
				case 4:
					minPrice = 5000;
					maxPrice = 9999;
					break;
				case 5:
					minPrice = 10000;
					break;
				default:
					break;
			}

			ArrayList<Item> itemList = itemDaoObj.select(categoryId, itemName,minPrice,maxPrice,prefectureId);//商品検索
			request.setAttribute("item_list", itemList);//リクエストスコープに格納



		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品検索は出来ません。";
			cmd = "logout";
		} finally {

			if (!error.equals("")) {
//				エラーがあればerror.jspへ
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}else {
//				エラーが無ければトップページへ
				request.getRequestDispatcher("/view/index.jsp").forward(request, response);
			}
		}
	}
}
