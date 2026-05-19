package com.shoesmandu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;
import com.shoesmandu.util.PasswordUtil;

/**
 * LoginService handles user authentication
 * for the Shoesmandu system.
 * 
 * It verifies:
 * 1. User email existence
 * 2. Password correctness (hashed comparison)
 * 3. Returns complete user details on success
 * 
 * This service interacts directly with the user
 * table and uses PasswordUtil for secure
 * password verification.
 */
public class LoginService {

	/**
	 * Authenticates a user based on email and password.
	 * 
	 * @param userModel object containing login credentials
	 * @return UserModel if authentication succeeds, otherwise null
	 */
	public UserModel loginUser(UserModel userModel) {

		String sql = "SELECT * FROM user WHERE user_email = ?";

		try (Connection conn = DBconfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			// SET EMAIL
			stmt.setString(1, userModel.getUserEmail());

			ResultSet rs = stmt.executeQuery();

			// CHECK IF USER EXISTS
			if (rs.next()) {

				// GET STORED HASHED PASSWORD
				String dbPassword = rs.getString("user_password");

				// VERIFY PASSWORD
				boolean isMatch = PasswordUtil.checkPassword(userModel.getUserPassword(), dbPassword);

				if (isMatch) {

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
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
}