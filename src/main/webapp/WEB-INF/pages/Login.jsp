<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login - ShoesMandu</title>

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
        </head>

        <body>

            <jsp:include page="header.jsp" />

            <div class="login-page">

                <!-- LEFT SIDE -->
                <div class="login-left">
                    <div class="brand-box">
                        <h2>Welcome Back</h2>
                        <p>Login to continue shopping premium shoes and offers.</p>

                        <div class="feature-grid">

                            <div class="feature-card">
                                <i class="fa-solid fa-shoe-prints"></i>
                                <h3>New Collection</h3>
                            </div>

                            <div class="feature-card">
                                <i class="fa-solid fa-lock"></i>
                                <h3>Secure Login</h3>
                            </div>

                            <div class="feature-card">
                                <i class="fa-solid fa-tags"></i>
                                <h3>Best Offers</h3>
                            </div>

                            <div class="feature-card">
                                <i class="fa-solid fa-truck-fast"></i>
                                <h3>Fast Delivery</h3>
                            </div>

                        </div>
                    </div>
                </div>

                <!-- RIGHT SIDE -->
                <div class="login-right">

                    <div class="login-container">

                        <h2>Login</h2>
                        <p>Access your ShoesMandu account</p>

                        <c:if test="${not empty error}">
                            <div class="error-message">${error}</div>
                        </c:if>

                        <c:if test="${not empty success}">
                            <div class="success-message">${success}</div>
                        </c:if>

                        <c:if test="${not empty sessionScope.message}">
                            <div class="success-message">${sessionScope.message}</div>
                        </c:if>

                        <form action="${pageContext.request.contextPath}/login" method="post">

                            <div class="form-group">
                                <label>Email</label>
                                <div class="input-group">
                                    <i class="fa fa-envelope"></i>
                                    <input type="email" name="email" placeholder="Enter email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <div class="input-group">
                                    <i class="fa fa-lock"></i>
                                    <input type="password" name="password" placeholder="Enter password">
                                </div>
                            </div>


                            <div class="terms-container">
                                <label class="custom-checkbox">
                                    <input type="checkbox" name="terms" required>
                                    <span class="checkmark"></span>

                                    <span class="terms-text">
                                        I accept the
                                        <a href="#">Terms and Conditions</a> of ShoesMandu
                                    </span>
                                </label>
                            </div>

                            <button type="submit" class="login-btnnn">Login</button>

                        </form>

                        <div class="divider">OR</div>

                        <button class="google-btn">
                            <i class="fa-brands fa-google"></i> Login with Google
                        </button>


                        <div class="register-link">
                            Don't have an account?
                            <a href="${pageContext.request.contextPath}/register">Register</a>
                        </div>

                    </div>

                </div>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>