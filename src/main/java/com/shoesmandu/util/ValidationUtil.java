package com.shoesmandu.util;

import java.util.regex.Pattern;

public class ValidationUtil {

	// EMPTY CHECK

	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	// EMAIL VALIDATION

	public static boolean isValidEmail(String email) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		return email != null && Pattern.matches(regex, email);
	}

	// PASSWORD VALIDATION
	// Min 8 chars, 1 uppercase, 1 digit, 1 special char

	public static boolean isValidPassword(String password) {
		String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%*?&]).{8,}$";
		return password != null && Pattern.matches(regex, password);
	}

	// NAME VALIDATION

	public static boolean isAlphabetic(String value) {
		return value != null && value.matches("^[a-zA-Z ]+$");
	}

	// PHONE VALIDATION (Nepal style)

	public static boolean isValidPhone(String phone) {
		return phone != null && phone.matches("^\\+?\\d{10,15}$");
	}

	// ROLE VALIDATION

	public static boolean isValidRole(String role) {
		return role != null && (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("user"));
	}
}