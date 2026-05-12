<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>shoesmandu home</title>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel="stylesheet" href="/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css" />
</head>

	<c:if test="${not empty sessionScope.error}">
    <div class="alert error">${sessionScope.error}</div>
    <c:remove var="error" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.success}">
    <div class="alert success">${sessionScope.success}</div>
    <c:remove var="success" scope="session"/>
</c:if>

<body>
 <jsp:include page="header.jsp" />

	<!-- HOME SLIDER -->
<section class="home-slider">

    <!-- SLIDE 1 -->
    <div class="slide active">
        <div class="slide-content">
            <h1>Step Into Style</h1>
            <p>Discover premium sneakers and sports shoes only at Shoesmandu.</p>

            <div class="slider-buttons">
                <a href="#" class="shop-btn">Shop Now</a>
                <a href="#" class="explore-btn">Explore</a>
            </div>
        </div>

        <div class="slide-image">
            <img src="${pageContext.request.contextPath}/resources/images/home/744-Sky-Female1.jpg" alt="Sneaker 1"
                alt="Nike Shoe">
        </div>
    </div>

    <!-- SLIDE 2 -->
    <div class="slide">
        <div class="slide-content">
            <h1>Run With Confidence</h1>
            <p>Comfort meets performance with our newest running collection.</p>

            <div class="slider-buttons">
                <a href="#" class="shop-btn">Buy Now</a>
                <a href="#" class="explore-btn">View Collection</a>
            </div>
        </div>

        <div class="slide-image">
            <img src="${pageContext.request.contextPath}/resources/images/home/746-white4.jpg" alt="Sneaker 4"
                alt="Running Shoe">
        </div>
    </div>

    <!-- SLIDE 3 -->
    <div class="slide">
        <div class="slide-content">
            <h1>Fashion Starts From Feet</h1>
            <p>Trending sneakers for every style and every generation.</p>

            <div class="slider-buttons">
                <a href="#" class="shop-btn">Shop Trend</a>
                <a href="#" class="explore-btn">Learn More</a>
            </div>
        </div>

        <div class="slide-image">
            <img src="https://images.unsplash.com/photo-1608231387042-66d1773070a5?q=80&w=1200&auto=format&fit=crop"
                alt="Fashion Shoe">
        </div>
    </div>

    <!-- ARROWS -->
    <button class="prev">
        <i class="fa-solid fa-chevron-left"></i>
    </button>

    <button class="next">
        <i class="fa-solid fa-chevron-right"></i>
    </button>

</section>

     <script src="${pageContext.request.contextPath}/js/homebanner.js"></script>
     

 <section class="home-products">
        <h2 class="section-title">New Arrivals</h2>
        <div class="product-container">

            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/resources/images/home/744-Sky-Female1.jpg" alt="Sneaker 1">

                </div>
                <div class="product-info">
                    <h3>744-Sky-Female1</h3>
                    <div class="price">
                        <span class="offer-price">Rs 800</span>
                        <span class="original-price">Rs 120</span>
                    </div>
                    <div class="rating">
                        ★★★★☆
                    </div>
                    <button class="product-btn">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/resources/images/home/745-Blush-4.jpg" alt="Sneaker 2">
                   
                </div>
                <div class="product-info">
                    <h3>745-Blush-4</h3>
                    <div class="price">
                        <span class="offer-price">Rs 700</span>
                        <span class="original-price">Rs 100</span>
                    </div>
                    <div class="rating">
                        ★★★★☆    
                    </div>
                    <button class="product-btn">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/resources/images/home/746-sky-uni2.jpg" alt="Sneaker 3">
                   
                </div>
                <div class="product-info">
                    <h3>746-sky-uni2</h3>
                    <div class="price">
                        <span class="offer-price">Rs 900</span>
                        <span class="original-price">Rs 130</span>
                    </div>
                    <div class="rating">
                        ★★★★☆
                    </div>
                    <button class="product-btn">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/resources/images/home/746-white4.jpg" alt="Sneaker 4">
                 
                </div>
                <div class="product-info">
                    <h3>746-white4</h3>
                    <div class="price">
                        <span class="offer-price">Rs 850</span>
                        <span class="original-price">Rs 115</span>
                    </div>
                    <div class="rating">
                        ★★★★☆
                    </div>
                    <button class="product-btn">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/resources/images/home/563G-Julio-White-1.jpg" alt="Sneaker 4">
                   
                </div>
                <div class="product-info">
                    <h3>563G-Julio-White-1</h3>
                    <div class="price">
                        <span class="offer-price">Rs 950</span>
                        <span class="original-price">Rs 115</span>
                    </div>
                    <div class="rating">
                        ★★★★☆
                    </div>
                    <button class="product-btn">Add to Cart</button>
                </div>
            </div>

        </div>
    </section>
    
       <h2 class="category" style="text-align:center;">
    Shop By Category
