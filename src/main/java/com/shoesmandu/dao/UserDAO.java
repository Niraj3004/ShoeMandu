package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.DBconfig;

public class UserDAO {

    /**
     *  INSERT USER
     * This method saves a new user into the database.
     * All user details are passed from Service layer.
     */
    public void insertUser(String firstName, String lastName, String email, String password, String phone,
                           String address, String role, String status, String image) throws Exception {

        // SQL query to insert user data
        String sql = "INSERT INTO user (user_first_name, user_last_name, user_email, user_password, user_phone, user_address, role, status, user_image_url) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Try-with-resources automatically closes connection & statement
        try (Connection con = DBconfig.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set values to prepared statement
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, password); // hashed password
            pst.setString(5, phone);
            pst.setString(6, address);
            pst.setString(7, role);     // default: user/admin
            pst.setString(8, status);   // default: pending
            pst.setString(9, image);    // profile image path

            // Execute insert query
            pst.executeUpdate();
        }
    }

    /**
     *  GET USER BY EMAIL
     * This method retrieves a single user from database using email.
     * Used for login authentication.
     */
    public UserModel getUserByEmail(String email) throws Exception {

        String sql = "SELECT * FROM user WHERE user_email = ?";

        try (Connection con = DBconfig.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set email parameter
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            // If user found  map DB data to UserModel
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
        }

        // Return null if user not found
        return null;
    }

    /**
     * GET ALL USERS
     * This method retrieves all users from database.
     * Useful for admin dashboard (view users, approve/reject).
     */
    public List<UserModel> getAllUsers() throws Exception {

        List<UserModel> users = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection con = DBconfig.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            // Loop through all records
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

                // Add each user to list
                users.add(user);
            }
        }

        // Return list of users
        return users;
    }
}