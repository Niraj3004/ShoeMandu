<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Product Collection</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/product.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/footer.css" />
</head>
<body>

<jsp:include page="header.jsp" />

<div class="offer-banner">

    <div class="offer-slide">
        <img src="${pageContext.request.contextPath}/resources/images/banner/image1.webp" class="slide-bg">
        <div class="offer-content">
            <div class="offer-badge">NEW ARRIVALS</div>
            <h2 class="offer-title">Air Max Collection</h2>
            <p class="offer-subtitle">Latest styles just dropped - Get yours before they're gone!</p>
            <a href="#" class="offer-cta">Explore Collection</a>
        </div>
    </div>

    <div class="offer-slide">
        <img src="${pageContext.request.contextPath}/resources/images/about/header.jpg" class="slide-bg">
        <div class="offer-content">
            <div class="offer-badge">NEW ARRIVALS</div>
            <h2 class="offer-title">Nike Collection</h2>
            <p class="offer-subtitle">Latest styles just dropped - Get yours before they're gone!</p>
            <a href="#" class="offer-cta">Explore Collection</a>
        </div>
    </div>

    <div class="offer-slide">
        <img src="https://i.pinimg.com/1200x/1d/68/cc/1d68cc9d539624871427d5d022112d02.jpg" class="slide-bg">
        <div class="offer-content">
            <div class="offer-badge">FREE SHIPPING</div>
            <h2 class="offer-title">Boots Season</h2>
            <p class="offer-subtitle">Premium boots with free shipping on orders over $100</p>
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

    <div class="container">
        <!-- Filter Slidebar -->
        <div class="filter-sidebar">
            <div class="filter-group">
                <h4>Category</h4>
                <label class="filter-option">
                    <input type="checkbox"> Sneakers
                </label>
                <label class="filter-option">
                    <input type="checkbox"> Boots
                </label>
                <label class="filter-option">
                    <input type="checkbox"> Loafers
                </label>
                <label class="filter-option">
                    <input type="checkbox"> Sandals
                </label>
            </div>

            <div class="filter-group">
                <h4>Brand</h4>
                <label class="filter-option">
                    <input type="checkbox"> Nike
                </label>
                <label class="filter-option">
                    <input type="checkbox"> Adidas
                </label>
                <label class="filter-option">
                    <input type="checkbox"> Puma
                </label>
                <label class="filter-option">
                    <input type="checkbox"> New Balance
                </label>
            </div>

            <div class="filter-group">
                <h4>Size</h4>
                <label class="filter-option">
                    <input type="checkbox"> 7
                </label>
                <label class="filter-option">
                    <input type="checkbox"> 8
                </label>
                <label class="filter-option">
                    <input type="checkbox"> 9
                </label>
                <label class="filter-option">
                    <input type="checkbox"> 10
                </label>
                <label class="filter-option">
                    <input type="checkbox"> 11
                </label>
            </div>

            <div class="filter-group">
                <h4>Price Range</h4>
                <div class="price-range">
                    <div class="price-inputs">
                        <input type="number" placeholder="Rs 1500-10000" value="">
                    </div>
                </div>
            </div>

            <button class="clear-btn">Clear All</button>
            <button class="apply-btn">Apply Filters</button>
        </div>

        <!-- Products Section -->
        <div class="products-section">
            <div class="products-header">
                <div class="products-count">Showing 1-12 of 48 products</div>
                <select class="sort-select">
                    <option>Sort by: Featured</option>
                    <option>Price: Low to High</option>
                    <option>Price: High to Low</option>
                    <option>Newest</option>
                </select>
            </div>

            <div class="products-grid">
                <!-- Your exact product card design -->
                <div class="product-card">
                    <div class="product-image">
                        <img src="https://i.pinimg.com/1200x/5b/2f/01/5b2f016854f90bb89c30ae7c1c5f6be3.jpg" alt="Sneaker 4">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Stepora Sneaker 4</h3>
                        <div class="price">
                            <span class="offer-price">$85</span>
                            <span class="original-price">$115</span>
                        </div>
                        <div class="rating">
                            ★★★★☆
                        </div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>

                <!-- More product cards with different images -->
                <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400" alt="Sneaker 1">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Air Max Pro</h3>
                        <div class="price">
                            <span class="offer-price">$129</span>
                            <span class="original-price">$169</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>

                <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1605348532760-6753d2c43329?w=400" alt="Sneaker 2">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Classic Runner</h3>
                        <div class="price">
                            <span class="offer-price">$95</span>
                            <span class="original-price">$130</span>
                        </div>
                        <div class="rating">★★★★☆</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>

                <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1549298916-b41d501d3772?w=400" alt="Sneaker 3">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Urban Hiker</h3>
                        <div class="price">
                            <span class="offer-price">$75</span>
                            <span class="original-price">$105</span>
                        </div>
                        <div class="rating">★★★★☆</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>

                <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1543163528-9ca289720b04?w=400" alt="Sneaker 5">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Sport Elite</h3>
                        <div class="price">
                            <span class="offer-price">$145</span>
                            <span class="original-price">$195</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>
                
                  <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1543163528-9ca289720b04?w=400" alt="Sneaker 5">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Sport Elite</h3>
                        <div class="price">
                            <span class="offer-price">$145</span>
                            <span class="original-price">$195</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>
                
                  <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1543163528-9ca289720b04?w=400" alt="Sneaker 5">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Sport Elite</h3>
                        <div class="price">
                            <span class="offer-price">$145</span>
                            <span class="original-price">$195</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>
                
                  <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1543163528-9ca289720b04?w=400" alt="Sneaker 5">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Sport Elite</h3>
                        <div class="price">
                            <span class="offer-price">$145</span>
                            <span class="original-price">$195</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>
                
                  <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1543163528-9ca289720b04?w=400" alt="Sneaker 5">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Sport Elite</h3>
                        <div class="price">
                            <span class="offer-price">$145</span>
                            <span class="original-price">$195</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>
                
                  <div class="product-card">
                    <div class="product-image">
                        <img src="https://images.unsplash.com/photo-1543163528-9ca289720b04?w=400" alt="Sneaker 5">
                        <span class="favorite">&#10084;</span>
                    </div>
                    <div class="product-info">
                        <h3>Sport Elite</h3>
                        <div class="price">
                            <span class="offer-price">$145</span>
                            <span class="original-price">$195</span>
                        </div>
                        <div class="rating">★★★★★</div>
                        <button class="product-btn">Add to Cart</button>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    
     <jsp:include page="footer.jsp" />
</body>
</html>