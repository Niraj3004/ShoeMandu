package com.controller;

import java.io.IOException;
import java.util.Base64;

import com.model.StudentModel;
import com.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileImage
 */
@WebServlet(name = "ProfileImageServlet", urlPatterns = { "/ProfileImage" })
public class ProfileImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentService service = new StudentService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	try {
        // Extract username from request query parameter
        String username = request.getParameter("username");

        // Fetch student details from service layer
        StudentModel student = service.getStudentByUsername(username);

        // Validate student and image existence
        if (student == null || student.getImage() == null) {
            return; // No image available
        }

        // Decode Base64 encoded image string into raw bytes
        byte[] imageBytes = Base64.getDecoder().decode(student.getImage());

        // Set response content type to image format
        response.setContentType("image/jpeg");

        // Write image bytes to response output stream
        response.getOutputStream().write(imageBytes);

    } catch (Exception e) {
        // Log exception for debugging purposes
        e.printStackTrace();
    }

}
}
