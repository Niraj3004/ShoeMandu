package com.shoesmandu.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * PasswordUtil provides secure password
 * hashing and verification using BCrypt.
 * 
 * It ensures that:
 * 1. Plain text passwords are never stored
 * 2. Passwords are securely hashed
 * 3. Login verification is done safely
 */
public class PasswordUtil {

    // BCrypt strength factor (cost)
    private static final int COST = 10;

    /**
     * Generates a hashed password using BCrypt.
     * 
     * @param password plain text password
     * @return hashed password string
     */
    public static String getHashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(COST));
    }

    /**
     * Verifies a plain password against stored hash.
     * 
     * @param input plain text password entered by user
     * @param storedHash hashed password from database
     * @return true if password matches, otherwise false
     */
    public static boolean checkPassword(String input, String storedHash) {
        return BCrypt.checkpw(input, storedHash);
    }
}