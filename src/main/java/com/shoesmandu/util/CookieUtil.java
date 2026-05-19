package com.shoesmandu.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * CookieUtil provides helper methods for
 * creating, retrieving, and deleting cookies
 * in the Shoesmandu web application.
 * 
 * It simplifies cookie handling for:
 * 1. Storing small client-side data
 * 2. Retrieving cookie values from requests
 * 3. Removing cookies from the browser
 */
public class CookieUtil {

    /**
     * Adds a cookie to the response.
     * 
     * @param response HttpServletResponse
     * @param name cookie name
     * @param value cookie value
     * @param maxAge lifetime of cookie in seconds
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {

        Cookie cookie = new Cookie(name, value);

        // SET COOKIE EXPIRY (default 30 minutes in this implementation)
        cookie.setMaxAge(30 * 60);

        // MAKE COOKIE AVAILABLE FOR ENTIRE APPLICATION
        cookie.setPath("/");

        // ADD COOKIE TO RESPONSE
        response.addCookie(cookie);
    }

    /**
     * Retrieves a cookie by name from request.
     * 
     * @param request HttpServletRequest
     * @param name cookie name
     * @return Cookie object if found, otherwise null
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (name.equals(cookie.getName())) {

                    return cookie;
                }
            }
        }

        return null;
    }

    /**
     * Deletes a cookie from the browser.
     * 
     * @param response HttpServletResponse
     * @param name cookie name to delete
     */
    public static void deleteCookie(HttpServletResponse response, String name) {

        Cookie cookie = new Cookie(name, null);

        // EXPIRE COOKIE IMMEDIATELY
        cookie.setMaxAge(0);

        cookie.setPath("/");

        response.addCookie(cookie);
    }
}