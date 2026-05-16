package com.shoesmandu.model;

/**
 * UserModel Class This class stores user information.
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

	// DEFAULT CONSTRUCTOR

	public UserModel() {

	}

	// PARAMETERIZED CONSTRUCTOR

	public UserModel(int userID, String userFirstName, String userLastName, String userEmail, String userPassword,
			String userPhone, String userAddress, String role, String status, String userImageURL) {

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


	// GETTERS & SETTERS

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserImageURL() {
		return userImageURL;
	}

	public void setUserImageURL(String userImageURL) {
		this.userImageURL = userImageURL;
	}
}