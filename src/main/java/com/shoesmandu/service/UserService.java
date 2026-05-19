package com.shoesmandu.service;

import com.shoesmandu.dao.UserDAO;
import com.shoesmandu.util.PasswordUtil;

/**
 * UserService handles business logic related to
 * user registration in the Shoesmandu system.
 * 
 * It acts as a bridge between controller layer
 * and DAO layer.
 * 
 * Responsibilities:
 * 1. Password hashing before storing
 * 2. Setting default role and status
 * 3. Calling DAO for database insertion
 */
public class UserService {

    // DAO object to interact with database
    UserDAO userDAO = new UserDAO();

    /**
     * Registers a new user into the system.
     * 
     * This method:
     * 1. Hashes the plain password
     * 2. Sets default role as "user"
     * 3. Sets default status as "pending"
     * 4. Stores user in database
     * 
     * @param firstName user first name
     * @param lastName user last name
     * @param email user email
     * @param password plain text password
     * @param phone user phone number
     * @param address user address
     * @param image profile image path
     * @throws Exception database or hashing error
     */
    public void addUser(String firstName, String lastName, String email, String password,
                        String phone, String address, String image) throws Exception {

        // HASH PASSWORD FOR SECURITY
        String hashedPassword = PasswordUtil.getHashPassword(password);

        // DEFAULT ROLE
        String role = "user";

        // DEFAULT STATUS (requires admin approval)
        String status = "pending";

        // SAVE USER VIA DAO
        userDAO.insertUser(firstName, lastName, email, hashedPassword,
                phone, address, role, status, image);
    }
}