</h2>
    
    <div class="container-category">
    <!-- Casual -->
    <div class="card">
        <img src="${pageContext.request.contextPath}/resources/images/home/casualsneaker.jpg" alt="">
        <div class="overlay">
            <h3>Casual Shoes</h3>
            <a href="casual.html">Shop Now</a>
        </div>
    </div>

    <!-- Formal -->
    <div class="card">
        <img src="${pageContext.request.contextPath}/resources/images/home/formal.jpg" alt="">
        <div class="overlay">
            <h3>Formal Shoes</h3>
            <a href="formal.html">Shop Now</a>
        </div>
    </div>

    <!-- Sports -->
    <div class="card">
        <img src="${pageContext.request.contextPath}/resources/images/home/sports.jpg" alt="">
        <div class="overlay">
            <h3>Sports Shoes</h3>
            <a href="sports.html">Shop Now</a>
        </div>
    </div>

   
    <div class="card">
        <img src="${pageContext.request.contextPath}/resources/images/home/boots.jpg" alt="">
        <div class="overlay">
            <h3>Boots</h3>
            <a href="boots.html">Shop Now</a>
        </div>
    </div>

</div>

    <div class="emotion">
        <!-- WOMEN CONTAINER -->
        <div class="card women-card">
            <img src="https://i.pinimg.com/1200x/8c/3a/54/8c3a54f7a75a87c00dea479f38dbac76.jpg" alt="Women Fashion">
            <div class="overlay">
                <p>NEW ARRIVAL</p>
                <h1>Himalyan Crafted</h1>
                <a href="#" class="btn">SHOP Women</a>
            </div>
        </div>

        <!-- MEN CONTAINER -->
        <div class="card men-card">
            <img src="https://i.pinimg.com/1200x/d6/96/ed/d696ed707f1fa674ed6334282cf85165.jpg" alt="Men Fashion">
            <div class="overlay">
                <p>NEW ARRIVAL</p>
                <h1>“Goldstar  Walking the World for Over Five Decades”. From Nepal to every continent, our journey continues.</h1>
                <a href="#" class="btn">Learn More</a>
            </div>
        </div>
    </div>
     
     
 <section class="home-banner">
        <div class="banner-container">

            <div class="banner-content">
                <h1>Step Into Style with ShoesMandu</h1>

                <p>
                    Discover the latest collection of trendy, comfortable, and high-quality shoes
                    for every occasion.
                </p>

                <p>
                    From casual sneakers to premium footwear, ShoesMandu brings you style, durability,
                    and comfort all at the best prices.
                </p>

                <button class="banner-btn">Shop Now</button>
            </div>

            <div class="banner-image">
                <img src="${pageContext.request.contextPath}/resources/images/home/744-Sky-Female1.jpg"
                    alt="shoes">
            </div>

        </div>
    </section>
    
    
    <section class="deals-section">

    <!-- HEADER -->
    <div class="deals-header">
        <div>
            <span class="deals-title">Maha Sales </span>
            <span>Ends In:</span>

            <div class="timer">
                <div class="timer-box" id="hours">05</div>
                <div class="timer-box" id="minutes">58</div>
                <div class="timer-box" id="seconds">25</div>
            </div>
        </div>

        <a href="#" class="view-all">View All</a>
    </div>
    
    

    <!-- PRODUCTS -->
    <div class="deals-grid">

        <!-- CARD 1 -->
        <div class="deal-card">
            <div class="deal-image">
                <span class="discount-badge">-20% OFF</span>
                <img src="${pageContext.request.contextPath}/resources/images/home/converse men.jpg">
            </div>
            <div class="deal-info">
                <div class="brand">Converse</div>
                <div class="product-name">744-Sky-Men1</div>
                <div class="price-box">
                    <span class="new-price">Rs 800</span>
                    <span class="old-price">Rs 1200</span>
                </div>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>

        <!-- CARD 2 -->
        <div class="deal-card">
            <div class="deal-image">
                <span class="discount-badge">-15% OFF</span>
                <img src="${pageContext.request.contextPath}/resources/images/home/new balance men.jpg">
            </div>
            <div class="deal-info">
                <div class="brand">New balance</div>
                <div class="product-name">745-Blush-4-Men</div>
                <div class="price-box">
                    <span class="new-price">Rs 700</span>
                    <span class="old-price">Rs 1000</span>
                </div>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>

        <div class="deal-card">
            <div class="deal-image">
                <span class="discount-badge">-20% OFF</span>
                <img src="${pageContext.request.contextPath}/resources/images/home/women blush.jpg">
            </div>
            <div class="deal-info">
                <div class="brand">Sneaker</div>
                <div class="product-name">7467-Sky-Female1</div>
                <div class="price-box">
                    <span class="new-price">Rs 800</span>
                    <span class="old-price">Rs 1200</span>
                </div>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>

        <div class="deal-card">
            <div class="deal-image">
                <span class="discount-badge">-20% OFF</span>
                <img src="${pageContext.request.contextPath}/resources/images/home/women boots.jpg">
            </div>
            <div class="deal-info">
                <div class="brand">Boots</div>
                <div class="product-name">7456-Sky-Female</div>
                <div class="price-box">
                    <span class="new-price">Rs 800</span>
                    <span class="old-price">Rs 1200</span>
                </div>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>

        <div class="deal-card">
            <div class="deal-image">
                <span class="discount-badge">-20% OFF</span>
                <img src="${pageContext.request.contextPath}/resources/images/home/women sambha.jpg">
            </div>
            <div class="deal-info">
                <div class="brand">Sambha</div>
                <div class="product-name">women sambha</div>
                <div class="price-box">
                    <span class="new-price">Rs 800</span>
                    <span class="old-price">Rs 1200</span>
                </div>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>

    </div>
