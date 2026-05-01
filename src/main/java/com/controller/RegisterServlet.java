package com.controller;

import java.io.IOException;

import com.service.RegisterService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

        	// IMAGE upload
        	Part filePart = request.getPart("image");
        	String fileName = (filePart != null) ? filePart.getSubmittedFileName() : null;

        	String imagePath;

        	if (fileName != null && !fileName.isEmpty()) {
        	    imagePath = "uploads/" + fileName;
        	} else {
        	    imagePath = "uploads/default.png";
        	}

            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String username = request.getParameter("username");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String number = request.getParameter("number");
            String password = request.getParameter("password");
            int programId = Integer.parseInt(request.getParameter("program"));

            RegisterService service = new RegisterService();
          service.addStudent(firstName, lastName, username, dob, gender, email, number, password, programId, imagePath);


            // Redirect to login page
            response.sendRedirect(request.getContextPath() + "/login?success=registered");


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

}