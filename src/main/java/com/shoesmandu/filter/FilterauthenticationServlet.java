package com.shoesmandu.filter;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class FilterauthenticationServlet implements Filter {

	// Public pages
	private static final String HOME = "/home";
	private static final String PRODUCT = "/product";
	private static final String ABOUT = "/AboutUs";
	private static final String CONTACT = "/Contact";
	private static final String LOGIN = "/login";
	private static final String REGISTER = "/register";

	// Admin page
	private static final String DASHBOARD = "/dashboard";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();

		String path = uri.substring(contextPath.length());

		// Allow static resources
		if (path.startsWith("/resources/") || path.startsWith("/css/") || path.startsWith("/js/")
				|| path.startsWith("/images/") || path.startsWith("/uploads/") || path.endsWith(".css")
				|| path.endsWith(".js") || path.endsWith(".png") || path.endsWith(".jpg") || path.endsWith(".jpeg")
				|| path.endsWith(".gif") || path.endsWith(".webp")) {

			chain.doFilter(request, response);
			return;
		}

		// Get logged in user
		UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

		boolean isLoggedIn = user != null;

		// Public pages
		boolean isPublicPage = path.equals(HOME) || path.equals(PRODUCT) || path.equals(ABOUT) || path.equals(CONTACT)
				|| path.equals(LOGIN) || path.equals(REGISTER);

		boolean isCartOrWishlistAction = path.equals("/add-to-cart") || path.equals("/add-to-wishlist")
				|| path.equals("/cart") || path.equals("/wishlist");

		// Admin pages
		boolean isAdminPage = path.startsWith("/admin") || path.equals(DASHBOARD);

		// If user is not logged in
		if (!isLoggedIn) {

			if (isPublicPage) {

				chain.doFilter(request, response);

			} else {

				res.sendRedirect(contextPath + LOGIN);
			}

			return;
		}
		
		if (isCartOrWishlistAction) {

			// store message in session
			SessionUtil.setAttribute(req, "error", "Please login first to continue");

			res.sendRedirect(contextPath + LOGIN);
			return;
		}

		// Check account status
		if (!"active".equalsIgnoreCase(user.getStatus())) {

			SessionUtil.invalidate(req);

			SessionUtil.setAttribute(req, "error", "Your account is waiting for admin approval.");

			res.sendRedirect(contextPath + LOGIN);
			return;
		}

		// Prevent login/register after login
		if (path.equals(LOGIN) || path.equals(REGISTER)) {

			if ("admin".equalsIgnoreCase(user.getRole())) {

				res.sendRedirect(contextPath + DASHBOARD);

			} else {

				res.sendRedirect(contextPath + HOME);
			}

			return;
		}

		// Admin authorization
		if (isAdminPage && !"admin".equalsIgnoreCase(user.getRole())) {

			res.sendRedirect(contextPath + HOME);
			return;
		}

		// Continue request
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}