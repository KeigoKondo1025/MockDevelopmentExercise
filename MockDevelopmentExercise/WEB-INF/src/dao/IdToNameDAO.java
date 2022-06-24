package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.User;

public class IdToNameDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/vicon_db";
	private static String USER = "root";
	private static String PASSWD = "root123";


	/*
	 * ＠メソッド名：getConnection
	 * ＠説明 ：DBと接続するメソッド
	 * ＠引数 ：無し
	 * ＠戻り値 ：－
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
	 * ＠メソッド名：prefectureIdToName
	 * ＠説明 ：DBからIDに対応する都道府県名を返すメソッド
	 * ＠引数 ：int
	 * ＠戻り値 ：都道府県名 String
	 */
	public String prefectureIdToName(int prefectureId) {

		Connection con = null;
		Statement smt = null;

		try {
			// DBに接続するgetConnectionメソッドの呼び出し
			con = getConnection();

			// SQL文の作成
			String sql = "SELECT prefecture_name FROM prefectures_tb WHERE prefecture_id = " + prefectureId;

			// SQL文を送信するための準備
			smt = con.createStatement();
			String prefecture = "";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				prefecture = rs.getString("prefecture_name");//都道府県名を格納
			}

			return prefecture;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}finally{
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}	// オブジェクトsmtからリソースを解放（DBとの接続を切る）
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}	// オブジェクトconからリソースを解放（DBとの接続を切る）
			}
		}

	}

	/*
	 * ＠メソッド名：categoryIdToName
	 * ＠説明 ：DBからIDに対応するカテゴリー名を返すメソッド
	 * ＠引数 ：int
	 * ＠戻り値 ：カテゴリー名 String
	 */
	public String categoryIdToName(int categoryId) {

		Connection con = null;
		Statement smt = null;

		try {
			// DBに接続するgetConnectionメソッドの呼び出し
			con = getConnection();

			// SQL文の作成
			String sql = "SELECT category FROM categories_tb WHERE category_id = " + categoryId;

			// SQL文を送信するための準備
			smt = con.createStatement();
			String category = "";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				category = rs.getString("category");//カテゴリー名を格納
			}

			return category;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}finally{
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}	// オブジェクトsmtからリソースを解放（DBとの接続を切る）
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}	// オブジェクトconからリソースを解放（DBとの接続を切る）
			}
		}

	}






}
