<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">


        <c:if test="${not empty sessionScope.error}">
            <div class="alert error">${sessionScope.error}</div>
            <c:remove var="error" scope="session" />
        </c:if>

        <c:if test="${not empty sessionScope.success}">
            <div class="alert success">${sessionScope.success}</div>
            <c:remove var="success" scope="session" />
        </c:if>

        <nav class="navbar">

            <!-- LEFT -->
            <div class="left-section">

                <div class="menu-toggle" id="menu-toggle">
                    <i class="fa-solid fa-bars"></i>
                </div>

                <div class="logo">
                    <a href="${pageContext.request.contextPath}/home">
                        ShoesMandu
                    </a>
                </div>

            </div>

            <!-- MENU -->
            <ul class="nav-links">

                <li>
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/product">Products</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/AboutUs">About</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/Contact">Contact</a>
                </li>

            </ul>

            <!-- SEARCH -->
            <form action="${pageContext.request.contextPath}/product" method="get" class="search-box">

                <i class="fa-solid fa-magnifying-glass"></i>

                <input type="text" name="keyword" placeholder="Search shoes...">

            </form>

            <!-- RIGHT -->
            <div class="right-section">

                <div class="nav-icons">

                    <!--  WISHLIST -->
                    <a href="${pageContext.request.contextPath}/wishlist">
                        <i class="fa-solid fa-heart"></i>

                        <c:if test="${wishlistCount > 0}">
                            <span class="badge">${wishlistCount}</span>
                        </c:if>
                    </a>

                    <!-- CART -->
                    <a href="${pageContext.request.contextPath}/cart">
                        <i class="fa-solid fa-cart-shopping"></i>

                        <c:if test="${cartCount > 0}">
                            <span class="badge">${cartCount}</span>
                        </c:if>
                    </a>

                    <!-- USER -->
                    <c:choose>

                        <c:when test="${not empty sessionScope.user}">
                            <a href="${pageContext.request.contextPath}/profile">
                                <i class="fa-solid fa-user"></i>
                            </a>
                        </c:when>

                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/login">
                                <i class="fa-solid fa-user"></i>
                            </a>
                        </c:otherwise>

                    </c:choose>

                </div>

                <div class="nav-actions">

                    <c:choose>

                        <c:when test="${not empty sessionScope.user}">
                            <a href="${pageContext.request.contextPath}/logout" class="login-btn">
                                Logout
                            </a>
                        </c:when>

                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/login" class="login-btn">
                                Login
                            </a>

                            <a href="${pageContext.request.contextPath}/register" class="register-btn">
                                Register
                            </a>
                        </c:otherwise>

                    </c:choose>

                </div>

            </div>

        </nav>

        <!-- JS MENU TOGGLE -->
        <script>
            const toggleBtn = document.getElementById("menu-toggle");
            const navLinks = document.querySelector(".nav-links");

            toggleBtn.addEventListener("click", () => {
                navLinks.classList.toggle("active");
            });
        </script>