package com.shoesmandu.controller;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.shoesmandu.service.CartService;

/**
 * DeleteCartServlet handles removing items from the shopping cart.
 *
 * Responsibilities:
 * 1. Handles HTTP GET request to delete a cart item
 * 2. Retrieves cart item ID from request
 * 3. Calls CartService to delete the item from database
 * 4. Redirects user back to cart page
 */

@WebServlet("/delete-cart")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private CartService service = new CartService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int cartId = Integer.parseInt(req.getParameter("cartId"));

        service.deleteCartItem(cartId);

        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
