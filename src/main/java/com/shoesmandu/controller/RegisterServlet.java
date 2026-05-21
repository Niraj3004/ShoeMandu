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
 * This controller is responsible for:
 * - Loading registration page (GET request)
 * - Processing registration form (POST request)
 * - Validating user input
 * - Handling profile image upload
 * - Calling service layer to save user
 */
@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object for user-related business logic
    private UserService userService = new UserService();

    /**
     * Handles GET request
     * Loads the registration page (register.jsp)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
           .forward(req, resp);
    }

    /**
     * Handles POST request
     * Processes user registration form submission
     *
     * @param req  contains form data (first_name, last_name, email, etc.)
     * @param resp sends response back to browser (redirect or forward)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get form data from request
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String address = req.getParameter("address");

        // Get uploaded profile image
        Part filePart = req.getPart("image");
        String imagePath = null;

     // Validate First Name
        if (ValidationUtil.isNullOrEmpty(firstName)) {
            req.setAttribute("error", "First name is required");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }

        // Validate Last Name
        if (ValidationUtil.isNullOrEmpty(lastName)) {
            req.setAttribute("error", "Last name is required");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }

        // Validate Email
        if (ValidationUtil.isNullOrEmpty(email)) {
            req.setAttribute("error", "Email is required");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }

        // Validate Phone Number
        if (ValidationUtil.isNullOrEmpty(phone)) {
            req.setAttribute("error", "Phone number is required");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }

        // Validate Password
        if (ValidationUtil.isNullOrEmpty(password)) {
            req.setAttribute("error", "Password is required");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }

        // Validate email format
        if (!ValidationUtil.isValidEmail(email)) {
            req.setAttribute("error", "Please enter a valid email address");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }

        // Validate phone number format
        if (!ValidationUtil.isValidPhone(phone)) {
            req.setAttribute("error", "Please enter a valid phone number");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }
        
     // Check if email already exists
        if (userService.isEmailExists(email)) {

            req.setAttribute("error", "Email already exists");

            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);

            return;
        }
        
        // Validate password strength
        if (!ValidationUtil.isValidPassword(password)) {
            req.setAttribute("error",
                    "Password must be 8+ chars with uppercase, number, and special character");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
            return;
        }
        
		// Handle image

		if (filePart == null || filePart.getSize() == 0) {

			req.setAttribute("error", "Please select a profile image");

			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}

		// Get file name
		String fileName = filePart.getSubmittedFileName();

		// Convert to lowercase for safe checking
		String lowerName = fileName.toLowerCase();

		// Validate image format
		if (!(lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg") || lowerName.endsWith(".png")
				|| lowerName.endsWith(".webp"))) {

			req.setAttribute("error", "Only JPG, JPEG, PNG, or WEBP images are allowed");

			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}

		// Upload path
		ImageUtil imageUtil = new ImageUtil();

		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

		// Upload image
		imageUtil.uploadImage(filePart, uploadPath, "");

		// Save DB path
		imagePath = "uploads/" + fileName;

        try {
            // Call service layer to register user
            userService.addUser(firstName, lastName, email, password, phone, address, imagePath);

            // Redirect to login page after successful registration
            resp.sendRedirect(req.getContextPath() + "/login?success=registered");

        } catch (Exception e) {
            e.printStackTrace();

            // Handle failure (e.g., duplicate email or DB error)
            req.setAttribute("error", "Registration faileds.");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp")
               .forward(req, resp);
        }
    }
}