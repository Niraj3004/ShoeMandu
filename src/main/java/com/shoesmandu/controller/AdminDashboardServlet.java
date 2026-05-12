package com.shoesmandu.controller;

import java.io.IOException;
import com.shoesmandu.dao.AdminuserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class AdminDashboardServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

    private AdminuserDAO userDAO = new AdminuserDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       
        req.setAttribute("users", userDAO.getAllUsers());

        req.getRequestDispatcher("/WEB-INF/pages/admindashboard.jsp").forward(req, resp);
    }
}