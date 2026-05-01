<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Stepora Navbar Enhanced Search</title>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel="stylesheet" href="/main.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/footer.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home.css" />
</head>

<body>
 <jsp:include page="header.jsp" />

	<section class="home-banner">
		<div class="banner-slider">

			<!-- Slide 1 -->
			<div class="banner-slide active">
				<div class="banner-container">
					<div class="banner-content">
						<h1>Stepora New Collection</h1>
						<p>
							Explore our latest sneaker designs, crafted for comfort and
							style. <br>
							<br> Enjoy exclusive offers, free delivery, and 100% genuine
							products only at Stepora.
						</p>
						<button class="banner-btn">Shop Now</button>
					</div>
					<div class="banner-image">
						<img
							src="https://i.pinimg.com/736x/cd/8f/08/cd8f0805c6ba64dc16f15f6aad298f69.jpg"
							alt="Stepora Shoes">
					</div>
				</div>
			</div>

			<!-- Slide 2 -->
			<div class="banner-slide">
				<div class="banner-container">
					<div class="banner-content">
						<h1>Limited Edition Sneakers</h1>
						<p>
							Stepora brings you limited edition sneakers with unique designs.
							<br>
							<br> Grab them before they are gone!
						</p>
						<button class="banner-btn">Shop Now</button>
					</div>
					<div class="banner-image">
						<img
							src="https://i.pinimg.com/736x/6c/6f/3a/6c6f3a6d77a5d4b1e219303946937679.jpg"
							alt="Limited Sneakers">
					</div>
				</div>
			</div>

			<!-- Slide 3 -->
			<div class="banner-slide">
				<div class="banner-container">
					<div class="banner-content">
						<h1>Stepora Best Sellers</h1>
						<p>
							Our most loved sneakers by Stepora fans. <br>
							<br> Comfort, style, and quality in one perfect pair.
						</p>
						<button class="banner-btn">Shop Now</button>
					</div>
					<div class="banner-image">
						<img
							src="https://i.pinimg.com/736x/b4/c3/fb/b4c3fb6bca5c63962199bf62e9d35abc.jpg"
							alt="Best Sellers">
					</div>
				</div>
			</div>

		</div>
	</section>

	<section class="home-products">
		<h2 class="section-title">New Arrivals</h2>
		<div class="product-container">

			<div class="product-card">
				<div class="product-image">
					<img
						src="https://i.pinimg.com/1200x/50/7c/11/507c11dd5cae613163d93dc9ceb82305.jpg"
						alt="Sneaker 1"> <span class="favorite">&#10084;</span>
				</div>
				<div class="product-info">
					<h3>Stepora Sneaker 1</h3>
					<div class="price">
						<span class="offer-price">$80</span> <span class="original-price">$120</span>
					</div>
					<div class="rating">★★★★☆</div>
					<button class="product-btn">Add to Cart</button>
				</div>
			</div>

			<div class="product-card">
				<div class="product-image">
					<img
						src="https://i.pinimg.com/1200x/84/15/d5/8415d53e44c22d52365ffb4e39ecfcc3.jpg"
						alt="Sneaker 2"> <span class="favorite">&#10084;</span>
				</div>
				<div class="product-info">
					<h3>Stepora Sneaker 2</h3>
					<div class="price">
						<span class="offer-price">$70</span> <span class="original-price">$100</span>
					</div>
					<div class="rating">★★★★☆</div>
					<button class="product-btn">Add to Cart</button>
				</div>
			</div>

			<div class="product-card">
				<div class="product-image">
					<img
						src="https://i.pinimg.com/1200x/1c/e0/fa/1ce0fa36cb9915510d42676d4e0b7fa9.jpg"
						alt="Sneaker 3"> <span class="favorite">&#10084;</span>
				</div>
				<div class="product-info">
					<h3>Stepora Sneaker 3</h3>
					<div class="price">
						<span class="offer-price">$90</span> <span class="original-price">$130</span>
					</div>
					<div class="rating">★★★★☆</div>
					<button class="product-btn">Add to Cart</button>
				</div>
			</div>

			<div class="product-card">
				<div class="product-image">
					<img
						src="https://i.pinimg.com/1200x/6f/c0/27/6fc0271ccccd9d54f42c81071aad60f1.jpg"
						alt="Sneaker 4"> <span class="favorite">&#10084;</span>
				</div>
				<div class="product-info">
					<h3>Stepora Sneaker 4</h3>
					<div class="price">
						<span class="offer-price">$85</span> <span class="original-price">$115</span>
					</div>
					<div class="rating">★★★★☆</div>
					<button class="product-btn">Add to Cart</button>
				</div>
			</div>

			<div class="product-card">
				<div class="product-image">
					<img
						src="https://i.pinimg.com/736x/f0/0a/7a/f00a7a02166c6620b669c37527a5d5a6.jpg"
						alt="Sneaker 4"> <span class="favorite">&#10084;</span>
				</div>
				<div class="product-info">
					<h3>Stepora Sneaker 4</h3>
					<div class="price">
						<span class="offer-price">$85</span> <span class="original-price">$115</span>
					</div>
					<div class="rating">★★★★☆</div>
					<button class="product-btn">Add to Cart</button>
				</div>
			</div>

		</div>
	</section>

	<section class="brands-section">
		<h2>Our Brands</h2>
		<div class="brands-grid">
			<img
				src="https://i.pinimg.com/1200x/1f/b4/7e/1fb47eae62439eb56c30e9673830d957.jpg"
				alt="Nike"> <img
				src="https://i.pinimg.com/1200x/9f/11/7c/9f117cbbc2095f6312bb2f6fd36e57c3.jpg"
				alt="Adidas"> <img
				src="https://i.pinimg.com/1200x/2f/f4/b4/2ff4b4ebab30c52ce08117d57b19ac6b.jpg"
				alt="Puma"> <img
				src="https://i.pinimg.com/1200x/1c/19/24/1c19243e84f63877b9eaf193606b7525.jpg"
				alt="Reebok"> <img
				src="https://i.pinimg.com/1200x/5c/79/9c/5c799c74aaa5574f1d72a0581d5a005c.jpg"
				alt="Converse">
		</div>
	</section>

	<section class="stepora-testimonials">
		<h2 class="testimonials-title">What Our Customers Say</h2>
		<div class="testimonials-wrapper">

			<div class="testimonial-item">
				<img class="testimonial-user"
					src="https://i.pinimg.com/736x/ff/a9/d7/ffa9d7bbf64e91260778fe572018637a.jpg"
					alt="Amit">
				<div class="testimonial-rating">★★★★☆</div>
				<p class="testimonial-comment">"Stepora shoes are extremely
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

	<section class="newsletter-section">
		<h2>Subscribe for Exclusive Offers</h2>
		<p>Get 10% off your first purchase!</p>
		<form class="newsletter-form">
			<input type="email" placeholder="Enter your email">
			<button type="submit">Subscribe</button>
		</form>
	</section>

    <jsp:include page="footer.jsp" />

</body>

</html>