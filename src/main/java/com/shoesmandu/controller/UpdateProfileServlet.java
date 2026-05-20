package com.shoesmandu.controller;

import java.io.File;
import java.io.IOException;

import com.shoesmandu.dao.UserProfileDAO;
import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.SessionUtil;
import com.shoesmandu.util.ImageUtil;
import com.shoesmandu.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * UpdateProfileServlet handles updating user profile information.
 *
 * This servlet is responsible for:
 * - Checking user session authentication
 * - Preventing admin from accessing user profile update
 * - Validating input fields
 * - Handling profile image upload
 * - Updating user data in database
 * - Updating session after successful update
 */
@WebServlet("/UpdateProfile")
@MultipartConfig
public class UpdateProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // DAO object for updating user profile in database
    private UserProfileDAO dao = new UserProfileDAO();

    /**
     * Handles POST request for updating user profile
     *
     * @param req  contains form data (firstName, lastName, phone, address, image)
     * @param resp sends response back to JSP page
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get logged-in user from session
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // Check if user is logged in
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Prevent admin from using user profile update page
        if ("admin".equalsIgnoreCase(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/dashboard");
            return;
        }

        // Get form input values
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // Get uploaded image
        Part filePart = req.getPart("image");
        String imagePath = null;

        // Validate required fields
        if (ValidationUtil.isNullOrEmpty(firstName) ||
            ValidationUtil.isNullOrEmpty(lastName) ||
            ValidationUtil.isNullOrEmpty(phone) ||
            ValidationUtil.isNullOrEmpty(address)) {

            req.setAttribute("error", "All fields are required");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/pages/profile.jsp")
               .forward(req, resp);
            return;
        }

        // Validate phone number format
        if (!ValidationUtil.isValidPhone(phone)) {

            req.setAttribute("error", "Please enter a valid phone number");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/pages/profile.jsp")
               .forward(req, resp);
            return;
        }

        // Handle profile image upload (if provided)
        if (filePart != null && filePart.getSize() > 0) {

            ImageUtil imageUtil = new ImageUtil();

            String fileName = imageUtil.getImageNameFromPart(filePart);

            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + "uploads";

            imageUtil.uploadImage(filePart, uploadPath, "");

            imagePath = "uploads/" + fileName;
        }

        // Update user object with new values
        user.setUserFirstName(firstName.trim());
        user.setUserLastName(lastName.trim());
        user.setUserPhone(phone.trim());
        user.setUserAddress(address.trim());

        if (imagePath != null) {
            user.setUserImageURL(imagePath);
        }

        // Update user profile in database
        boolean updated = dao.updateUserProfile(user);

        if (updated) {

            // Update session with new user data
            SessionUtil.setAttribute(req, "user", user);

            req.setAttribute("success", "Profile updated successfully.");
        } else {
            req.setAttribute("error", "Profile update failed.");
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/pages/profile.jsp")
           .forward(req, resp);
    }
}