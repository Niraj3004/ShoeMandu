package com.shoesmandu.controller;

import java.io.IOException;
import java.util.List;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.model.WishlistModel;
import com.shoesmandu.service.WishlistService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/wishlist")
public class WishlistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WishlistService wishlistService =
            new WishlistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        UserModel user = (UserModel) session.getAttribute("user");

        if (user == null) {

            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        List<WishlistModel> wishlist =
        wishlistService.getWishlist(user.getUserID());

        req.setAttribute("wishlist", wishlist);

        req.getRequestDispatcher("/WEB-INF/pages/wishlist.jsp")
           .forward(req, resp);
    }
}