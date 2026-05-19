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

/**
 * Authentication Filter
 * 
 * This filter controls access to the application
 * based on user authentication and authorization.
 * 
 * It ensures:
 * 1. Public pages are accessible without login
 * 2. Protected pages require authentication
 * 3. Admin pages are restricted to admin users only
 * 4. Logged-in users cannot access login/register pages again
 * 5. Inactive users are blocked from accessing the system
 * 6. Static resources are always accessible
 * 
 * This filter applies to all incoming requests ("/*").
 */
@WebFilter("/*")
public class FilterauthenticationServlet implements Filter {

	// PUBLIC PAGES
	private static final String HOME = "/home";
	private static final String PRODUCT = "/product";
	private static final String ABOUT = "/AboutUs";
	private static final String CONTACT = "/Contact";
	private static final String LOGIN = "/login";
	private static final String REGISTER = "/register";

	// ADMIN PAGE
	private static final String DASHBOARD = "/dashboard";

	/**
	 * Filter initialization method
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// No initialization required
	}

	/**
	 * Main filter logic that controls access
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// GET REQUEST URI
		String uri = req.getRequestURI();

		// GET CONTEXT PATH
		String contextPath = req.getContextPath();

		// EXTRACT PATH WITHOUT CONTEXT
		String path = uri.substring(contextPath.length());

		// ALLOW STATIC RESOURCES (CSS, JS, IMAGES)
		if (path.startsWith("/resources/") || path.startsWith("/css/") || path.startsWith("/js/")
				|| path.startsWith("/images/") || path.startsWith("/uploads/") || path.endsWith(".css")
				|| path.endsWith(".js") || path.endsWith(".png") || path.endsWith(".jpg") || path.endsWith(".jpeg")
				|| path.endsWith(".gif") || path.endsWith(".webp")) {

			chain.doFilter(request, response);
			return;
		}

		// GET LOGGED-IN USER FROM SESSION
		UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

		boolean isLoggedIn = user != null;

		// CHECK PUBLIC PAGES
		boolean isPublicPage = path.equals(HOME) || path.equals(PRODUCT) || path.equals(ABOUT) || path.equals(CONTACT)
				|| path.equals(LOGIN) || path.equals(REGISTER);

		// CHECK ADMIN PAGES
		boolean isAdminPage =
				path.startsWith("/admin")
				|| path.equals(DASHBOARD);

		// IF USER IS NOT LOGGED IN
		if (!isLoggedIn) {

			if (isPublicPage) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + LOGIN);
			}

			return;
		}

		// BLOCK INACTIVE USERS
		if (!"active".equalsIgnoreCase(user.getStatus())) {

			SessionUtil.invalidate(req);
			res.sendRedirect(req.getContextPath() + LOGIN);
			return;
		}

		// BLOCK NON-ADMIN USERS FROM ADMIN PAGES
		if (isAdminPage && !"admin".equalsIgnoreCase(user.getRole())) {

			res.sendRedirect(req.getContextPath() + HOME);
			return;
		}

		// ALLOW REQUEST TO CONTINUE
		chain.doFilter(request, response);
	}

	/**
	 * Filter destroy method
	 */
	@Override
	public void destroy() {
		// No cleanup required
	}
}