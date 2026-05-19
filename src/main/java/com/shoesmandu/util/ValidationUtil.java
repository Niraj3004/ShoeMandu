package com.shoesmandu.util;

import java.util.regex.Pattern;

/**
 * ValidationUtil provides common input validation
 * methods for the Shoesmandu application.
 * 
 * It ensures data integrity by validating:
 * 1. Empty values
 * 2. Email format
 * 3. Password strength
 * 4. Alphabetic names
 * 5. Phone numbers
 * 6. User roles
 */
public class ValidationUtil {

    /**
     * Checks if a string is null or empty.
     * 
     * @param value input string
     * @return true if null or empty
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates email format.
     * 
     * @param email email address
     * @return true if valid email format
     */
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && Pattern.matches(regex, email);
    }

    /**
     * Validates password strength.
     * Minimum 8 characters, at least:
     * 1 uppercase letter, 1 digit, 1 special character
     * 
     * @param password user password
     * @return true if password is strong
     */
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%*?&]).{8,}$";
        return password != null && Pattern.matches(regex, password);
    }

    /**
     * Checks if value contains only alphabets and spaces.
     * 
     * @param value input string
     * @return true if alphabetic
     */
    public static boolean isAlphabetic(String value) {
        return value != null && value.matches("^[a-zA-Z ]+$");
    }

    /**
     * Validates phone number (10–15 digits, optional +).
     * 
     * @param phone phone number
     * @return true if valid format
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\+?\\d{10,15}$");
    }

    /**
     * Validates user role.
     * Allowed: admin, user
     * 
     * @param role user role
     * @return true if valid role
     */
    public static boolean isValidRole(String role) {
        return role != null &&
               (role.equalsIgnoreCase("admin") ||
                role.equalsIgnoreCase("user"));
    }
}