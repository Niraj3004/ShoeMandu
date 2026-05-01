<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - MyApp</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/footer.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/register.css" />
</head>

<body>

    <div class="register-container">
        <h2>Create Account</h2>
        <p>Please fill your information below</p>

        <form>
            <div class="form-group">
                <label for="fullname">Full Name</label>
                <div class="input-group">
                    <i class="fa fa-user"></i>
                    <input type="text" id="fullname" placeholder="Enter your full name">
                </div>
            </div>

            <div class="form-group">
                <label for="email">Email Address</label>
                <div class="input-group">
                    <i class="fa fa-envelope"></i>
                    <input type="email" id="email" placeholder="Enter your email">
                </div>
            </div>

            <div class="form-group">
                <label for="phone">Phone Number</label>
                <div class="input-group">
                    <i class="fa fa-phone"></i>
                    <input type="tel" id="phone" placeholder="Enter your phone number" >
                </div>
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <div class="input-group">
                    <i class="fa fa-location-dot"></i>
                    <input type="text" id="address" placeholder="Enter your address">
                </div>
            </div>

            <div class="form-group">
                <label>Profile Image</label>
                <div class="input-group">
                    <i class="fa-solid fa-image"></i>
                    <input type="file" name="image" accept="image/*">
                </div>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <div class="input-group">
                    <i class="fa fa-lock"></i>
                    <input type="password" id="password" placeholder="Enter your password">
                </div>
            </div>

            <button type="submit" class="register-btn">Register</button>
        </form>

        <div class="login-link">
            Already have an account? <a href="#">Login</a>
        </div>
    </div>

</body>

</html>