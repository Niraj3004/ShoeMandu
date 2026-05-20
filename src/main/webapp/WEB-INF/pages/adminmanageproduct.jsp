<%@ page contentType="text/html; charset=UTF-8" %>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>

            <title>Manage Products</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminproducts.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manageproduct.css">

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

        </head>

        <body>

            <div class="container">

                <div class="top">

                    <a href="${pageContext.request.contextPath}/dashboard" class="back-btn"> <i
                            class="fa fa-arrow-left"></i> Back Dashboard

                    </a>

                    <h1>Manage Products</h1>

                    <a href="${pageContext.request.contextPath}/adminadd-product" class="add-btn">
                        + Add Product
                    </a>

                </div>

                <!-- SEARCH FORM -->
                <form action="${pageContext.request.contextPath}/admin-manageproduct" method="get" class="search-box">

                    <input type="text" name="keyword" placeholder="Search product..." value="${param.keyword}">

                    <button type="submit" class="search-btn">
                        Search
                    </button>

                </form>

                <table>

                    <thead>

                        <tr>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th>Stock</th>
                            <th>Action</th>
                        </tr>

                    </thead>

                    <tbody>

                        <c:forEach var="p" items="${products}">

                            <tr>

                                <td>
                                    <img class="product-img" src="${pageContext.request.contextPath}/${p.imageUrl}">
                                </td>

                                <td>${p.productName}</td>

                                <td>${p.brand}</td>

                                <td>${p.category}</td>

                                <td>Rs. ${p.price}</td>

                                <td>${p.stock}</td>

                                <td class="actions">

                                    <!-- EDIT -->
                                    <a class="edit-btn"
                                        href="${pageContext.request.contextPath}/admin/edit-product?id=${p.productId}">
                                        Edit
                                    </a>

                                    <!-- DELETE -->
                                    <a class="delete-btn"
                                        href="${pageContext.request.contextPath}/admin/delete-product?id=${p.productId}">
                                        Delete
                                    </a>

                                </td>

                            </tr>

                        </c:forEach>

                        <c:if test="${empty products}">
                            <tr>
                                <td colspan="7" class="empty">
                                    No products found
                                </td>
                            </tr>
                        </c:if>

                    </tbody>

                </table>

            </div>

        </body>

        </html>