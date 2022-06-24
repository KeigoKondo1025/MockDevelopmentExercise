package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ItemEntryServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		bean.Item item = new bean.Item();
		String error = "";
		String cmd = "";
		//DAOクラスitemDAOをインスタント化

		//戻り値格納用
		int count = 0;
		try {
			request.setCharacterEncoding("UTF-8");
			//各setterメソッドを利用し、出品情報を設定
			item.setImage1(request.getParameter("image1"));
			item.setImage2(request.getParameter("image2"));
			item.setImage3(request.getParameter("image3"));
			item.setImage4(request.getParameter("image4"));
			item.setItemName(request.getParameter("itemName"));
			item.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			item.setPrice(Integer.parseInt(request.getParameter("price")));
			item.setItemState(Integer.parseInt(request.getParameter("itemState")));
			item.setSellerMessage(request.getParameter("sellerMessage"));
			item.setPrefectureId(Integer.parseInt(request.getParameter("prefectureId")));
			//Itemオブジェクトを引数として、関連メソッドを呼び出し、変数countに戻り値を格納する
			dao.ItemDAO itemDao = new dao.ItemDAO();
			count = itemDao.insert(item);
		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、出品は行えません";
			cmd = "logout";
		} finally {
			if (cmd.equals("")) {
				//商品詳細へ遷移
				request.getRequestDispatcher("/ItemDetail?itemId=1").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
