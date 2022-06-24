package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Item;
import dao.ItemDAO;

public class ItemDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)		// 商品IDがget送信で送られてくる
	throws ServletException,IOException{
		String error = "";		// エラーメッセージを格納する変数を初期化

		try {
			// 入力情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// isbn、cmdのGETパラメータを取得する。
			String strItemId = request.getParameter("itemId");

			// String型で受け取ったユーザIDを、int型に変換
			int itemId;
			try {
				itemId = Integer.parseInt(strItemId);
			} catch (NumberFormatException e) {
				error = "商品IDの値が不正の為、詳細情報は表示できませんでした。";
				return;
			}

			// 各種メソッドを呼び出すため、DAOクラスをオブジェクト化
			ItemDAO itemDao = new ItemDAO();

			// 表示対象の商品情報があるかどうかをチェック
			Item item = itemDao.selectByItemId(itemId);		// パラメータとして渡された商品IDを使い、商品情報をDBから検索
			if (item.getItemId() == 0) {
				error = "表示対象の商品が存在しない為、詳細情報は表示できませんでした。";
				return;
			}

			// エラーに引っかからなかった場合、商品情報を格納したItemオブジェクトをリクエストスコープに登録
			request.setAttribute("item",item);

		}catch(IllegalStateException e) {
			error = "DB接続エラーの為、詳細情報は表示できませんでした。";
		}finally {
			// エラーの有無でフォワード先を呼び分け
			if(error.equals("")) {	// エラーがない場合
				request.getRequestDispatcher("/view/itemDetail.jsp").forward(request,response);

			}else {		// エラーがある場合
				// エラーメッセージをリクエストスコープに登録
				request.setAttribute("error",error);

				// error.jspにフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);
			}
		}
	}
}
