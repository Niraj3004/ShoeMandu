package com.shoesmandu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import com.shoesmandu.service.UserService;
import com.shoesmandu.util.ImageUtil;
import com.shoesmandu.util.ValidationUtil;

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service layer object to handle business logic
	private UserService userService = new UserService();

	/**
	 * HANDLE GET REQUEST Loads the registration page
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Forward request to register JSP page
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

	/**
	 * HANDLE POST REQUEST Processes user registration form submission
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get form data from request
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String address = req.getParameter("address");

		// Get uploaded image file
		Part filePart = req.getPart("image");
		String imagePath = null;

		// Validation: check if required fields are empty
		if (ValidationUtil.isNullOrEmpty(firstName) || ValidationUtil.isNullOrEmpty(lastName)
				|| ValidationUtil.isNullOrEmpty(email) || ValidationUtil.isNullOrEmpty(phone)
				|| ValidationUtil.isNullOrEmpty(password)) {

			req.setAttribute("error", "All fields are required");
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}

		// Validate email format
		if (!ValidationUtil.isValidEmail(email)) {
			req.setAttribute("error", "Please enter a valid email address. example@gmail.com");
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}

		// Validate phone number
		if (!ValidationUtil.isValidPhone(phone)) {
			req.setAttribute("error", "Please enter a valid 10-digit number.");
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}

		// Validate password strength
		if (!ValidationUtil.isValidPassword(password)) {
			req.setAttribute("error",
					"Password must be at least 8 characters and include uppercase, lowercase, number, and special character.");
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}

		// Handle image upload 

		if (filePart != null && filePart.getSize() > 0) {

			ImageUtil imageUtil = new ImageUtil(); // create object

			String fileName = imageUtil.getImageNameFromPart(filePart);

			String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

			imageUtil.uploadImage(filePart, uploadPath, "");

			imagePath = "uploads/" + fileName;
		}

		try {
			// Call service layer to register user
			userService.addUser(firstName, lastName, email, password, phone, address, imagePath);

			// Redirect to login page after successful registration
			resp.sendRedirect(req.getContextPath() + "/login?success=registered");

		} catch (Exception e) {
			e.printStackTrace();

			// Handle error (e.g., duplicate email)
			req.setAttribute("error", "Registration failed. Email already exist.");
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
		}
	}
}