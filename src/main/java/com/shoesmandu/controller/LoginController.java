package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.LoginService;
import com.shoesmandu.util.CookieUtil;
import com.shoesmandu.util.ValidationUtil;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 * 
 * Responsibilities: 1. Display login page 2. Handle login form submission 3.
 * Validate login credentials 4. Create session and cookies 5. Redirect user
 * based on role
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Service layer object for authentication
	private final LoginService loginService;

	/**
	 * Constructor initializes LoginService
	 */
	public LoginController() {
		this.loginService = new LoginService();
	}

	/**
	 * Handles HTTP GET request Loads login page
	 * 
	 * @param req  HttpServletRequest object
	 * @param resp HttpServletResponse object
	 * 
	 * @throws ServletException if servlet error occurs
	 * @throws IOException      if input/output error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
	}

	/**
	 * Handles HTTP POST request Processes user login
	 * 
	 * @param req  HttpServletRequest object
	 * @param resp HttpServletResponse object
	 * 
	 * @throws ServletException if servlet error occurs
	 * @throws IOException      if input/output error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get form input values
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// Check empty email
		if (ValidationUtil.isNullOrEmpty(email)) {
			req.setAttribute("error", "Please fill in your email.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Check empty password
		if (ValidationUtil.isNullOrEmpty(password)) {
			req.setAttribute("error", "Please fill in your password.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Validate email and password format
		if (!ValidationUtil.isValidEmail(email) || !ValidationUtil.isValidPassword(password)) {

			req.setAttribute("error", "Invalid email or password format.");

			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Create user model object
		UserModel loginUser = new UserModel();
		loginUser.setUserEmail(email.trim());
		loginUser.setUserPassword(password.trim());

		// Authenticate user
		UserModel user = loginService.loginUser(loginUser);

		// Check login success
		if (user != null) {

			// Check account status
			if (!"active".equalsIgnoreCase(user.getStatus())) {

				req.setAttribute("error", "Your account is not active.");

				req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
				return;
			}

			// Set session attributes
			SessionUtil.setAttribute(req, "user", user);
			SessionUtil.setAttribute(req, "role", user.getRole());

			// Success message
			req.getSession().setAttribute("message", "Login successful");

			// Redirect based on role
			if ("admin".equalsIgnoreCase(user.getRole())) {

				// Add admin cookie
				CookieUtil.addCookie(resp, "role", "admin", 60 * 60);

				// Redirect admin dashboard
				resp.sendRedirect(req.getContextPath() + "/dashboard");

			} else {

				// Add user cookie
				CookieUtil.addCookie(resp, "role", "user", 60 * 60);

				// Redirect home page
				resp.sendRedirect(req.getContextPath() + "/home");
			}

		} else {

			// Handle login failure
			handleLoginFailure(req, resp, user);
		}
	}

	/**
	 * Handles login failure Sets error message and forwards to login page
	 * 
	 * @param req  HttpServletRequest object
	 * @param resp HttpServletResponse object
	 * @param user UserModel object
	 * 
	 * @throws ServletException if servlet error occurs
	 * @throws IOException      if input/output error occurs
	 */
	private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, UserModel user)
			throws ServletException, IOException {

		String errorMessage;

		if (user == null) {

			errorMessage = "User credential mismatch. Please try again!";

		} else {

			errorMessage = "Our server is under maintenance. Please try again later!";
		}

		req.setAttribute("error", errorMessage);

		req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
	}
}