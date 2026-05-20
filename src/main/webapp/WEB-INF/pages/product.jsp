<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Products - Shoesmandu</title>

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
        </head>

        <style>
        </style>

        <body>

            <jsp:include page="header.jsp" />

            <div class="offer-banner">

                <div class="offer-slide">
                    <img src="${pageContext.request.contextPath}/resources/images/banner/image1.webp" class="slide-bg">
                    <div class="offer-content">
                        <div class="offer-badge">NEW ARRIVALS</div>
                        <h2 class="offer-title">Air Max Collection</h2>
                        <p class="offer-subtitle">Latest styles just dropped - Get yours
                            before they're gone!</p>
                        <a href="#" class="offer-cta">Explore Collection</a>
                    </div>
                </div>

                <div class="offer-slide">
                    <img src="${pageContext.request.contextPath}/resources/images/about/header.jpg" class="slide-bg">
                    <div class="offer-content">
                        <div class="offer-badge">NEW ARRIVALS</div>
                        <h2 class="offer-title">Nike Collection</h2>
                        <p class="offer-subtitle">Latest styles just dropped - Get yours
                            before they're gone!</p>
                        <a href="#" class="offer-cta">Explore Collection</a>
                    </div>
                </div>

                <div class="offer-slide">
                    <img src="https://i.pinimg.com/1200x/1d/68/cc/1d68cc9d539624871427d5d022112d02.jpg"
                        class="slide-bg">
                    <div class="offer-content">
                        <div class="offer-badge">FREE SHIPPING</div>
                        <h2 class="offer-title">Boots Season</h2>
                        <p class="offer-subtitle">Premium boots with free shipping on
                            orders over $100</p>
                        <a href="#" class="offer-cta">Shop Boots</a>
                    </div>
                </div>


                <div class="offer-nav">
                    <div class="nav-dot active" data-slide="0"></div>
                    <div class="nav-dot" data-slide="1"></div>
                    <div class="nav-dot" data-slide="2"></div>
                </div>

                <script src="${pageContext.request.contextPath}/js/productbanner.js"></script>

            </div>

            <!--  MAIN CONTAINER  -->

            <div class="container">

                <!-- FILTER SIDEBAR -->
                <div class="filter-sidebar">

                    <form action="${pageContext.request.contextPath}/product" method="get">

                        <!-- CATEGORY -->
                        <div class="filter-group">
                            <h4>Category</h4>

                            <label class="filter-option"> <input type="radio" name="category" value="Sneakers"> Sneakers
                            </label> 
                            <label class="filter-option"> <input type="radio" name="category" value="Boots">
                                Boots
                            </label> <label class="filter-option"> <input type="radio" name="category" value="Loafers">
                                Loafers
                            </label> <label class="filter-option"> <input type="radio" name="category" value="Sandals">
                                Sandals
                            </label>
                        </div>

                        <!-- BRAND -->
                        <div class="filter-group">
                            <h4>Brand</h4>

                            <label class="filter-option"> <input type="radio" name="brand" value="Nike"> Nike
                            </label> <label class="filter-option"> <input type="radio" name="brand" value="Adidas">
                                Adidas
                            </label> <label class="filter-option"> <input type="radio" name="brand" value="Puma"> Puma
                            </label> <label class="filter-option"> <input type="radio" name="brand" value="New Balance">
                                New Balance
                            </label>
                        </div>

                        <!-- PRICE -->
                        <div class="filter-group">
                            <h4>Price Range</h4>

                            <div class="price-range">
                                <div class="price-inputs">

                                    <input type="number" name="minPrice" placeholder="Min Price">

                                    <input type="number" name="maxPrice" placeholder="Max Price">

                                </div>
                            </div>
                        </div>

                        <button type="submit" class="apply-btn">Apply Filters</button>

                        <a href="${pageContext.request.contextPath}/product" class="clear-btn"> Clear All </a>

                    </form>

                </div>

                <!-- PRODUCTS SECTION -->
                <div class="products-section">

                    <div class="products-header">

                        <div class="products-count">

                            <c:choose>

                                <c:when test="${not empty products}">
                                    Showing ${products.size()} products
                                </c:when>

                                <c:otherwise>
                                    No Products Found
                                </c:otherwise>

                            </c:choose>

                        </div>

                        <!-- SORT (WORKING WITH SERVLET) -->
                        <form action="${pageContext.request.contextPath}/product" method="get">

                            <input type="hidden" name="category" value="${param.category}">
                            <input type="hidden" name="brand" value="${param.brand}"> <input type="hidden"
                                name="minPrice" value="${param.minPrice}"> <input type="hidden" name="maxPrice"
                                value="${param.maxPrice}"> <select class="sort-select" name="sort"
                                onchange="this.form.submit()">

                                <option value="" ${empty param.sort ? 'selected' : '' }>Featured</option>
                                <option value="low" ${param.sort=='low' ? 'selected' : '' }>Low
                                    to High</option>
                                <option value="high" ${param.sort=='high' ? 'selected' : '' }>High
                                    to Low</option>
                                <option value="new" ${param.sort=='new' ? 'selected' : '' }>Newest</option>

                            </select>

                        </form>

                    </div>

                    <div class="products-grid">

                        <!-- DYNAMIC PRODUCTS -->
                        <c:forEach var="product" items="${products}">

                            <div class="product-card">

                                <!-- PRODUCT IMAGE -->
                                <div class="product-image">

                                    <a href="${pageContext.request.contextPath}/product-detail?id=${product.productId}">
                                        <img src="${pageContext.request.contextPath}/${product.imageUrl}"
                                            alt="${product.productName}">
                                    </a>

                                    <!-- WISHLIST -->
                                    <form action="${pageContext.request.contextPath}/add-to-wishlist" method="post">

                                        <input type="hidden" name="productId" value="${product.productId}">

                                        <button type="submit" class="favorite"
                                            style="border: none; background: none; cursor: pointer;">

                                            &#10084;</button>

                                    </form>

                                </div>

                                <!-- PRODUCT INFO -->
                                <div class="product-info">

                                    <h3>${product.productName}</h3>

                                    <p>${product.brand}|${product.category}</p>

                                    <div class="price">

                                        <span class="offer-price"> Rs ${product.price} </span>

                                    </div>

                                    <div class="rating">★★★★☆</div>

                                    <p class="stock">Stock: ${product.stock}</p>

                                    <!-- ADD TO CART -->
                                    <form action="${pageContext.request.contextPath}/add-to-cart" method="post">

                                        <input type="hidden" name="productId" value="${product.productId}">

                                        <button type="submit" class="product-btn">Add to Cart</button>

                                    </form>

                                </div>

                            </div>

                        </c:forEach>

                    </div>

                </div>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>