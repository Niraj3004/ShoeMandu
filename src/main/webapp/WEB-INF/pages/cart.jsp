<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>My Cart</title>

</head>

<body>

<h1>My Cart</h1>

<c:forEach var="c" items="${cartItems}">

    <div>

        <img src="${pageContext.request.contextPath}/${c.product.imageUrl}"
             width="120">

        <h3>${c.product.productName}</h3>

        <p>Rs ${c.product.price}</p>

        <p>Qty: ${c.quantity}</p>

    </div>

</c:forEach>

</body>
</html>