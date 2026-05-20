<%@ page contentType="text/html; charset=UTF-8" %>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>

            <meta charset="UTF-8">

            <title>My Cart</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css" />

        </head>

        <body>

            <jsp:include page="header.jsp" />

            <div class="cart-container">

                <h1 class="page-title">My Cart</h1>

                <!-- SUCCESS -->
                <c:if test="${not empty sessionScope.success}">
                    <div class="success-message">${sessionScope.success}</div>
                    <c:remove var="success" scope="session" />
                </c:if>

                <!-- ERROR -->
                <c:if test="${not empty sessionScope.error}">
                    <div class="error-message">${sessionScope.error}</div>
                    <c:remove var="error" scope="session" />
                </c:if>

                <!-- EMPTY CART -->
                <c:if test="${empty cartItems}">
                    <div class="empty-cart">Your cart is empty</div>
                </c:if>

                <!-- CART TABLE -->
                <c:if test="${not empty cartItems}">

                    <div class="table-container">

                        <table class="cart-table">

                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Product</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>

                            <tbody>

                                <c:set var="grandTotal" value="0" />

                                <c:forEach var="c" items="${cartItems}">

                                    <tr>

                                        <!-- IMAGE -->
                                        <td><img class="product-image"
                                                src="${pageContext.request.contextPath}/${c.imageUrl}"></td>

                                        <!-- PRODUCT -->
                                        <td>
                                            <div class="product-name">${c.productName}</div>
                                        </td>

                                        <!-- DESCRIPTION -->
                                        <td>
                                            <div class="description">${c.description}</div>
                                        </td>

                                        <!-- PRICE -->
                                        <td>
                                            <div class="price">Rs ${c.price}</div>
                                        </td>

                                        <!-- QUANTITY -->
                                        <td>

                                            <form action="${pageContext.request.contextPath}/UpdateCart" method="post">

                                                <input type="hidden" name="cartId" value="${c.cartId}">

                                                <input class="quantity-input" type="number" name="quantity"
                                                    value="${c.quantity}" min="1">

                                                <button class="btn update-btn" type="submit">Update</button>

                                            </form>

                                        </td>

                                        <!-- TOTAL -->
                                        <td>
                                            <div class="total">Rs ${c.price * c.quantity}</div>
                                        </td>

                                        <!-- REMOVE -->
                                        <td><a class="btn remove-btn"
                                                href="${pageContext.request.contextPath}/delete-cart?cartId=${c.cartId}">
                                                Remove </a></td>

                                    </tr>

                                    <c:set var="grandTotal" value="${grandTotal + (c.price * c.quantity)}" />

                                </c:forEach>

                            </tbody>

                        </table>

                    </div>

                    <!-- CART SUMMARY CARD -->
                    <div class="cart-summary-wrapper">

                        <div class="summary-card">

                            <h2>Cart Summary</h2>

                            <div class="summary-row">
                                <span>Total Items</span> <span>${cartItems.size()}</span>
                            </div>

                            <div class="summary-row total">
                                <span>Grand Total</span> <span>Rs ${grandTotal}</span>
                            </div>

                            <form action="${pageContext.request.contextPath}/checkout" method="post">
                                <button type="submit" class="checkout-btn">Place Order</button>
                            </form>

                            <a href="${pageContext.request.contextPath}/orders" class="orders-btn"> View My Orders </a>

                        </div>

                    </div>

                </c:if>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>