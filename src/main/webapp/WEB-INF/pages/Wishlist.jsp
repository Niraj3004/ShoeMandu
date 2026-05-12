<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>Wishlist</title>

</head>

<body>

<h1>My Wishlist</h1>

<c:forEach var="w" items="${wishlist}">

    <div>

        <img src="${pageContext.request.contextPath}/${w.product.imageUrl}"
             width="120">

        <h3>${w.product.productName}</h3>

        <p>Rs ${w.product.price}</p>

    </div>

</c:forEach>

</body>
</html>