package dao;

import java.sql.*;
import java.util.*;

public class FavoriteDAO {
	//データベースに接続する為の変数
	private static String RDB_DRIVE="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost/vicon_db";
	private static String USER="root";
	private static String PASSWD="root123";

	//データベースに接続するメソッド
	public static Connection getConnection(){
		try{
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	//指定されたuserIdのitemIdを検索するメソッド
	public ArrayList<Integer> selectByUserId(int userId){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from favorites_tb where user_id = " + userId + "";

		//結果を格納する変数
		ArrayList<Integer> itemIdList = new ArrayList<Integer>();

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()) {
				int itemId = rs.getInt("item_id");

				itemIdList.add(itemId);
			}

		} catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return itemIdList;
	}

	//データベースにお気に入り情報を登録するメソッド
	public int insert(int userId, int itemId) {
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "insert into favorites_tb values(null," + userId + "," + itemId + ")";

		//結果を格納する変数
		int count = 0;

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			count = smt.executeUpdate(sql);


		} catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return count;
	}

	// お気に入りを削除するメソッド
	public void delete(int favoriteId) {
		// 変数の宣言
		Connection con = null;
		Statement smt = null;
		// SQL文を文字列として定義
		String sql = "delete from favorites_tb where favorite_id = " + favoriteId ;

		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文の送信とデータの削除
			smt.executeUpdate(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ingore) {
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
