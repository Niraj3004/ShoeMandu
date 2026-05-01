<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Premium Shoes Store</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/AboutUs.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/footer.css" />
    
</head>

<body>

<jsp:include page="header.jsp" />

    <section class="about-banner">
        <img src="https://images.unsplash.com/photo-1596744288358-45428ce99fc4?q=80&w=1332&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="About Banner">

        <div class="about-banner-content">
            <h1>About Our Brand</h1>
            <p>Premium quality shoes crafted with passion since 2026</p>
        </div>
    </section>

    <div class="content-container">

        <section class="section-spacing">

            <div class="about-story">
                <div class="about-story-image">
                    <img src="https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?w=900&h=700&fit=crop" alt="">
                </div>

                <div class="about-story-text">
                    <h3>From Passion to Perfection</h3>
                    <p>Founded in 2026 by sneaker enthusiasts, we started with a simple vision: to create the world's
                        finest shoes that combine style, comfort, and durability. Today, we're proud to serve thousands
                        of customers worldwide with our premium collections.</p>
                    <p>very pair is crafted with premium materials and meticulous attention to detail in our
                        state-of-the-art facilities. We believe quality should never be compromised.</p>
                    <a href="#" class="primary-button">Explore Collection</a>
                </div>
            </div>

            <div class="company-stats">
                <div class="stats-card">
                    <div class="stats-number">10K+</div>
                    <div class="stats-title">Customers</div>
                </div>
                <div class="stats-card">
                    <div class="stats-number">50+</div>
                    <div class="stats-title">Designs</div>
                </div>
                <div class="stats-card">
                    <div class="stats-number">11+</div>
                    <div class="stats-title">Years</div>
                </div>
                <div class="stats-card">
                    <div class="stats-number">100%</div>
                    <div class="stats-title">Quality</div>
                </div>
            </div>
        </section>

        <section class="section-spacing">
            <h2 class="section-heading">Why Choose Us</h2>

            <div class="core-values">

                <div class="value-card">
                    <div class="value-icon"><i class="fa-solid fa-headset"></i></div>
                    <h3>24/7 Support</h3>
                    <p>Our team is available anytime for customer assistance.</p>
                </div>

                <div class="value-card">
                    <div class="value-icon"><i class="fa-solid fa-rotate-left"></i></div>
                    <h3>Easy Return</h3>
                    <p>Simple return process for a stress-free shopping experience.</p>
                </div>

                <div class="value-card">
                    <div class="value-icon"><i class="fa-solid fa-shield-halved"></i></div>
                    <h3>100% Genuine</h3>
                    <p>All products are authentic from trusted manufacturers.</p>
                </div>

                <div class="value-card">
                    <div class="value-icon"><i class="fa-solid fa-truck-fast"></i></div>
                    <h3>Fast Delivery</h3>
                    <p>Quick shipping to deliver your footwear on time.</p>
                </div>
            </div>
        </section>

        <section class="section-spacing">
            <h2 class="section-heading">Our Team</h2>

            <div class="team-members">
                <div class="member-card">
                    <div class="member-photo">
                        <img src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=400&h=400&fit=crop"
                            alt="">
                    </div>
                    <h3>John Carter</h3>
                    <div class="member-position">Founder</div>
                    <p>Leading the vision of our premium shoe brand.</p>
                </div>

                <div class="member-card">
                    <div class="member-photo">
                        <img src="https://images.unsplash.com/photo-1494790108755-2616b612b786?w=400&h=400&fit=crop"
                            alt="">
                    </div>
                    <h3>Sarah Lee</h3>
                    <div class="member-position">Designer</div>
                    <p>Creating stylish and comfortable footwear designs.</p>
                </div>

                <div class="member-card">
                    <div class="member-photo">
                        <img src="https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=400&h=400&fit=crop"
                            alt="">
                    </div>
                    <h3>Michael Kim</h3>
                    <div class="member-position">Production Head</div>
                    <p>Ensuring every pair meets our quality standards.</p>
                </div>

                <div class="member-card">
                    <div class="member-photo">
                        <img src="https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=400&h=400&fit=crop"
                            alt="">
                    </div>
                    <h3>Michael Kim</h3>
                    <div class="member-position">Production Head</div>
                    <p>Ensuring every pair meets our quality standards.</p>
                </div>

                <div class="member-card">
                    <div class="member-photo">
                        <img src="https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=400&h=400&fit=crop"
                            alt="">
                    </div>
                    <h3>Michael Kim</h3>
                    <div class="member-position">Production Head</div>
                    <p>Ensuring every pair meets our quality standards.</p>
                </div>

            </div>
        </section>

        <section class="about-action">
            <h2>Experience Premium Comfort</h2>
            <p>Discover footwear designed for your lifestyle.</p>
            <a href="#" class="primary-button">Shop Now</a>
        </section>

    </div>
    
     <jsp:include page="footer.jsp" />

</body>

</html>