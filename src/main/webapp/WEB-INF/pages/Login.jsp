<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - ShoesMandu</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/footer.css">
</head>

<body>

	<jsp:include page="header.jsp" />

<div class="login-page">

    <!-- LEFT SIDE -->
    <div class="login-left">
        <div class="brand-box">
            <h2 style="font-size: 58px; font-weight: 700; letter-spacing: 1px; margin-bottom: 10px;">Welcome Back</h2>
            <p style="font-size: 30px; line-height: 1.7; opacity: 0.85; margin-bottom: 25px;">Login to continue shopping premium shoes and offers.</p>

            <div class="feature-grid">

                <div class="feature-card" style="width: 100%; padding: 20px 80px;">
                    <i class="fa-solid fa-shoe-prints"></i>
                    <h3 style="font-size: 20px;">New Collection</h3>
                </div>

                <div class="feature-card" style="width: 100%; padding: 20px 80px;">
                    <i class="fa-solid fa-lock"></i>
                    <h3 style="font-size: 20px;">Secure Login</h3>
                </div>

                <div class="feature-card" style="width: 100%; padding: 20px 80px;">
                    <i class="fa-solid fa-tags"></i>
                    <h3 style="font-size: 20px;">Best Offers</h3>
                </div>

                <div class="feature-card" style="width: 100%; padding: 20px 80px;">
                    <i class="fa-solid fa-truck-fast"></i>
                    <h3 style="font-size: 20px;">Fast Delivery</h3>
                </div>

            </div>
        </div>
    </div>

    <!-- RIGHT SIDE -->
    <div class="login-right">

        <div class="login-container">

            <h2>Login</h2>
            <p>Dive into your ShoesMandu account</p>

            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>

            <c:if test="${not empty success}">
                <div class="success-message">${success}</div>
            </c:if>
            <!-- Credential section in login -->

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
            <!-- Google logging way -->

            <button class="google-btn" style="background-color: crimson; color: white; border: none;">
                <i class="fa-brands fa-google"></i> Login with Google
            </button>
            
            <!-- Register in login page -->
            <div class="register-link">
                Don't have an account?
                <a href="${pageContext.request.contextPath}/register">Register</a>
            </div>

        </div>

    </div>

</div>
<!-- Adding Footer section  -->

	<jsp:include page="footer.jsp" />

</body>
</html>