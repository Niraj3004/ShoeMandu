package com.shoesmandu.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * SessionUtil provides helper methods for
 * managing HTTP session data in the Shoesmandu
 * web application.
 * 
 * It simplifies:
 * 1. Setting session attributes
 * 2. Retrieving session attributes
 * 3. Invalidating sessions (logout)
 */
public class SessionUtil {

    /**
     * Sets a value in the HTTP session.
     * Creates a session if it does not exist.
     * 
     * @param request HttpServletRequest
     * @param key session attribute key
     * @param value session attribute value
     */
    public static void setAttribute(HttpServletRequest request, String key, Object value) {

        HttpSession session = request.getSession(); // CREATE IF NOT EXISTS
        session.setAttribute(key, value);
    }

    /**
     * Retrieves a session attribute value.
     * 
     * @param request HttpServletRequest
     * @param key session attribute key
     * @return attribute value or null if session doesn't exist
     */
    public static Object getAttribute(HttpServletRequest request, String key) {

        HttpSession session = request.getSession(false); // DO NOT CREATE NEW SESSION

        if (session != null) {
            return session.getAttribute(key);
        }

        return null;
    }

    /**
     * Invalidates the current session (logout).
     * 
     * @param request HttpServletRequest
     */
    public static void invalidate(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
    }
}