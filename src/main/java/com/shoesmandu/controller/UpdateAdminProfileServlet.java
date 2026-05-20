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
 * UpdateAdminProfileServlet handles updating admin profile information.
 *
 * This servlet is responsible for:
 * - Verifying admin session
 * - Validating profile input fields
 * - Handling profile image upload
 * - Updating admin data in database
 * - Updating session data after successful update
 */
@WebServlet("/update-admin-profile")
@MultipartConfig
public class UpdateAdminProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // DAO layer object for updating user profile in database
    private UserProfileDAO dao = new UserProfileDAO();

    /**
     * Handles POST request for updating admin profile
     *
     * @param req  contains form data (firstName, lastName, phone, address, image)
     * @param resp sends response back to JSP page
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get logged-in admin from session
        UserModel admin = (UserModel) SessionUtil.getAttribute(req, "user");

        // Check if user is logged in
        if (admin == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Check if user is admin
        if (!"admin".equalsIgnoreCase(admin.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        // Get form input values
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // Validate required fields
        if (ValidationUtil.isNullOrEmpty(firstName) ||
            ValidationUtil.isNullOrEmpty(lastName) ||
            ValidationUtil.isNullOrEmpty(phone) ||
            ValidationUtil.isNullOrEmpty(address)) {

            req.setAttribute("error", "All fields are required");
            req.setAttribute("admin", admin);
            req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp")
               .forward(req, resp);
            return;
        }

        // Validate phone number format
        if (!ValidationUtil.isValidPhone(phone)) {

            req.setAttribute("error", "Please enter a valid phone number");
            req.setAttribute("admin", admin);
            req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp")
               .forward(req, resp);
            return;
        }

        // Handle profile image upload
        Part filePart = req.getPart("image");
        String imagePath = null;

        if (filePart != null && filePart.getSize() > 0) {

            ImageUtil imageUtil = new ImageUtil();

            String fileName = imageUtil.getImageNameFromPart(filePart);

            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + "uploads";

            imageUtil.uploadImage(filePart, uploadPath, "");

            imagePath = "uploads/" + fileName;
        }

        // Update admin model with new values
        admin.setUserFirstName(firstName.trim());
        admin.setUserLastName(lastName.trim());
        admin.setUserPhone(phone.trim());
        admin.setUserAddress(address.trim());

        if (imagePath != null) {
            admin.setUserImageURL(imagePath);
        }

        // Update profile in database
        boolean updated = dao.updateUserProfile(admin);

        if (updated) {

            // Update session with new admin data
            SessionUtil.setAttribute(req, "user", admin);

            req.setAttribute("success", "Admin profile updated successfully.");

        } else {
            req.setAttribute("error", "Failed to update admin profile.");
        }

        req.setAttribute("admin", admin);
        req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp")
           .forward(req, resp);
    }
}