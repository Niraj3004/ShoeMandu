<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Edit Product</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/addproduct.css">

</head>

<body>

<div class="container">

    <div class="form-box">

        <h1>Edit Product</h1>

        <form action="${pageContext.request.contextPath}/admin/edit-product"
              method="post"
              enctype="multipart/form-data">

            <input type="hidden"
                   name="productId"
                   value="${product.productId}">

            <div class="input-group">

                <label>Product Name</label>

                <input type="text"
                       name="productName"
                       value="${product.productName}"
                       required>

            </div>

            <div class="input-group">

                <label>Brand</label>

                <input type="text"
                       name="brand"
                       value="${product.brand}"
                       required>

            </div>

            <div class="input-group">

                <label>Category</label>

                <input type="text"
                       name="category"
                       value="${product.category}"
                       required>

            </div>

            <div class="input-group">

                <label>Description</label>

                <textarea name="description"
                          rows="5">${product.description}</textarea>

            </div>

            <div class="double-input">

                <div class="input-group">

                    <label>Price</label>

                    <input type="number"
                           step="0.01"
                           name="price"
                           value="${product.price}"
                           required>

                </div>

                <div class="input-group">

                    <label>Stock</label>

                    <input type="number"
                           name="stock"
                           value="${product.stock}"
                           required>

                </div>

            </div>

            <div class="input-group">

                <label>Current Image</label>

                <img src="${pageContext.request.contextPath}/${product.imageUrl}"
                     width="120">

            </div>

            <div class="input-group">

                <label>New Image</label>

                <input type="file"
                       name="image"
                       accept="image/*">

            </div>

            <button type="submit"
                    class="submit-btn">

                Update Product

            </button>

        </form>

    </div>

</div>

</body>
</html>