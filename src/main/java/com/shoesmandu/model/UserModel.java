package com.shoesmandu.model;

/**
 * UserModel Class
 * This class represents a User entity in the system.
 * It is used to transfer user data between layers (Controller ↔ Service ↔ DAO).
 */
public class UserModel {
	
	

    //  Unique ID for each user (Primary Key in database)
    private int userID;

    //  User's first name
    private String userFirstName;

    //  User's last name
    private String userLastName;

    //  User's email (used for login)
    private String userEmail;

    //  User's password (stored as hashed value)
    private String userPassword;

    //  User's phone number
    private String userPhone;

    //  User's address
    private String userAddress;

    //  Role of user (admin / user)
    private String role;

    // Account status (pending / active / rejected / blocked)
    private String status;

    // Profile image path or filename
    private String userImageURL;
    
    

    public UserModel(int userID, String userFirstName, String userLastName, String userEmail, String userPassword,
			String userPhone, String userAddress, String role, String status, String userImageURL) {
		super();
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

	//  GETTERS & SETTERS 

    /**
     * Get user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set user ID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get first name
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Set first name
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    /**
     * Get last name
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * Set last name
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    /**
     * Get email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Set email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Get password (hashed)
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Set password ( hashed before saving)
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Get phone number
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * Set phone number
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Get address
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * Set address
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * Get user role (admin/user)
     */
    public String getRole() {
        return role;
    }

    /**
     * Set user role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get account status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set account status (pending/active/rejected/blocked)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get profile image URL
     */
    public String getUserImageURL() {
        return userImageURL;
    }

    /**
     * Set profile image URL
     */
    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}