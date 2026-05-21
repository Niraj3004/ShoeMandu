package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;

/**
 * UserDAO handles all database operations
 * related to users in the Shoesmandu system.
 * 
 * It provides functionalities such as:
 * 1. Registering new users
 * 2. Fetching user by email (login)
 * 3. Retrieving all users for admin dashboard
 * 
 * This DAO interacts with the user table
 * in the database.
 * 
 * @author Nikhil Sah
 */
public class UserDAO {

	/**
	 * Inserts a new user into the database.
	 * 
	 * This method is used during user registration.
	 * 
	 * @param firstName user first name
	 * @param lastName user last name
	 * @param email user email address
	 * @param password encrypted password
	 * @param phone user phone number
	 * @param address user address
	 * @param role user role (admin/user)
	 * @param status account status
	 * @param image profile image path
	 * @throws Exception database error
	 */
	public void insertUser(String firstName, String lastName, String email,
			String password, String phone,
			String address, String role,
			String status, String image) throws Exception {

		String sql = "INSERT INTO user "
				+ "(user_first_name, user_last_name, user_email, user_password, "
				+ "user_phone, user_address, role, status, user_image_url) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.setString(5, phone);
			pst.setString(6, address);
			pst.setString(7, role);
			pst.setString(8, status);
			pst.setString(9, image);

			// EXECUTE INSERT
			pst.executeUpdate();
		}
	}

	/**
	 * Retrieves a user by email for authentication.
	 * 
	 * This method is mainly used during login.
	 * 
	 * @param email user email
	 * @return UserModel if found, otherwise null
	 * @throws Exception database error
	 */
	public UserModel getUserByEmail(String email) throws Exception {

		String sql = "SELECT * FROM user WHERE user_email = ?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			// SET EMAIL PARAMETER
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				UserModel user = new UserModel();

				user.setUserID(rs.getInt("user_id"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserLastName(rs.getString("user_last_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserAddress(rs.getString("user_address"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				user.setUserImageURL(rs.getString("user_image_url"));

				return user;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves all users from the database.
	 * 
	 * This method is used in the admin dashboard
	 * to display user list.
	 * 
	 * @return List<UserModel> containing all users
	 * @throws Exception database error
	 */
	public List<UserModel> getAllUsers() throws Exception {

		List<UserModel> users = new ArrayList<>();

		String sql = "SELECT * FROM user";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			// LOOP THROUGH USERS
			while (rs.next()) {

				UserModel user = new UserModel();

				user.setUserID(rs.getInt("user_id"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserLastName(rs.getString("user_last_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserAddress(rs.getString("user_address"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				user.setUserImageURL(rs.getString("user_image_url"));

				// ADD USER TO LIST
				users.add(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return users;
	}
	
	 public boolean isEmailExists(String email) {

		    String query = "SELECT * FROM user WHERE user_email = ?";

		    try (Connection conn = DBconfig.getConnection();
		         PreparedStatement ps = conn.prepareStatement(query)) {

		        ps.setString(1, email);

		        ResultSet rs = ps.executeQuery();

		        return rs.next();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return false;
		}
}