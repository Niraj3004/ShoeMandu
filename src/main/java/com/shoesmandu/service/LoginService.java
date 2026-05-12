package com.shoesmandu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;
import com.shoesmandu.util.PasswordUtil;

public class LoginService {

    /**
     * LOGIN USER
     * This method authenticates a user using email and password.
     * It checks the hashed password and returns full user details if valid.
     */
    public UserModel loginUser(UserModel userModel) {

        // SQL query to fetch user by email
        String query = "SELECT * FROM user WHERE user_email = ?";

        // Try-with-resources → auto closes connection & statement
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set email parameter
            stmt.setString(1, userModel.getUserEmail());

            // Execute query
            ResultSet rs = stmt.executeQuery();

            // If user exists in database
            if (rs.next()) {

                //  Get stored hashed password from DB
                String dbPassword = rs.getString("user_password");

                //  Compare input password with hashed password
                boolean isMatch = PasswordUtil.checkPassword(
                        userModel.getUserPassword(), // plain password from user
                        dbPassword                  // hashed password from DB
                );

                //  If password matches
                if (isMatch) {

                    //  Create new UserModel and map database values
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

                    //  Return full user object after successful login
                    return user;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Return null if login fails (wrong email or password)
        return null;
    }
}