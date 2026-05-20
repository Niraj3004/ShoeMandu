<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>

            <meta charset="UTF-8">

            <title>${product.productName}</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product-detail.css">

        </head>

        <body>

            <jsp:include page="header.jsp" />

            <div class="product-detail-container">

                <!-- LEFT IMAGE -->
                <div class="product-image-box">

                    <img src="${pageContext.request.contextPath}/${product.imageUrl}" alt="${product.productName}">

                </div>

                <!-- RIGHT INFO -->
                <div class="product-info-box">

                    <div class="category">
                        ${product.category}
                    </div>

                    <h1>
                        ${product.productName}
                    </h1>

                    <div class="brand">
                        Brand : ${product.brand}
                    </div>

                    <div class="price">
                        Rs ${product.price}
                    </div>

                    <div class="stock">

                        <c:choose>

                            <c:when test="${product.stock > 0}">
                                In Stock (${product.stock})
                            </c:when>

                            <c:otherwise>
                                Out Of Stock
                            </c:otherwise>

                        </c:choose>

                    </div>

                    <div class="description">

                        ${product.description}

                    </div>

                    <!-- BUTTONS -->
                    <div class="buttons">

                        <!-- ADD TO CART -->
                        <form action="${pageContext.request.contextPath}/add-to-cart" method="post">

                            <input type="hidden" name="productId" value="${product.productId}">

                            <button type="submit" class="cart-btn">

                                Add To Cart

                            </button>

                        </form>

                        <!-- WISHLIST -->
                        <form action="${pageContext.request.contextPath}/add-to-wishlist" method="post">

                            <input type="hidden" name="productId" value="${product.productId}">

                            <button type="submit" class="wish-btn">

                                Wishlist

                            </button>

                        </form>

                    </div>

                    <!-- BACK -->
                    <a href="${pageContext.request.contextPath}/product" class="back-btn">

                        ← Back To Products

                    </a>

                </div>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>