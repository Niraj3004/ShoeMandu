<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - Premium Shoes Store</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Contact.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/footer.css" />
</head>

<body>

<jsp:include page="header.jsp" />

    <section class="contact-banner">
        <img src="https://i.pinimg.com/736x/85/7c/4b/857c4b7b12c5b87e6ea530a9bfc940cf.jpg">
        <div class="contact-banner-content">
            <h1>Contact Us</h1>
            <p>We are here to help with your footwear needs</p>
        </div>
    </section>

    <div class="page-container">

        <section class="section-space">
            <h2 class="section-title">Get In Touch</h2>

            <div class="contact-layout">

                <div class="contact-details-box">
                    <div class="contact-info-item">
                        <div class="contact-info-icon"><i class="fa-solid fa-phone"></i></div>
                        <div class="contact-info-text">
                            <h3>Phone</h3>
                            <p>+1 (555) 123-4567</p>
                        </div>
                    </div>

                    <div class="contact-info-item">
                        <div class="contact-info-icon"><i class="fa-solid fa-envelope"></i></div>
                        <div class="contact-info-text">
                            <h3>Email</h3>
                            <p>hello@shoestore.com</p>
                        </div>
                    </div>

                    <div class="contact-info-item">
                        <div class="contact-info-icon"><i class="fa-solid fa-location-dot"></i></div>
                        <div class="contact-info-text">
                            <h3>Address</h3>
                            <p>123 Fashion Street, New York, NY</p>
                        </div>
                    </div>

                    <div class="contact-info-item">
                        <div class="contact-info-icon"><i class="fa-solid fa-clock"></i></div>
                        <div class="contact-info-text">
                            <h3>Working Hours</h3>
                            <p>Mon - Sun : 9:00 AM - 9:00 PM</p>
                        </div>
                    </div>
                </div>

                <div class="contact-form-box">
                    <h3>Send Message</h3>

                    <form>
                        <div class="input-row">
                            <div class="input-group">
                                <label>First Name</label>
                                <input type="text" placeholder="First name">
                            </div>

                            <div class="input-group">
                                <label>Last Name</label>
                                <input type="text" placeholder="Last name">
                            </div>
                        </div>

                        <div class="input-group">
                            <label>Email Address</label>
                            <input type="email" placeholder="Your email">
                        </div>

                        <div class="input-group">
                            <label>Subject</label>
                            <select>
                                <option>Select subject</option>
                                <option>Order Inquiry</option>
                                <option>Returns</option>
                                <option>Support</option>
                            </select>
                        </div>

                        <div class="input-group">
                            <label>Message</label>
                            <textarea placeholder="Write your message"></textarea>
                        </div>

                        <button class="submit-button" type="submit">Send Message</button>
                    </form>
                </div>

            </div>

            <div class="location-map">
                <iframe src="https://www.google.com/maps?q=Kahmandu&output=embed"></iframe>
            </div>

            <section class="faq-section">
                <h2 class="section-title">Quick FAQs</h2>

                <div class="faq-list">

                    <details class="faq-item">
                        <summary>How long does delivery take?</summary>
                        <p>
                            Standard delivery usually takes 3 to 7 business days depending on your location.
                        </p>
                    </details>

                    <details class="faq-item">
                        <summary>Can I return my order?</summary>
                        <p>
                            Yes, you can return unused products within 14 days of delivery.
                        </p>
                    </details>

                    <details class="faq-item">
                        <summary>Are all products original?</summary>
                        <p>
                            Yes, every product in our store is 100% genuine and quality checked.
                        </p>
                    </details>

                    <details class="faq-item">
                        <summary>How can I track my order?</summary>
                        <p>
                            After shipping, we send a tracking link to your email address.
                        </p>
                    </details>

                </div>
            </section>

        </section>
    </div>
    
     <jsp:include page="footer.jsp" />

</body>

</html>