</section>

 <script src="${pageContext.request.contextPath}/js/deals.js"></script>
     


<section class="brands-section">
    <h2>Our Brands</h2>

    <div class="brands-slider">
        <div class="brands-track">

            <!-- Original logos -->
            <img src="${pageContext.request.contextPath}/resources/images/home/nike.jpg" alt="Nike">
            <img src="${pageContext.request.contextPath}/resources/images/home/adidas.jpg" alt="Adidas">
            <img src="${pageContext.request.contextPath}/resources/images/home/converse.jpg" alt="Puma">
            <img src="${pageContext.request.contextPath}/resources/images/home/puma.jpg" alt="Reebok">
            <img src="${pageContext.request.contextPath}/resources/images/home/rebook.jpg" alt="Converse">

            <img src="${pageContext.request.contextPath}/resources/images/home/nike.jpg" alt="Nike">
            <img src="${pageContext.request.contextPath}/resources/images/home/adidas.jpg" alt="Nike">
            <img src="${pageContext.request.contextPath}/resources/images/home/converse.jpg" alt="Nike">
            <img src="${pageContext.request.contextPath}/resources/images/home/puma.jpg" alt="Nike">
            <img src="${pageContext.request.contextPath}/resources/images/home/rebook.jpg" alt="Nike">

        </div>
    </div>
</section>

	  <script src="${pageContext.request.contextPath}/js/brands.js"></script>
	

	<section class="shoesmandu-testimonials">
		<h2 class="testimonials-title">What Our Customers Say</h2>
		<div class="testimonials-wrapper">

			<div class="testimonial-item">
				<img class="testimonial-user"
					src="https://i.pinimg.com/736x/ff/a9/d7/ffa9d7bbf64e91260778fe572018637a.jpg"
					alt="Amit">
				<div class="testimonial-rating">★★★★☆</div>
				<p class="testimonial-comment">"ShoesMandu shoes are extremely
					comfortable and stylish."</p>
				<h4 class="testimonial-name">Amit</h4>
			</div>

			<div class="testimonial-item">
				<img class="testimonial-user"
					src="https://i.pinimg.com/1200x/b4/f1/4c/b4f14c44163d0c689ca5ed8843c347a3.jpg"
					alt="Sumit">
				<div class="testimonial-rating">★★★★★</div>
				<p class="testimonial-comment">"Fast delivery and excellent
					customer service."</p>
				<h4 class="testimonial-name">Sumit</h4>
			</div>

			<div class="testimonial-item">
				<img class="testimonial-user"
					src="https://i.pinimg.com/736x/30/e3/1e/30e31ea32d4e39cbf30a8b5962eaba16.jpg"
					alt="Puja">
				<div class="testimonial-rating">★★★☆☆</div>
				<p class="testimonial-comment">"100% genuine products,
					hassle-free returns"</p>
				<h4 class="testimonial-name">Puja</h4>
			</div>

			<div class="testimonial-item">
				<img class="testimonial-user"
					src="https://i.pinimg.com/1200x/9e/59/53/9e595397e37f2e29ffd99587ca38d863.jpg"
					alt="Sita">
				<div class="testimonial-rating">★★★☆☆</div>
				<p class="testimonial-comment">"The sneakers fit perfectly and
					feel amazing."</p>
				<h4 class="testimonial-name">Sita</h4>
			</div>

		</div>
	</section>
	
	

	<section class="newsletterr-section">
		<h2>Subscribe for Exclusive Offers</h2>
		<p>Get 10% off your first purchase!</p>
		<form class="newsletter-formm">
			<input type="email" placeholder="Enter your email">
			<button type="submit">Subscribe</button>
		</form>
	</section>

    <jsp:include page="footer.jsp" />

</body>

</html>