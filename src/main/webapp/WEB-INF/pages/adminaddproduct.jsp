<%@ page contentType="text/html; charset=UTF-8" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>

            <meta charset="UTF-8">

            <title>Add Product - ShoesMandu</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addproduct.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

        </head>

        <body>

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




            <div class="container">

                <div class="form-box">

                    <a href="${pageContext.request.contextPath}/dashboard" class="back-btn"> <i
                            class="fa fa-arrow-left"></i> Back
                        Dashboard

                    </a>

                    <h1>Add New Product</h1>

                    <c:if test="${not empty success}">
                        <div class="success-msg">${success}</div>
                        <c:remove var="success" scope="session" />
                    </c:if>

                    <c:if test="${not empty error}">
                        <div class="error-msg">${error}</div>
                        <c:remove var="error" scope="session" />
                    </c:if>

                    <form action="${pageContext.request.contextPath}/adminadd-product" method="post"
                        enctype="multipart/form-data">

                        <div class="input-group">

                            <label>Product Name</label> <input type="text" name="productName"
                                placeholder="Enter product name" required>

                        </div>

                        <div class="input-group">

                            <label>Brand</label> <input type="text" name="brand" placeholder="Enter brand" required>

                        </div>

                        <div class="input-group">

                            <label>Category</label> <select name="category" required>

                                <option value="">Select Category</option>

                                <option value="">Select Category</option>
                                <option value="Men">Men</option>
                                <option value="Women">Women</option>
                                <option value="Kids">Kids</option>
                                <option value="Unisex">Unisex</option>

                            </select>

                        </div>

                        <div class="input-group">

                            <label>Description</label>

                            <textarea name="description" rows="5" placeholder="Enter description" required></textarea>

                        </div>

                        <div class="double-input">

                            <div class="input-group">

                                <label>Price</label> <input type="number" step="0.01" name="price"
                                    placeholder="Enter price" required>

                            </div>

                            <div class="input-group">

                                <label>Stock</label> <input type="number" name="stock" placeholder="Enter stock"
                                    required>

                            </div>

                        </div>

                        <div class="input-group">

                            <label>Product Image</label> <input type="file" name="image" accept="image/*" required>

                        </div>

                        <button type="submit" class="submit-btn">

                            <i class="fa fa-plus"></i> Add Product

                        </button>

                    </form>

                </div>

            </div>

        </body>

        </html>