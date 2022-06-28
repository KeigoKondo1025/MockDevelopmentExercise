package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import bean.Item;

import dao.ItemDAO;
import util.*;

public class BuyItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		//エラー処理用の変数
		String error = "";
		String cmd = "";
		int count = 0;


		try {
			//セッション情報の取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			//セッション切れの場合
			if(user == null) {
				error = "セッション切れの為、購入は行えません。";
				cmd = "logout";
				return;
			}

			//リクエストスコープの情報の取得
			request.setCharacterEncoding("UTF-8");
			int itemId = Integer.parseInt(request.getParameter("itemId"));

			//購入者情報と商品状況を変更するメソッドの呼び出し
			ItemDAO itemDao = new ItemDAO();
			count = itemDao.updateBuyerId(itemId, user.getUserId());

			if(count == 0) {
				error = "クエリの生成に失敗しました";
				cmd = "";
			}

			//itemIdを元に商品情報を取得するメソッドの呼び出し
			Item item = itemDao.selectByItemId(itemId);

			//メールの文章を格納する変数
			String message = user.getUserName() + "様\n購入ありがとうございます。\n\n商品情報\n商品名 : "
					+ item.getItemName() + "\n金額 : " + item.getPrice() + "円\n購入日時 : " +
					item.getBoughtTime() + "\n\n入金が確認され次第商品の発送を行いますので入金を行い次第、"
							+ "マイページにあります入金情報変更機能より入金報告をお願いします。";

			//メールを送信するメソッドの呼び出し
			SendMail sendMail = new SendMail();
			sendMail.MailSetup(message);


			//商品情報をリクエストスコープに格納する
			request.setAttribute("item", item);


		}catch (IllegalStateException e){
			error = "DB接続エラーの為、購入は出来ません。";
			cmd = "logout";
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				//error.jspに遷移する
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}
}
