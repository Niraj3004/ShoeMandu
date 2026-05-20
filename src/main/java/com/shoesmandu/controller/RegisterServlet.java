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

/**
 * RegisterServlet handles user registration process.
 *
 * Responsibilities: 1. Display registration page 2. Process registration form
 * submission 3. Validate user input 4. Handle image upload 5. Register user
 * using service layer
 */
@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Service layer object to handle business logic
	private UserService userService = new UserService();

	/**
	 * Handles HTTP GET request Loads the registration page
	 *
	 * @param req  HttpServletRequest object containing client request
	 * @param resp HttpServletResponse object used to send response
	 * 
	 * @throws ServletException if servlet-specific error occurs
	 * @throws IOException      if input/output error occurs
	 *
	 * @return void (forwards to register.jsp)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Forward request to register page
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

	/**
	 * Handles HTTP POST request Processes user registration form submission
	 *
	 * @param req  HttpServletRequest object containing form data
	 * @param resp HttpServletResponse object used for redirect/forward
	 * 
	 * @throws ServletException if servlet-specific error occurs
	 * @throws IOException      if input/output error occurs
	 *
	 * @return void (redirects or forwards based on registration result)
	 */
	@Override
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

		// Validate empty fields
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

			ImageUtil imageUtil = new ImageUtil();

			String fileName = imageUtil.getImageNameFromPart(filePart);

			String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

			imageUtil.uploadImage(filePart, uploadPath, "");

			imagePath = "uploads/" + fileName;
		}

		try {

			// Call service layer to register user
			userService.addUser(firstName, lastName, email, password, phone, address, imagePath);

			// Redirect to login page after success
			resp.sendRedirect(req.getContextPath() + "/login?success=registered");

		} catch (Exception e) {

			e.printStackTrace();

			// Handle registration failure
			req.setAttribute("error", "Registration failed. Email already exist.");

			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
		}
	}
}