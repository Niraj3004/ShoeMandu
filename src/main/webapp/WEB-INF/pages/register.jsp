<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Register - ShoesMandu</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/register.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="register-page">

		<!-- LEFT SIDE -->
		<div class="register-left">

			<div class="brand-box">

				<h1>ShoesMandu</h1>

				<h2>Step Into Style With Confidence</h2>

				<p>Discover premium footwear collections with comfort, style and
					fast delivery.</p>

				<div class="feature-grid">

					<div class="feature-card">

						<i class="fa-solid fa-shoe-prints"></i>

						<h3>Premium Shoes</h3>

					</div>

					<div class="feature-card">

						<i class="fa-solid fa-truck-fast"></i>

						<h3>Fast Delivery</h3>

					</div>

					<div class="feature-card">

						<i class="fa-solid fa-tags"></i>

						<h3>Best Offers</h3>

					</div>

					<div class="feature-card">

						<i class="fa-solid fa-shield-heart"></i>

						<h3>Trusted Store</h3>

					</div>

				</div>

			</div>

		</div>

		<!-- RIGHT SIDE -->
		<div class="register-right">

			<div class="register-container">

				<h2>Create Account</h2>

				<p>Register your ShoesMandu account</p>

				<!-- ERROR MESSAGE -->
				<c:if test="${not empty error}">

					<div class="error-message">${error}</div>

				</c:if>

				<!-- SUCCESS MESSAGE -->
				<c:if test="${not empty success}">

					<div class="success-message">${success}</div>

				</c:if>

				<form action="${pageContext.request.contextPath}/register"
					method="post" enctype="multipart/form-data">

					<!-- NAME ROW -->
					<div class="name-row">

						<div class="form-group">

							<label>First Name</label>

							<div class="input-group">

								<i class="fa fa-user"></i> <input type="text" name="first_name"
									placeholder="Enter first name" required>

							</div>

						</div>

						<div class="form-group">

							<label>Last Name</label>

							<div class="input-group">

								<i class="fa fa-user"></i> <input type="text" name="last_name"
									placeholder="Enter last name" required>

							</div>

						</div>

					</div>

					<!-- EMAIL -->
					<div class="form-group">

						<label>Email Address</label>

						<div class="input-group">

							<i class="fa fa-envelope"></i> <input type="email" name="email"
								placeholder="Enter email" required>

						</div>

					</div>

					<!-- PHONE -->
					<div class="form-group">

						<label>Phone Number</label>

						<div class="input-group">

							<i class="fa fa-phone"></i> <input type="tel" name="phone"
								placeholder="Enter phone number" required>

						</div>

					</div>

					<!-- ADDRESS -->
					<div class="form-group">

						<label>Address</label>

						<div class="input-group">

							<i class="fa fa-location-dot"></i> <input type="text"
								name="address" placeholder="Enter address" required>

						</div>

					</div>

					<!-- IMAGE -->
					<div class="form-group">

						<label>Profile Image</label>

						<div class="input-group file-group">

							<i class="fa-solid fa-image"></i> <input type="file" name="image"
								accept="image/*">

						</div>

					</div>

					<!-- PASSWORD -->
					<div class="form-group">

						<label>Password</label>

						<div class="input-group">

							<i class="fa fa-lock"></i> <input type="password" name="password"
								placeholder="Enter password" required>

						</div>

					</div>

					<button type="submit" class="register-button">Register
						Account</button>

				</form>

				<div class="login-linkk">

					Already have an account ? <a
						href="${pageContext.request.contextPath}/login"> Login </a>

				</div>

			</div>

		</div>

	</div>

	<jsp:include page="footer.jsp" />

</body>

</html>