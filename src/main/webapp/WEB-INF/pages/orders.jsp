<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>

            <title>My Orders</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orders.css">

        </head>

        <body>

            <jsp:include page="header.jsp" />

            <div class="orders-container">

                <h1 class="page-title">My Orders</h1>

                <c:if test="${empty orders}">
                    <div class="empty-box">No orders found</div>
                </c:if>

                <c:forEach var="order" items="${orders}">

                    <div class="order-card">

                        <div class="order-img">
                            <img src="${pageContext.request.contextPath}/${order.imageUrl}">
                        </div>

                        <div class="order-details">

                            <h2>${order.productName}</h2>

                            <p class="desc">${order.description}</p>

                            <div class="info-row">
                                <span>Qty: ${order.quantity}</span>
                                <span>Order ID: #${order.orderId}</span>
                            </div>

                            <div class="price">
                                Rs ${order.price * order.quantity}
                            </div>

                            <div class="status ${order.orderStatus}">
                                ${order.orderStatus}
                            </div>

                            <div class="address">
                                ${order.shippingAddress}
                            </div>

                        </div>

                    </div>

                </c:forEach>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>