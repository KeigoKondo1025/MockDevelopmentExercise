package servlet;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Date;
import bean.User;
import dao.UserDAO;

/**
 * 会員登録処理をおこなうサーブレットクラス
 * @author 関優月
 */

public class InsertUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String error = "";
		String cmd = "";
		String message = "";	// 入力データが間違っていた場合、会員登録画面に表示する

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// 入力パラメータを取得
			String userName = request.getParameter("user-name");		// ユーザ名
			String passWord = request.getParameter("password");		// パスワード
			String familyName = request.getParameter("family-name");	// 苗字
			String firstName = request.getParameter("first-name");	// 名前
			String strGender = request.getParameter("gender");			// 性別
			String postalCode = request.getParameter("postal-code");	// 郵便番号
			String strPrefectureId = request.getParameter("prefectureId");	// 都道府県ID
			String address1 = request.getParameter("address1");		// 住所１
			String address2 = request.getParameter("address2");		// 住所２
			String strBirthday = request.getParameter("birthday");		// 生年月日
			String phoneNumber = request.getParameter("phoneNumber");	// 電話番号
			String mail = request.getParameter("email");				// メールアドレス
			String strAuthority = request.getParameter("authority");		// 権限
			String strInsertedOn = request.getParameter("insertedOn");	// 登録日時


			int gender;
			try {
				gender = Integer.parseInt(strGender);
			} catch (NumberFormatException e) {
				error = "性別の値が不正の為、会員登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			int prefectureId;
			try {
				prefectureId = Integer.parseInt(strPrefectureId);
			} catch (NumberFormatException e) {
				error = "性別の値が不正の為、会員登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			int authority;
			try {
				authority = Integer.parseInt(strAuthority);
			} catch (NumberFormatException e) {
				error = "権限の値が不正の為、会員登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// String型で受け取った生年月日データを、Date型にキャスト
			Date birthday;
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				Date date = format.parse(strBirthday);
			}catch (ParseException e) {
				error = "生年月日の値が不正の為、会員登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// String型で受け取った登録日時データを、Date型にキャスト
			Date insertedOn;
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				Date date = format.parse(strInsertedOn);
			}catch (ParseException e) {
				error = "登録日時の値が不正の為、会員登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// UserDAOオブジェクト生成
			UserDAO userDao = new UserDAO();

			// User型オブジェクトを生成し、取得した各パラメータをsetterメソッドを利用して格納する
			User user = new User();
			user.setUserName(userName);
			user.setPassWord(passWord);
			user.setFamilyName(familyName);
			user.setFirstName(firstName);
			user.setGender(gender);
			user.setPostalCode(postalCode);
			user.setPrefectureId(prefectureId);
			user.setAddress1(address1) ;
			user.setAddress2(address2);
			user.setBirthday(birthday);
			user.setPhoneNumber(phoneNumber) ;
			user.setMail(mail);
			user.setAuthority(authority);
			user.setInsertedOn(insertedOn) ;

			// DAOクラスのinsert()メソッドを利用し、各取得パラメータをDBに登録
			userDao.insert(user);

		}catch (IllegalStateException e) {
			error = "DB接続エラーの為、会員登録処理は行えませんでした。";
			cmd = "list";
		}catch(SQLException e) {
			error = "";
			cmd = "list";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {		// エラーが無い場合
				return;
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
