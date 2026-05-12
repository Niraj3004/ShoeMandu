package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.LoginService;
import com.shoesmandu.util.CookieUtil;
import com.shoesmandu.util.SessionUtil;
import com.shoesmandu.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Service layer object to handle login logic
	private LoginService loginService = new LoginService();

	/**
	 * Handles GET request Loads the login page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Forward request to Login JSP page
		req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
	}

	/**
	 * Handles POST request Processes login form submission
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get form data from request
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// Validation: check if email is empty
		if (ValidationUtil.isNullOrEmpty(email)) {
			req.setAttribute("error", "Email is required");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Validation: check if password is empty
		if (ValidationUtil.isNullOrEmpty(password)) {
			req.setAttribute("error", "Password is required");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Validation: check email format
		if (!ValidationUtil.isValidEmail(email)) {
			req.setAttribute("error", "Invalid email format");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Create UserModel object and set login credentials
		UserModel loginUser = new UserModel();
		loginUser.setUserEmail(email.trim());
		loginUser.setUserPassword(password.trim());

		// Call service layer to authenticate user
		UserModel user = loginService.loginUser(loginUser);

		//  Login failed
		if (user == null) {
			req.setAttribute("error", "Invalid email or password");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		//  Soft deleted account 
		if ("deleted".equalsIgnoreCase(user.getStatus())) {
			req.setAttribute("error", "This account has been removed by admin.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		//  Pending approval
		if ("pending".equalsIgnoreCase(user.getStatus())) {
			req.setAttribute("error", "Your account is waiting for admin approval.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Rejected account
		if ("rejected".equalsIgnoreCase(user.getStatus())) {
			req.setAttribute("error", "Your account was rejected by admin.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		//  Inactive account
		if ("inactive".equalsIgnoreCase(user.getStatus())) {
			req.setAttribute("error", "Your account is inactive. Contact admin.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		//  Active 
		if (!"active".equalsIgnoreCase(user.getStatus())) {
			req.setAttribute("error", "Unknown account status. Contact admin.");
			req.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(req, resp);
			return;
		}

		// Login successful create session
		SessionUtil.setAttribute(req, "user", user);
		SessionUtil.setAttribute(req, "email", user.getUserEmail());

		// Set role cookie and redirect based on role
		if ("admin".equalsIgnoreCase(user.getRole())) {

			// Set cookie for admin (1 hour expiry)
			CookieUtil.addCookie(resp, "role", "admin", 1 * 1);

			// Redirect to admin dashboard
			resp.sendRedirect(req.getContextPath() + "/dashboard");

		} else {

			// Set cookie for normal user
			CookieUtil.addCookie(resp, "role", "user", 1 * 1);

			// Redirect to home page
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}
}