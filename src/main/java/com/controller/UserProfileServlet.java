package com.controller;

import java.io.IOException;

import com.model.StudentModel;
import com.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfile")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService service = new StudentService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("username") == null) {
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        }

	        String username = session.getAttribute("username").toString();
	        StudentModel student = service.getStudentByUsername(username);

	        if (student == null) {
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        }

	        request.setAttribute("student", student);
	        request.getRequestDispatcher("/WEB-INF/pages/UserProfile.jsp").forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new ServletException(e);
	    }

}
}
