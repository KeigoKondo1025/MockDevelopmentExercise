package bean;

import java.util.*;

public class User {
	private int userId;			//ユーザーid
	private String userName;		//ユーザー名
	private String passWord;		//パスワード
	private String familyName; 	//苗字
	private String firstName;  	//名前
	private int gender;			//性別
	private String postalCode;	//郵便番号
	private int prefectureId;		//都道府県id
	private String address1;		//住所1
	private String address2;		//住所2
	private Date birthday;			//生年月日
	private String phoneNumber;	//電話番号
	private String mail;			//メールアドレス
	private int authority;			//権限
	private Date insertedOn;		//登録日時
	private boolean isUserDeleted;//ユーザー削除
	private boolean isUserBanned;//利用停止

	public User() {
		this.userId = 0;
		this.userName = null;
		this.passWord = null;
		this.familyName = null;
		this.firstName = null;
		this.gender = 0;
		this.postalCode = null;
		this.prefectureId = 0;
		this.address1 = null;
		this.address2 = null;
		this.birthday = new Date();
		this.phoneNumber = null;
		this.mail = null;
		this.authority = 0;
		this.insertedOn = new Date();
		this.isUserDeleted = true;
		this.isUserBanned = true;
	}
	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord セットする passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * @param familyName セットする familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return gender
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * @param gender セットする gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode セットする postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return prefectureId
	 */
	public int getPrefectureId() {
		return prefectureId;
	}
	/**
	 * @param prefectureId セットする prefectureId
	 */
	public void setPrefectureId(int prefectureId) {
		this.prefectureId = prefectureId;
	}
	/**
	 * @return address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 セットする address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 セットする address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber セットする phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail セットする mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return authority
	 */
	public int getAuthority() {
		return authority;
	}
	/**
	 * @param authority セットする authority
	 */
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	/**
	 * @return insertedOn
	 */
	public Date getInsertedOn() {
		return insertedOn;
	}
	/**
	 * @param insertedOn セットする insertedOn
	 */
	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}
	/**
	 * @return isUserDeleted
	 */
	public boolean getIsUserDeleted() {
		return isUserDeleted;
	}
	/**
	 * @param isUserDeleted セットする isUserDeleted
	 */
	public void setUserDeleted(boolean isUserDeleted) {
		this.isUserDeleted = isUserDeleted;
	}
	/**
	 * @return isUserBanned
	 */
	public boolean getIsUserBanned() {
		return isUserBanned;
	}
	/**
	 * @param isUserBanned セットする isUserBanned
	 */
	public void setUserBanned(boolean isUserBanned) {
		this.isUserBanned = isUserBanned;
	}


}
