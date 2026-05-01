<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - MyApp</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/footer.css" />
</head>

<body>

<jsp:include page="header.jsp" />

    <div class="auth-container">
        <h1 class="auth-title">Welcome Back</h1>
        <p class="auth-subtitle">Login in to your account</p>

        <form>
            <div class="form-group">
                <label>Email</label>
                <div class="input-box">
                    <i class="fa fa-envelope"></i>
                    <input type="email" placeholder="Enter your email">
                </div>
            </div>

            <div class="form-group">
                <label>Password</label>
                <div class="input-box">
                    <i class="fa fa-lock"></i>
                    <input type="password" placeholder="Enter your password">
                </div>
            </div>

            <div class="form-row">
                <label><input type="checkbox"> Remember me</label>
                <a href="#">Forgot password?</a>
            </div>

            <button class="login-button" type="submit">Login</button>
        </form>

        <div class="divider">OR</div>

        <button class="google-button">
            <i class="fa-brands fa-google"></i>
            Login with Google
        </button>

        <p class="terms-text">
            Agree to our
            <a href="#">Terms of Service</a>
            and
            <a href="#">Privacy Policy</a>.
        </p>

        <div class="register-link">
            Already have an account? <a href="#">Register</a>
        </div>

    </div>

 <jsp:include page="footer.jsp" />
 
</body>

</html>