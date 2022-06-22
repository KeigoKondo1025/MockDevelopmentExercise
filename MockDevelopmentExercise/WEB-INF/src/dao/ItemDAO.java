package dao;

import java.sql.*;
import java.util.*;

import bean.Item;

public class ItemDAO {
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

	//商品を全て検索するメソッド
	public ArrayList<Item> selectAll(){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from items_tb";

		//結果を格納する変数
		ArrayList<Item> itemList = new ArrayList<Item>();

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setPrice(rs.getInt("price"));
				item.setImage1(rs.getString("image_1"));
				item.setImage2(rs.getString("image_2"));
				item.setImage3(rs.getString("image_3"));
				item.setImage4(rs.getString("image4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setDeleteFlag(rs.getBoolean("is_sent_deleted"));
				item.setItemSituation(rs.getInt("item_situation"));
				item.setBuyerId(rs.getInt("buyer_user_id"));
				item.setBoughtTime(rs.getString("bought_at"));
				item.setInsertedTime(rs.getString("inserted_at"));

				itemList.add(item);
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
		return itemList;
	}

	//指定された条件の商品を全て検索するメソッド
	public ArrayList<Item> select(){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from items_tb";

		//結果を格納する変数
		ArrayList<Item> itemList = new ArrayList<Item>();

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setPrice(rs.getInt("price"));
				item.setImage1(rs.getString("image_1"));
				item.setImage2(rs.getString("image_2"));
				item.setImage3(rs.getString("image_3"));
				item.setImage4(rs.getString("image4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setDeleteFlag(rs.getBoolean("is_sent_deleted"));
				item.setItemSituation(rs.getInt("item_situation"));
				item.setBuyerId(rs.getInt("buyer_user_id"));
				item.setBoughtTime(rs.getString("bought_at"));
				item.setInsertedTime(rs.getString("inserted_at"));

				itemList.add(item);
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
		return itemList;
	}

	//データベースに商品を登録するメソッド
	public int insert(Item item) {
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "insert into items_tb values(" + item.getItemId() +
				",'" + item.getItemName() + "'," + item.getCategoryId() +
				"," + item.getPrice() + ",'" + item.getImage1() +
				"','" + item.getImage2() + "','" + item.getImage3() +
				"','" + item.getImage4() + "'," + item.getItemState() +
				"," + item.getSellerId() + ",'" + item.getSellerMessage() +
				"'," + item.getPrefectureId() + ",'" + item.getDeleteFlag() +
				"'," + item.getItemSituation() + "," + item.getBuyerId() +
				",'" + item.getBoughtTime() + "','" + item.getInsertedTime() +
				"')";

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


}