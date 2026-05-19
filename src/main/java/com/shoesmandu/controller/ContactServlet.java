package com.shoesmandu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ContactServlet handles Contact Us page and form submission.
 *
 * URL: /contact
 *
 * Responsibilities:
 * 1. Display contact page (GET request)
 * 2. Process contact form (POST request)
 * 3. Validate user input
 * 4. Send success/error message using session
 */
@WebServlet("/Contact")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP GET request.
     *
     * Purpose:
     * - Loads Contact page UI
     *
     * @param request  HttpServletRequest object (client request)
     * @param response HttpServletResponse object (server response)
     *
     * @throws ServletException if servlet error occurs
     * @throws IOException if I/O error occurs
     */
    
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/Contact.jsp")
               .forward(request, response);
    }

    /**
     * Handles HTTP POST request.
     *
     * Purpose:
     * - Receives contact form data
     * - Validates input fields
     * - Stores success/error message in session
     * - Redirects back to contact page
     *
     * @param request  HttpServletRequest object containing form data:
     *                 - firstName : user's first name
     *                 - lastName  : user's last name
     *                 - email     : user's email address
     *                 - subject   : inquiry subject
     *                 - message   : user message
     *
     * @param response HttpServletResponse object used for redirect
     *
     * @throws ServletException if servlet processing fails
     * @throws IOException if input/output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String email     = request.getParameter("email");
        String subject   = request.getParameter("subject");
        String message   = request.getParameter("message");

        // Validation
        if (firstName == null || lastName.trim().isEmpty()
                || email == null || email.trim().isEmpty() || subject == null
                || message == null || message.trim().isEmpty()) {

            request.getSession().setAttribute("error", "All required fields must be filled!");
            response.sendRedirect(request.getContextPath() + "/Contact");
            return;
        }

        // Success message (future: save to DB here)
        request.getSession().setAttribute(
                "success",
                "Inquiry submitted successfully! Wait for admin reply."
        );

        response.sendRedirect(request.getContextPath() + "/Contact");
    }
}