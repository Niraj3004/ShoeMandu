<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Header</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>

<body>

  <!-- Main Navbar -->
  <nav class="navbar">
    <div class="nav-container">
      <!-- Logo -->
      <a href="#" class="logo">ShoesMandu</a>

      <!-- Menu -->
      <ul class="nav-menu">
        <li><a href="${pageContext.request.contextPath}/home" class="nav-link">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/product" class="nav-link">Products</a></li>
        <li><a href="${pageContext.request.contextPath}/AboutUs" class="nav-link">AboutUs</a></li>
        <li><a href="${pageContext.request.contextPath}/Contact" class="nav-link">Contact</a></li>
      </ul>

      <!-- Search Bar -->
      <div class="search-container">
        <i class="fas fa-search search-icon"></i>
        <input type="text" class="search-input" placeholder="Search shoes, brands, sizes...">
      </div>

      <!-- Right Side Icons -->
      <div class="right-icons">
        <button class="icon-btn" title="User Profile">
          <i class="fas fa-user"></i>
        </button>
        <button class="icon-btn" title="Wishlist">
          <i class="fas fa-heart"></i>
        </button>
        <button class="icon-btn" title="Cart">
          <i class="fas fa-shopping-cart"></i>
        </button>
        <div class="auth-buttons">
          <a href="${pageContext.request.contextPath}/login" class="auth-btn login-btn">Login</a>
          <a href="${pageContext.request.contextPath}/register" class="auth-btn register-btn">Register</a>
        </div>
      </div>
    </div>
  </nav>

  <!-- Sub Navbar -->
  <nav class="sub-navbar">
    <div class="sub-nav-container">
      <ul class="sub-nav-menu">
        <li><a href="#" class="sub-nav-link">Men</a></li>
        <li><a href="#" class="sub-nav-link">Women</a></li>
        <li><a href="#" class="sub-nav-link">Junior</a></li>
        <li><a href="#" class="sub-nav-link">Special Offer</a></li>
        <li><a href="#" class="sub-nav-link">New Arrivals</a></li>
      </ul>
    </div>
  </nav>

</body>

</html>