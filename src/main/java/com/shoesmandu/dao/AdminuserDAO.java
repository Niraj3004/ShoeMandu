package com.shoesmandu.dao;

import java.sql.*;
import java.util.*;
import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;

public class AdminuserDAO {

    // GET ALL USERS
	public List<UserModel> getAllUsers() {

	    List<UserModel> users = new ArrayList<>();

	    String sql = "SELECT * FROM user WHERE status != 'deleted'";

	    try (Connection con = DBconfig.getConnection();
	         PreparedStatement pst = con.prepareStatement(sql);
	         ResultSet rs = pst.executeQuery()) {

	        while (rs.next()) {
	            UserModel user = new UserModel();

	            user.setUserID(rs.getInt("user_id"));
	            user.setUserFirstName(rs.getString("user_first_name"));
	            user.setUserLastName(rs.getString("user_last_name"));
	            user.setUserEmail(rs.getString("user_email"));
	            user.setUserPhone(rs.getString("user_phone"));
	            user.setStatus(rs.getString("status"));
	            user.setUserImageURL(rs.getString("user_image_url"));

	            users.add(user);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return users;
	}

    // UPDATE STATUS (approve/reject)
	public void updateUserStatus(int userId, String status) {

	    String sql = "UPDATE user SET status=? WHERE user_id=?";

	    try (Connection con = DBconfig.getConnection();
	         PreparedStatement pst = con.prepareStatement(sql)) {

	        pst.setString(1, status);
	        pst.setInt(2, userId);

	        pst.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

   
}