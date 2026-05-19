package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;

/**
 * AdminuserDAO handles database operations
 * related to user management for the admin panel
 * in the Shoesmandu system.
 * 
 * It provides functionalities such as:
 * 1. Retrieving all active users
 * 2. Updating user account status
 * 
 * This DAO interacts with the user table
 * in the database.

 */
public class AdminuserDAO {

	/**
	 * Retrieves all users except deleted users
	 * from the database.
	 * 
	 * This method fetches user details and stores
	 * them into a list of UserModel objects.
	 * 
	 * @return List<UserModel> containing all non-deleted users
	 */
	public List<UserModel> getAllUsers() {

		List<UserModel> users = new ArrayList<>();

		String sql = "SELECT * FROM user WHERE status != ?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			// EXCLUDE DELETED USERS
			pst.setString(1, "deleted");

			ResultSet rs = pst.executeQuery();

			// LOOP THROUGH ALL USERS
			while (rs.next()) {

				UserModel user = new UserModel();

				user.setUserID(rs.getInt("user_id"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserLastName(rs.getString("user_last_name"));
				user.setUserEmail(rs.getString("user_email"));
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

	/**
	 * Updates the status of a user account.
	 * 
	 * This method is used for:
	 * - Approving users
	 * - Rejecting users
	 * - Blocking users
	 * - Activating users
	 * 
	 * @param userId the ID of the user
	 * @param status the new account status
	 */
	public void updateUserStatus(int userId, String status) {

		String sql = "UPDATE user SET status = ? WHERE user_id = ?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			// SET STATUS
			pst.setString(1, status);

			// SET USER ID
			pst.setInt(2, userId);

			// EXECUTE UPDATE
			pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}