<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Products - Shoesmandu</title>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/product.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/header.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/footer.css">
</head>

<body>

<jsp:include page="header.jsp"/>

<!--  BANNER  -->
<div class="offer-banner">
    <img src="${pageContext.request.contextPath}/resources/images/banner/image1.webp"
         class="slide-bg">
</div>

<!--  MAIN CONTAINER  -->
<div class="container">

    <!--  FILTER -->
    <div class="filter-sidebar">

        <form action="${pageContext.request.contextPath}/product" method="get">

            <h4>Category</h4>
            <button name="category" value="Sneakers" type="submit">Sneakers</button>
            <button name="category" value="Boots" type="submit">Boots</button>
            <button name="category" value="Casual" type="submit">Casual</button>
            <button name="category" value="Formal" type="submit">Formal</button>

            <h4>Brand</h4>
            <button name="brand" value="Nike" type="submit">Nike</button>
            <button name="brand" value="Adidas" type="submit">Adidas</button>
            <button name="brand" value="Puma" type="submit">Puma</button>

            <h4>Price</h4>
            <button name="minPrice" value="0" type="submit">Under 5K</button>
            <button name="minPrice" value="5000" type="submit">5K+</button>
            <button name="minPrice" value="10000" type="submit">10K+</button>

            <input type="hidden" name="maxPrice" value="1000000">

            <a href="${pageContext.request.contextPath}/product"
               class="clear-btn">Clear All</a>

        </form>

    </div>

    <!--  PRODUCTS  -->
    <div class="products-section">

        <div class="products-header">
            <h3>
                <c:choose>
                    <c:when test="${not empty products}">
                        ${products.size()} Products Found
                    </c:when>
                    <c:otherwise>
                        No Products Found
                    </c:otherwise>
                </c:choose>
            </h3>
        </div>

        <div class="products-grid">

            <c:forEach var="p" items="${products}">

                <div class="product-card">

                    <!-- IMAGE -->
                    <div class="product-image">

                        <img src="${pageContext.request.contextPath}/${p.imageUrl}"
                             alt="${p.productName}">

                        <!-- WISHLIST -->
                        <form action="${pageContext.request.contextPath}/add-to-wishlist"
                              method="post" class="wishlist-form">

                            <input type="hidden" name="productId" value="${p.productId}">

                            <button type="submit" class="favorite">
                                <i class="fa fa-heart"></i>
                            </button>

                        </form>

                    </div>

                    <!-- INFO -->
                    <div class="product-info">

                        <h3>${p.productName}</h3>

                        <p>${p.brand} | ${p.category}</p>

                        <div class="price">Rs ${p.price}</div>

                        <p class="stock">Stock: ${p.stock}</p>

                        <!-- ADD TO CART -->
                        <form action="${pageContext.request.contextPath}/add-to-cart"
                              method="post">

                            <input type="hidden" name="productId" value="${p.productId}">

                            <button type="submit" class="product-btn">
                                <i class="fa fa-shopping-cart"></i> Add to Cart
                            </button>

                        </form>

                    </div>

                </div>

            </c:forEach>

        </div>

    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>
</html>