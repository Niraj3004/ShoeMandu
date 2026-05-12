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

@WebServlet("/update-admin-profile")
@MultipartConfig
public class UpdateAdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserProfileDAO dao = new UserProfileDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get user from session using SessionUtil
		UserModel admin = (UserModel) SessionUtil.getAttribute(req, "user");

		// Not logged in
		if (admin == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// Not admin
		if (!"admin".equalsIgnoreCase(admin.getRole())) {
			resp.sendRedirect(req.getContextPath() + "/home");
			return;
		}

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		if (ValidationUtil.isNullOrEmpty(firstName) || ValidationUtil.isNullOrEmpty(lastName)
				|| ValidationUtil.isNullOrEmpty(phone) || ValidationUtil.isNullOrEmpty(address)) {

			req.setAttribute("error", "All fields are required");
			req.setAttribute("admin", admin);
			req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp").forward(req, resp);
			return;
		}

		if (!ValidationUtil.isValidPhone(phone)) {
			req.setAttribute("error", "Please enter a valid 10-digit number.");
			req.setAttribute("admin", admin);
			req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp").forward(req, resp);
			return;
		}

		// handle image
		Part filePart = req.getPart("image");
		String imagePath = null;

		if (filePart != null && filePart.getSize() > 0) {

			ImageUtil imageUtil = new ImageUtil(); // create object

			String fileName = imageUtil.getImageNameFromPart(filePart);

			String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

			imageUtil.uploadImage(filePart, uploadPath, "");

			imagePath = "uploads/" + fileName;
		}

		// Update model
		admin.setUserFirstName(firstName.trim());
		admin.setUserLastName(lastName.trim());
		admin.setUserPhone(phone.trim());
		admin.setUserAddress(address.trim());

		if (imagePath != null) {
			admin.setUserImageURL(imagePath);
		}

		boolean updated = dao.updateUserProfile(admin);

		if (updated) {

			// session
			SessionUtil.setAttribute(req, "user", admin);

			req.setAttribute("success", "Admin profile updated successfully.");

		} else {
			req.setAttribute("error", "Admin profile update failed.");
		}

		req.setAttribute("admin", admin);
		req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp").forward(req, resp);
	}
}