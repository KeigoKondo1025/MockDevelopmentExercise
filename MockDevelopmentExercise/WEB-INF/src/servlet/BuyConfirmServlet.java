package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;

public class BuyConfirmServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String error = "";
		String cmd = "";
		try {
			//セッション情報の取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if (user == null) {
				error = "セッション切れの為、購入は出来ません。";
				cmd = "logout";
				return;
			}
			bean.Item itemList = (bean.Item)request.getAttribute("item");
			if (itemList == null) {
				error = "カートの中に何もなかったので購入出来ません。";
				cmd = "top";
				return;
			}
			ArrayList<bean.Item> ArrayItem = new ArrayList<bean.Item>();
			//購入情報をArrayListに格納
			ArrayItem.add(itemList);
			//ArrayList型配列ArrayItem格納用
			bean.Item item = new bean.Item();
			//selectメソッド用ArrayList
			ArrayList<bean.Item> selectItem = new ArrayList<bean.Item>();
			//ArrayList型配列selectItem格納用
			bean.Item item_List = new bean.Item();
			//insertメソッドの戻り値格納用
			int order = 0;
			//itemDAOをインスタンス化し、関連メソッドをitemListのカート追加文だけ呼び出す
			//取得したitemをリクエストスコープに"item_List"という名前で格納
			dao.ItemDAO itemDao = new dao.ItemDAO();
			for (int i = 0; i < ArrayItem.size(); i++) {
				item = ArrayItem.get(i);
				selectItem = itemDao.select(String.valueOf(item.getSellerId()), String.valueOf(item.getBuyerId()), String.valueOf(item.getPrice()), String.valueOf(item.getItemSituation()));
				item_List = selectItem.get(i);
				order = itemDao.insert(item);
			}
			request.setAttribute("itemList", item_List);
			//"item_List"の注文情報内容をメール送信する
			util.SendMail mail = new util.SendMail();
			mail.mail("item_list", itemList);
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、購入は出来ません。";
			cmd = "logout";
		} finally {
			if(cmd.equals("")) {
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("logout", cmd);
				//"error.jsp"に遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
