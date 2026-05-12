package com.shoesmandu.service;

import com.shoesmandu.dao.UserDAO;
import com.shoesmandu.util.PasswordUtil;

public class UserService {

    // DAO object to interact with database
    UserDAO userDAO = new UserDAO();

    /**
     * This method is used to register a new user.
     * It performs password hashing and sets default role & status.
     */
    public void addUser(String firstName, String lastName, String email, String password,
                        String phone, String address, String image) throws Exception {

        //  Convert plain password into hashed password for security
        String hashedPassword = PasswordUtil.getHashPassword(password);

        //  Set default role for new user
        String role = "user";

        // Set default status (user must be approved by admin before login)
        String status = "pending";

        // Save user data into database via DAO layer
        userDAO.insertUser(firstName, lastName, email, hashedPassword, phone, address, role, status, image);
    }
}