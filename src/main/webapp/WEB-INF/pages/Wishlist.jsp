<%@ page contentType="text/html; charset=UTF-8" %>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>

            <meta charset="UTF-8">
            <title>My Wishlist</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wishlist.css">

            <style>


            </style>

        </head>

        <body>

            <jsp:include page="header.jsp" />

            <div class="wishlist-container">

                <h1 class="title">My Wishlist</h1>

                <!-- SUCCESS -->
                <c:if test="${not empty sessionScope.success}">
                    <div class="success">${sessionScope.success}</div>
                    <c:remove var="success" scope="session" />
                </c:if>

                <!-- ERROR -->
                <c:if test="${not empty sessionScope.error}">
                    <div class="error">${sessionScope.error}</div>
                    <c:remove var="error" scope="session" />
                </c:if>

                <!-- EMPTY -->
                <c:if test="${empty wishlist}">
                    <div class="empty">Your wishlist is empty</div>
                </c:if>

                <!-- TABLE -->
                <c:if test="${not empty wishlist}">

                    <div class="table-container">

                        <table>

                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Product</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <tbody>

                                <c:forEach var="w" items="${wishlist}">
                                    <tr>

                                        <td>
                                            <img class="product-image"
                                                src="${pageContext.request.contextPath}/${w.imageUrl}">
                                        </td>

                                        <td class="name">${w.productName}</td>

                                        <td class="desc">${w.description}</td>

                                        <td class="price">Rs ${w.price}</td>

                                        <td>

                                            <a class="btn remove"
                                                href="${pageContext.request.contextPath}/remove-wishlist?id=${w.productId}">
                                                Remove
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </tbody>

                        </table>

                    </div>

                </c:if>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>