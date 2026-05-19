package com.shoesmandu.model;

/**
 * UserModel represents a user in the Shoesmandu system.
 * 
 * It stores user-related information such as
 * user ID, first name, last name, email,
 * password, phone number, address, role,
 * account status, and profile image URL.
 * 
 * This model is used for user registration,
 * authentication, profile management,
 * and role-based access control.
 * 
 * @author Nikhil Sah
 */
public class UserModel {

	// VARIABLES

	private int userID;

	private String userFirstName;

	private String userLastName;

	private String userEmail;

	private String userPassword;

	private String userPhone;

	private String userAddress;

	private String role;

	private String status;

	private String userImageURL;

	/**
	 * Default constructor for UserModel.
	 */
	public UserModel() {

	}

	/**
	 * Parameterized constructor for UserModel.
	 * 
	 * @param userID the unique user ID
	 * @param userFirstName the first name of the user
	 * @param userLastName the last name of the user
	 * @param userEmail the email address of the user
	 * @param userPassword the password of the user
	 * @param userPhone the phone number of the user
	 * @param userAddress the address of the user
	 * @param role the role of the user
	 * @param status the account status of the user
	 * @param userImageURL the profile image URL of the user
	 */
	public UserModel(int userID, String userFirstName, String userLastName,
			String userEmail, String userPassword,
			String userPhone, String userAddress,
			String role, String status, String userImageURL) {

		this.userID = userID;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.role = role;
		this.status = status;
		this.userImageURL = userImageURL;
	}

	/**
	 * @return the unique user ID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the user ID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the first name of the user
	 */
	public String getUserFirstName() {
		return userFirstName;
	}

	/**
	 * @param userFirstName the first name to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	/**
	 * @return the last name of the user
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * @param userLastName the last name to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * @return the email address of the user
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the email address to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the password of the user
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the password to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the phone number of the user
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone the phone number to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return the address of the user
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the address to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the role of the user
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the user role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the account status of the user
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the account status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the profile image URL of the user
	 */
	public String getUserImageURL() {
		return userImageURL;
	}

	/**
	 * @param userImageURL the profile image URL to set
	 */
	public void setUserImageURL(String userImageURL) {
		this.userImageURL = userImageURL;
	}
}