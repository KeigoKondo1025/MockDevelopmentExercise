package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.User;

public class UserDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/vicon_db";
	private static String USER = "root";
	private static String PASSWD = "root123";

	/*
	 * ＠メソッド名：getConnection ＠説明 ：DBと接続するメソッド ＠引数 ：無し ＠戻り値 ：－
	 */
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE); // JDBCドライバの読み込み
			Connection con = DriverManager.getConnection(URL, USER, PASSWD); // DB接続
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/*
	 * ＠メソッド名：selectAll ＠説明 ：DBからすべてのユーザ情報を検索するメソッド ＠引数 ：無し ＠戻り値
	 * ：全件分の書籍情報を格納したUser型ArrayList
	 */
	public ArrayList<User> selectAll() {
		// User型オブジェクトを格納するためのArrayListの作成
		ArrayList<User> userList = new ArrayList<User>();

		Connection con = null;
		Statement smt = null;

		try {
			// DBに接続するgetConnectionメソッドの呼び出し
			con = getConnection();

			// SQL文の作成
			String sql = "SELECT * FROM users_tb ORDER BY user_id";

			// SQL文を送信するための準備
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			// DBから取得した件数の分、User型オブジェクトを作成し、１件分の書籍情報を格納することを繰り返す
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("password"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setGender(rs.getInt("gender"));
				user.setPostalCode(rs.getString("postal_code"));
				user.setPrefectureId(rs.getInt("prefecture_id"));
				user.setAddress1(rs.getString("address1"));
				user.setAddress2(rs.getString("address2"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setMail(rs.getString("mail"));
				user.setAuthority(rs.getInt("authority"));
				user.setInsertedOn(rs.getDate("inserted_on"));
				user.setUserDeleted(rs.getBoolean("is_user_deleted"));
				user.setUserBanned(rs.getBoolean("is_user_banned"));

				// 1件分の書籍情報を格納したBookオブジェクトをArrayListの1要素に格納
				userList.add(user);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				} // オブジェクトsmtからリソースを解放（DBとの接続を切る）
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				} // オブジェクトconからリソースを解放（DBとの接続を切る）
			}
		}
		return userList;

	}

	/*
	 * ＠メソッド名：searchByUserId
	 * ＠説明 ：指定ユーザーIDをもとにDBからユーザ情報を取得するメソッド
	 * ＠引数 ：ユーザID（Int userId)
	 * ＠戻り値 ：User user(Userオブジェクト）
	 */
	public User searchByUserId(int userId){
		// 変数宣言
		Connection con = null;	// DBコネクション
		Statement smt = null;	// SQLステートメント

		// ISBNによる検索用のSQL文を文字列として定義
		String sql = "SELECT * FROM users_tb WHERE user_id ='" + userId + "'";

		// オブジェクト化
		User user = new User();

		try {
			// getConnection()メソッドを利用し、DBに接続
			con = getConnection();

			// SQL文を送信するための準備
			smt = con.createStatement();

			// SQL文を発行し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットから書籍データを取り出し、オブジェクトuserに格納
			if(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("password"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setGender(rs.getInt("gender"));
				user.setPostalCode(rs.getString("postal_code"));
				user.setPrefectureId(rs.getInt("prefecture_id"));
				user.setAddress1(rs.getString("address1"));
				user.setAddress2(rs.getString("address2"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setMail(rs.getString("mail"));
				user.setAuthority(rs.getInt("authority"));
				user.setInsertedOn(rs.getDate("inserted_on"));
				user.setUserDeleted(rs.getBoolean("is_user_deleted"));
				user.setUserBanned(rs.getBoolean("is_user_banned"));
			}

		}catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {smt.close();} catch (SQLException ignore) {}
			}
			if (con != null) {
				try {con.close();} catch (SQLException ignore) {}
			}
		}
		return user;
	}

	/*
	 * ＠メソッド名：search ＠説明 ：DBから指定ユーザーの条件に合致する情報を取得するメソッド ＠引数 ：メールアドレス（String
	 * mail）とパスワード（String password） ＠戻り値 ：User user(Userオブジェクト）
	 */
	public User search(String mail, String password) {
		// 変数宣言
		Connection con = null; // DBコネクション
		Statement smt = null; // SQLステートメント

		// ISBNによる検索用のSQL文を文字列として定義
		String sql = "SELECT * FROM users_tb WHERE mail ='" + mail + "' AND password = '" + password + "'";

		// オブジェクト化
		User user = new User();

		try {
			// getConnection()メソッドを利用し、DBに接続
			con = getConnection();

			// SQL文を送信するための準備
			smt = con.createStatement();

			// SQL文を発行し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				// 結果セットから書籍データを取り出し、オブジェクトuserに格納
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("password"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setGender(rs.getInt("gender"));
				user.setPostalCode(rs.getString("postal_code"));
				user.setPrefectureId(rs.getInt("prefecture_id"));
				user.setAddress1(rs.getString("address1"));
				user.setAddress2(rs.getString("address2"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setMail(rs.getString("mail"));
				user.setAuthority(rs.getInt("authority"));
				user.setInsertedOn(rs.getDate("inserted_on"));
				user.setUserDeleted(rs.getBoolean("is_user_deleted"));
				user.setUserBanned(rs.getBoolean("is_user_banned"));
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return user;
	}

	/*
	 * ＠メソッド名：searchByUserName
	 * ＠説明 ：DBからユーザー名であいまい検索をしたuserIdを返すメソッド
	 * ＠引数 ：String型のuserName
	 * ＠戻り値：int型のuserId
	 */
	public ArrayList<Integer> searchByUserName(String userName) {
		// 戻り値のuserIdを格納する変数
		ArrayList<Integer> userIdList = new ArrayList<Integer>();

		Connection con = null;
		Statement smt = null;

		try {
			// DBに接続するgetConnectionメソッドの呼び出し
			con = getConnection();

			// SQL文の作成
			String sql = "SELECT user_id FROM users_tb while user_name like '%" + userName + "%'";

			// SQL文を送信するための準備
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			//
			while (rs.next()) {
				userIdList.add(rs.getInt("user_id"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				} // オブジェクトsmtからリソースを解放（DBとの接続を切る）
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				} // オブジェクトconからリソースを解放（DBとの接続を切る）
			}
		}
		return userIdList;
	}

	/*
	 * ＠メソッド名：insert ＠説明 ：新しいユーザ情報をDBに登録するメソッド ＠引数 ：登録する書籍データを格納したBookオブジェクト ＠戻り値
	 * ：無し
	 */
	public void insert(User user) {

		Connection con = null;
		Statement smt = null;

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// 書籍情報を登録するSQL文を、文字列として変数sqlに格納
			String sql = "INSERT INTO users_tb VALUES(" + null + ",'" + user.getUserName() + "','"
					+ user.getPassWord() + "','" + user.getFamilyName() + "','" + user.getFirstName() + "',"
					+ user.getGender() + ",'" + user.getPostalCode() + "'," + user.getPrefectureId() + ",'"
					+ user.getAddress1() + "','" + user.getAddress2() + "','" + dateFormat.format(user.getBirthday()) + "','"
					+ user.getPhoneNumber() + "','" + user.getMail() + "'," + user.getAuthority() + ", now(),"
					+ user.getIsUserDeleted() + "," + user.getIsUserBanned() + ")";

			// DBに接続するgetConnectionメソッドの呼び出し
			con = getConnection();

			// SQL文を送信するための準備
			smt = con.createStatement();

			// SQL文を発行し、書籍データを登録（メソッドの戻り値は処理件数を示すint型の値）
			int rowsCount = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				} // オブジェクトsmtからリソースを解放（DBとの接続を切る）
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				} // オブジェクトconからリソースを解放（DBとの接続を切る）
			}
		}
	}

	/*
	 * ＠メソッド名：update ＠説明 ：指定されたユーザIDに該当するユーザ情報を更新するメソッド ＠引数 ：User型のオブジェクトuser ＠戻り値
	 * ：無し
	 */
	public int update(User user) {
		Connection con = null;
		Statement smt = null;

		// 更新件数を格納するint型変数の初期化
		int rowsCount = 0;

		try {
			// 更新用のSQL文を文字列として格納
			String sql = "UPDATE user_tb SET user_name='" + user.getUserName() + "',password = '" + user.getPassWord()
					+ "',family_name = '" + user.getFamilyName() + "',first_name = '" + user.getFirstName()
					+ "',gender = " + user.getGender() + ",postal_code = '" + user.getPostalCode()
					+ "',prefecture_id = " + user.getPrefectureId() + ",address1 = '" + user.getAddress1()
					+ "',address2 = '" + user.getAddress2() + "',birthday = " + user.getBirthday() + ",phone_number = '"
					+ user.getPhoneNumber() + "',mail = '" + user.getMail() + "',authority = " + user.getAuthority()
					+ "',inserted_on = " + user.getInsertedOn() + "',is_user_deleted = " + user.getIsUserDeleted()
					+ ",is_user_banned = " + user.getIsUserBanned() + " WHERE user_id = '" + user.getUserId() + "'";

			// メソッドを利用してDBに接続
			con = getConnection();

			// SQL文作成の準備
			smt = con.createStatement();

			// SQL文を発行し、書籍データを更新
			rowsCount = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		return rowsCount;
	}

	/*
	 * ＠メソッド名：delete ＠説明 ：DBからユーザデータを削除するメソッド ＠引数 ：削除するユーザ情報を格納したUser型オブジェクト ＠戻り値
	 * ：無し
	 */
	public void delete(User user) {
		Connection con = null;
		Statement smt = null;

		// 削除用のSQL文を文字列として定義
		String sql = "DELETE FROM bookinfo WHERE user_id = '" + user.getUserId() + "'";

		try {
			// getConnection(Dメソッドを利用し、DBに接続
			con = getConnection();

			// SQL文を送信するための準備
			smt = con.createStatement();

			// SQL文を発行し、書籍データを削除します。
			int rowsCount = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}
