<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Product Detail</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/product-detail.css">

</head>

<body>

<jsp:include page="header.jsp"/>

<div class="detail-container">

	<div class="image-box">
		<img src="${pageContext.request.contextPath}/${product.imageUrl}">
	</div>

	<div class="info-box">

		<h1>${product.productName}</h1>

		<p><b>Brand:</b> ${product.brand}</p>
		<p><b>Category:</b> ${product.category}</p>

		<p class="price">Rs ${product.price}</p>

		<p class="stock">Stock: ${product.stock}</p>

		<p class="desc">${product.description}</p>

		<button class="btn">Add to Cart</button>

	</div>

</div>

<jsp:include page="footer.jsp"/>

</body>
</html>