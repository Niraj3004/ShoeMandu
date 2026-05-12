package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;

public class UserProfileDAO {

    /**
     * Update user profile information in database
     * 
     * @param user  UserModel object containing updated user details
     * @return true if update successful, false otherwise
     */
    public boolean updateUserProfile(UserModel user) {

        // SQL query to update user details based on user_id (primary key)
        String sql = "UPDATE user SET user_first_name=?, user_last_name=?, user_phone=?, user_address=?, user_image_url=? WHERE user_id=?";

        // try-with-resources  automatically closes connection and statement
        try (Connection con = DBconfig.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set updated values from UserModel
            pst.setString(1, user.getUserFirstName());   // first name
            pst.setString(2, user.getUserLastName());    // last name
            pst.setString(3, user.getUserPhone());       // phone number
            pst.setString(4, user.getUserAddress());     // address
            pst.setString(5, user.getUserImageURL());    // profile image path
            pst.setInt(6, user.getUserID());             // user_id (primary key)

            // executeUpdate() returns number of rows affected
            // if > 0  update successful  return true
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace(); // print error in console
        }

        // return false if update fails
        return false;
    }
}