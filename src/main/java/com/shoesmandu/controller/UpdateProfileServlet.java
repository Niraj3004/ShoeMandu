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

@WebServlet("/UpdateProfile")
@MultipartConfig
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserProfileDAO dao = new UserProfileDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get user from session using SessionUtil
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // Not logged in
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Prevent admin from using user profile update page
        if ("admin".equalsIgnoreCase(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/dashboard");
            return;
        }

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Part filePart = req.getPart("image");
        String imagePath = null;

        // Validation
        if (ValidationUtil.isNullOrEmpty(firstName)
                || ValidationUtil.isNullOrEmpty(lastName)
                || ValidationUtil.isNullOrEmpty(phone)
                || ValidationUtil.isNullOrEmpty(address)) {

            req.setAttribute("error", "All fields are required");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
            return;
        }

        if (!ValidationUtil.isValidPhone(phone)) {
            req.setAttribute("error", "Please enter a valid 10-digit number.");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
            return;
        }

        // IMAGE UPLOAD

		if (filePart != null && filePart.getSize() > 0) {

			ImageUtil imageUtil = new ImageUtil(); // create object

			String fileName = imageUtil.getImageNameFromPart(filePart);

			String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

			imageUtil.uploadImage(filePart, uploadPath, "");

			imagePath = "uploads/" + fileName;
		}

        // Update user object
        user.setUserFirstName(firstName.trim());
        user.setUserLastName(lastName.trim());
        user.setUserPhone(phone.trim());
        user.setUserAddress(address.trim());

        if (imagePath != null) {
            user.setUserImageURL(imagePath);
        }

        boolean updated = dao.updateUserProfile(user);

        if (updated) {

            // session 
            SessionUtil.setAttribute(req, "user", user);

            req.setAttribute("success", "Profile updated successfully.");
        } else {
            req.setAttribute("error", "Profile update failed.");
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
    }
}