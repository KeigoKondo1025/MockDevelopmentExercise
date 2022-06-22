package bean;

import java.util.*;

public class User {
	private int userId;
	private String userName;
	private String passWord;
	private String familyName;
	private String firstName;
	private int gender;
	private String postal_code;
	private int prefecture_id;
	private String address1;
	private String address2;
	private Date birthday;
	private String phoneNumber;
	private String mail;
	private int authority;
	private Date insertedOn;
	private boolean isUserDeleted;
	private boolean isUserBanned;
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
	 * @return postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}
	/**
	 * @param postal_code セットする postal_code
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	/**
	 * @return prefecture_id
	 */
	public int getPrefecture_id() {
		return prefecture_id;
	}
	/**
	 * @param prefecture_id セットする prefecture_id
	 */
	public void setPrefecture_id(int prefecture_id) {
		this.prefecture_id = prefecture_id;
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
	public boolean isUserDeleted() {
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
	public boolean isUserBanned() {
		return isUserBanned;
	}
	/**
	 * @param isUserBanned セットする isUserBanned
	 */
	public void setUserBanned(boolean isUserBanned) {
		this.isUserBanned = isUserBanned;
	}


}
