package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;

/**
 * UserProfileDAO handles database operations
 * related to updating user profile information
 * in the Shoesmandu system.
 * 
 * It provides functionality to update
 * user personal details such as name,
 * phone, address, and profile image.
 * 
 * This DAO interacts with the user table
 * in the database.
 */
public class UserProfileDAO {

    /**
     * Updates user profile information in the database.
     * 
     * This method updates user details based on user_id.
     * It does not modify email, password, role, or status.
     * 
     * @param user UserModel object containing updated details
     * @return true if update is successful, otherwise false
     */
    public boolean updateUserProfile(UserModel user) {

        // SQL query to update user profile
        String sql = "UPDATE user SET "
                + "user_first_name=?, "
                + "user_last_name=?, "
                + "user_phone=?, "
                + "user_address=?, "
                + "user_image_url=? "
                + "WHERE user_id=?";

        try (Connection con = DBconfig.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            // SET FIRST NAME
            pst.setString(1, user.getUserFirstName());

            // SET LAST NAME
            pst.setString(2, user.getUserLastName());

            // SET PHONE NUMBER
            pst.setString(3, user.getUserPhone());

            // SET ADDRESS
            pst.setString(4, user.getUserAddress());

            // SET PROFILE IMAGE
            pst.setString(5, user.getUserImageURL());

            // SET USER ID (PRIMARY KEY)
            pst.setInt(6, user.getUserID());

            // EXECUTE UPDATE
            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}