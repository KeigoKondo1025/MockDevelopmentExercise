package bean;

public class Item {

	private int itemId; // 商品ID
	private String itemName; // 商品名
	private int categoryId; // カテゴリID
	private int price; // 価格
	private String image1; // 商品画像1
	private String image2; // 商品画像2
	private String image3; // 商品画像3
	private String image4; // 商品画像4
	private int itemState; // 商品の状態
	private int sellerId; // 出品者ユーザーID
	private String sellerMessage; // 出品者メッセージ
	private int prefectureId; // 都道府県ID
	private boolean deleteFlag; // 出品取り下げフラグ
	private int itemSituation; // 取引の状態
	private int buyerId; // 購入者ユーザーID
	private String boughtTime; // 購入時刻
	private String insertedTime; // 出品時刻

	public Item() {
		this.itemId = 0;
		this.itemName = null;
		this.categoryId = 0;
		this.price = 0;
		this.image1 = null;
		this.image2 = null;
		this.image3 = null;
		this.image4 = null;
		this.itemState = 0;
		this.sellerId = 0;
		this.sellerMessage = "";
		this.prefectureId = 0;
		this.deleteFlag = false;
		this.itemSituation = 0;
		this.buyerId = 0;
		this.boughtTime = null;
		this.insertedTime = null;
	}


	// ここからゲッター
	public int getItemId() {
		return this.itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public int getPrice() {
		return this.price;
	}

	public String getImage1() {
		return this.image1;
	}

	public String getImage2() {
		return this.image2;
	}

	public String getImage3() {
		return this.image3;
	}

	public String getImage4() {
		return this.image4;
	}

	public int getItemState() {
		return this.itemState;
	}

	public int getSellerId() {
		return this.sellerId;
	}

	public String getSellerMessage() {
		return this.sellerMessage;
	}

	public int getPrefectureId() {
		return this.prefectureId;
	}

	public boolean getDeleteFlag() {
		return this.deleteFlag;
	}

	public int getItemSituation() {
		return this.itemSituation;
	}

	public int getBuyerId() {
		return this.buyerId;
	}

	public String getBoughtTime() {
		return this.boughtTime;
	}

	public String getInsertedTime() {
		return this.insertedTime;
	}

	// ここからセッター
	public void setItemId(int itemId) {
		itemId =  this.itemId;
	}

	public void setItemName(String itemName) {
		itemName =  this.itemName;
	}

	public void setCategoryId(int categoryId) {
		categoryId =  this.categoryId;
	}

	public void setPrice(int price) {
		price =  this.price;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public void setItemState(int itemState) {
		this.itemState = itemState;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public void setSellerMessage(String sellerMessage) {
		 this.sellerMessage = sellerMessage;
	}

	public void setPrefectureId(int prefectureId) {
		this.prefectureId = prefectureId;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setItemSituation(int itemSituation) {
		this.itemSituation = itemSituation;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public void setBoughtTime(String boughtTime) {
		this.boughtTime = boughtTime;
	}

	public void setInsertedTime(String insertedTime) {
		this.insertedTime = insertedTime;
	}
}
