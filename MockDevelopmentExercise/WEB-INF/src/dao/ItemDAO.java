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
				item.setImage4(rs.getString("image_4"));
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
	public ArrayList<Item> select(String sellerId,String buyerId, String price, String itemSituation){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;


		String sql = "select * from items_tb where seller_user_id like '%" + sellerId +
				"%' and  (buyer_user_id like '%" + buyerId + "%' or buyer_user_id IS NULL ) and price like '%" + price +
				"%' and item_situation like '%" + itemSituation + "%'";

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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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

	//カテゴリ、商品名、値段の最小値、最大値、出品地域で指定した条件の商品を全て検索するメソッド
	public ArrayList<Item> select(int category, String itemName, int minPrice, int maxPrice, int prefectureId){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		String sql;

		if(category == 0) {
			if(prefectureId == 0) {
				sql = "select * from items_tb where item_name like '%" + itemName +
						"%' and (price between " + minPrice + " and " + maxPrice +
						") and item_situation = 0";
			} else {
				sql = "select * from items_tb where item_name like '%" + itemName +
						"%' and (price between " + minPrice + " and " + maxPrice +
						") and prefecture_id = " + prefectureId + " and item_situation = 0";
			}
		}else {
			if(prefectureId == 0) {
				sql = "select * from items_tb where category_id = " + category +
						" and item_name like '%" + itemName +
						"%' and (price between " + minPrice + " and " + maxPrice +
						") and item_situation = 0";
			} else {
				sql = "select * from items_tb where category_id = " + category +
						" and item_name like '%" + itemName +
						"%' and (price between " + minPrice + " and " + maxPrice +
						") and prefecture_id = " + prefectureId + " and item_situation = 0";
			}
		}

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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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

	//値段の最小値、最大値、出品状況で指定した条件の商品を全て検索するメソッド
	public ArrayList<Item> select(int minPrice, int maxPrice, int itemSituation){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		String sql;

		if(itemSituation != -1) {
			sql = "select * from items_tb where (price between " + minPrice + " and " + maxPrice +
					") and item_situation = " + itemSituation;
		} else {
			sql = "select * from items_tb where (price between " + minPrice + " and " + maxPrice +
					")";
		}

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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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

	//指定されたitemIdの商品を検索するメソッド
	public Item selectByItemId(int itemId){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from items_tb where item_id = " + itemId + "";

		//結果を格納する変数
		Item item = new Item();

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()) {
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setPrice(rs.getInt("price"));
				item.setImage1(rs.getString("image_1"));
				item.setImage2(rs.getString("image_2"));
				item.setImage3(rs.getString("image_3"));
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
				item.setDeleteFlag(rs.getBoolean("is_sent_deleted"));
				item.setItemSituation(rs.getInt("item_situation"));
				item.setBuyerId(rs.getInt("buyer_user_id"));
				item.setBoughtTime(rs.getString("bought_at"));
				item.setInsertedTime(rs.getString("inserted_at"));
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
		return item;
	}

	//指定されたuserIdと一致するbuyerIdを持つ検索するメソッド
	public ArrayList<Item> selectBuyerId(int userId){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from items_tb where buyer_user_id = " + userId + "";

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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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

	//最新の商品情報を検索するメソッド
	public int newItemId(){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "SELECT item_id FROM items_tb ORDER BY item_id DESC LIMIT 1";

		int itemId = 0;

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()) {
				itemId = rs.getInt("item_id");
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
		return itemId;
	}

	//指定されたuserIdと一致するsellerIdを持つ商品を検索するメソッド
	public ArrayList<Item> selectSellerId(int userId){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from items_tb where seller_user_id = " + userId + "";

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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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

	//出品中の商品を全て検索するメソッド
	public ArrayList<Item> selectSales(){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select * from items_tb where item_situation = 0";
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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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

	//出品中の商品から重複する出品者情報を含まない出品者IDを検索するメソッド
	public ArrayList<Integer> selectSellerList(){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "select item_situation,seller_user_id from items_tb group by item_situation,seller_user_id having item_situation = 0";
		//結果を格納する変数
		ArrayList<Integer> sellerIdList = new ArrayList<Integer>();

		try {
			con = ItemDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()) {
				int sellerId = rs.getInt("seller_user_id");
				sellerIdList.add(sellerId);
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
		return sellerIdList;
	}

	//購入済みの商品から引数の値で検索するメソッド
	public ArrayList<Item> selectSales(ArrayList<Integer> sellerId, int categoryId, ArrayList<Integer> buyerId){
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;
		String sql;

		//sql文を文字列で設定
		if(categoryId != 0) {//カテゴリIDが0以外の場合
			sql = "select * from items_tb where (";
			//対象の出品者Idを全てsql文に含む
			for(int i = 0; i < sellerId.size(); i++) {
				sql += "seller_user_id = " + sellerId.get(i);
				if(i != sellerId.size()-1) {
				sql += " or ";
				} else {
					sql += ") and (";
				}
			};
			//対象の購入者IDを全てsql文に含む
			for(int i = 0; i < buyerId.size(); i++) {
				sql += "buyer_user_id = " + buyerId.get(i);
				if(i != sellerId.size()-1) {
				sql += " or ";
				} else {
					sql += ") and ";
				}
			};
			sql += "item_situation = 3 and category_id = " + categoryId;
		} else {//カテゴリIDが0の場合
			sql = "select * from items_tb where (";
			//対象の出品者Idを全てsql文に含む
			for(int i = 0; i < sellerId.size(); i++) {
				sql += "seller_user_id = " + sellerId.get(i);
				if(i != sellerId.size()-1) {
				sql += " or ";
				} else {
					sql += ") and (";
				}
			};
			//対象の購入者IDを全てsql文に含む
			for(int i = 0; i < buyerId.size(); i++) {
				sql += "buyer_user_id = " + buyerId.get(i);
				if(i != sellerId.size()-1) {
				sql += " or ";
				} else {
					sql += ") and ";
				}
			};
			sql += " item_situation = 0";
		};
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
				item.setImage4(rs.getString("image_4"));
				item.setItemState(rs.getInt("item_state"));
				item.setSellerId(rs.getInt("seller_user_id"));
				item.setSellerMessage(rs.getString("seller_message"));
				item.setPrefectureId(rs.getInt("prefecture_id"));
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
				"'," + item.getPrefectureId() + "," + item.getDeleteFlag() +
				"," + item.getItemSituation() + ",null" +
				",now(),now())";


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

	//指定されたitemidの削除フラグを変更するメソッド
	public int updateDelete(int itemId,boolean deleteFlag) {
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//itemSituation変更管理用変数
		int itemSituation = 0;

		//受けとったdeleteFlagを変更する
		if(deleteFlag == true) {
			deleteFlag = false;
			itemSituation = 0;
		}else {
			deleteFlag = true;
			itemSituation = 4;
		}

		//sql文を文字列で設定
		String sql = "update items_tb set is_sent_deleted = " + deleteFlag +
				", item_situation = " + itemSituation + " where item_id = " + itemId;

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

	//指定されたitemIdの購入者idと商品状況を変更するメソッド(商品状況が1になる場合)
	public int updateBuyerId(int itemId,int buyerId) {
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "update items_tb set buyer_user_id = " + buyerId +
				", item_situation = 1 where item_id = " + itemId;

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

	//指定されたitemidの取引の状態を変更するメソッド(0:出品中,1:入金待ち,2:発送待ち,3:取引済,4:取り下げ)
	public int updateItemSituation(int itemId,int itemSituation) {
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "update items_tb set item_situation = " + itemSituation +
				" where item_id = " + itemId;

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

	//指定されたitemIdの購入日時と取引の状態を変更するメソッド(
	public int updateBoughtTime(int itemId,int itemSituation) {
		//データベース接続に利用する変数
		Connection con = null;
		Statement smt = null;

		//sql文を文字列で設定
		String sql = "update items_tb set item_situation = " + itemSituation +
				", bought_at = current_timestamp where item_id = '" + itemId + "'";

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
