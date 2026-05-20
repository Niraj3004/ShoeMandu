<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>

            <title>Admin Orders</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-orders.css">

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

        </head>

        <body>

            <div class="admin-container">

                <a href="${pageContext.request.contextPath}/dashboard" class="back-btn"> <i
                        class="fa fa-arrow-left"></i> Back Dashboard

                </a>

                <h1>Orders Dashboard</h1>

                <c:if test="${not empty success}">
                    <div class="msg success">${success}</div>
                    <c:remove var="success" scope="session" />
                </c:if>

                <c:if test="${not empty error}">
                    <div class="msg error">${error}</div>
                    <c:remove var="error" scope="session" />
                </c:if>

                <table>

                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer</th>
                            <th>Product</th>
                            <th>Image</th>
                            <th>Qty</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>Address</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach var="order" items="${orders}">

                            <tr>

                                <!-- ORDER ID -->
                                <td>#${order.orderId}</td>

                                <!-- CUSTOMER -->
                                <td>${order.customerName}<br> <small>${order.customerEmail}</small>
                                </td>

                                <!-- PRODUCT -->
                                <td>${order.productName}</td>

                                <!-- IMAGE -->
                                <td><img src="${pageContext.request.contextPath}/${order.imageUrl}">
                                </td>

                                <!-- QTY -->
                                <td>${order.quantity}</td>

                                <!-- PRICE -->
                                <td>Rs ${order.price}</td>

                                <!-- TOTAL -->
                                <td>Rs ${order.price * order.quantity}</td>

                                <!-- STATUS UPDATE -->
                                <td>

                                    <form action="${pageContext.request.contextPath}/admin/update-order-status"
                                        method="post" class="status-form">

                                        <input type="hidden" name="orderId" value="${order.orderId}">

                                        <select name="status" class="status-select">
                                            <option value="PENDING" ${order.orderStatus=='PENDING' ? 'selected' : '' }>
                                                PENDING</option>
                                            <option value="APPROVED" ${order.orderStatus=='APPROVED' ? 'selected' : ''
                                                }>APPROVED</option>
                                            <option value="SHIPPED" ${order.orderStatus=='SHIPPED' ? 'selected' : '' }>
                                                SHIPPED</option>
                                            <option value="DELIVERED" ${order.orderStatus=='DELIVERED' ? 'selected' : ''
                                                }>DELIVERED</option>
                                        </select>

                                        <button type="submit" class="btn">Update</button>

                                    </form>

                                </td>

                                <!-- ADDRESS -->
                                <td>${order.shippingAddress}</td>

                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </div>

        </body>

        </html>