<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Admin Dashboard - ShoesMandu</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        </head>

        <body>

            <div class="admin-wrapper">

                <!-- SIDEBAR -->
                <aside class="sidebar">
                    <h2>ShoesMandu</h2>

                    <a href="${pageContext.request.contextPath}/dashboard" class="active">
                        <i class="fa fa-chart-line"></i> Dashboard
                    </a>

                    <a href="${pageContext.request.contextPath}/admin-manageproduct">
                        <i class="fa fa-box"></i> Products
                    </a>

                    <a href="${pageContext.request.contextPath}/adminadd-product">
                        <i class="fa fa-plus"></i> Add Product
                    </a>

                    <a href="${pageContext.request.contextPath}/admin/orders">
                        <i class="fa fa-receipt"></i> Orders
                    </a>

                    <a href="${pageContext.request.contextPath}/admin-profile">
                        <i class="fa fa-user"></i> Profile
                    </a>

                    <a href="${pageContext.request.contextPath}/logout">
                        <i class="fa fa-sign-out-alt"></i> Logout
                    </a>
                </aside>

                <!-- MAIN -->
                <main class="main-content">

                    <!-- TOPBAR -->
                    <div class="topbar">

                        <!-- LEFT -->
                        <div class="top-left">
                            <h1>Admin Dashboard</h1>
                            <p>Manage users, products, orders and profile</p>
                        </div>

                        <!-- CENTER -->
                        <div class="top-center">
                            <div class="search-box">
                                <i class="fa fa-search"></i>
                                <input type="text" placeholder="Search users, products...">
                            </div>
                        </div>

                        <!-- RIGHT -->
                        <div class="top-right">
                            <div class="admin-mini">
                                <img src="${pageContext.request.contextPath}/${sessionScope.user.userImageURL}"
                                    alt="Admin">
                                <span>${sessionScope.user.userFirstName}</span>
                            </div>
                        </div>

                    </div>

                    <!-- CARDS -->
                    <div class="cards">

                        <div class="card">
                            <i class="fa fa-users"></i>
                            <h3>Total Users</h3>
                            <p>${users.size()}</p>
                        </div>

                        <div class="card">
                            <i class="fa fa-box"></i>
                            <h3>Products</h3>
                            <p>Manage</p>
                        </div>

                        <div class="card">
                            <i class="fa fa-receipt"></i>
                            <h3>Orders</h3>
                            <p>View</p>
                        </div>

                        <div class="card">
                            <i class="fa fa-user-shield"></i>
                            <h3>Admin</h3>
                            <p>Profile</p>
                        </div>

                    </div>

                    <!-- USER TABLE -->
                    <section class="table-section">
                        <h2>All Users</h2>

                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Image</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>

                                <tbody>

                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <td>
                                                <img class="user-img"
                                                    src="${pageContext.request.contextPath}/${user.userImageURL}">
                                            </td>

                                            <td>${user.userFirstName} ${user.userLastName}</td>
                                            <td>${user.userEmail}</td>
                                            <td>${user.userPhone}</td>

                                            <td>
                                                <span class="badge ${user.status}">
                                                    ${user.status}
                                                </span>
                                            </td>

                                            <td>
                                                <form action="${pageContext.request.contextPath}/admin/user-status"
                                                    method="post" class="action-form">

                                                    <input type="hidden" name="userId" value="${user.userID}">

                                                    <button name="action" value="approve" class="btn approve">
                                                        Approve
                                                    </button>

                                                    <button name="action" value="reject" class="btn reject">
                                                        Reject
                                                    </button>

                                                    <button name="action" value="delete" class="btn delete">
                                                        Delete
                                                    </button>

                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    <c:if test="${empty users}">
                                        <tr>
                                            <td colspan="6" class="empty">No users found</td>
                                        </tr>
                                    </c:if>

                                </tbody>
                            </table>
                        </div>
                    </section>

                </main>
            </div>

        </body>

        </html>