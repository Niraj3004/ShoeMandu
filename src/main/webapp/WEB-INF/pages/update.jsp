<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Update Profile</title>

            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap"
                rel="stylesheet">

        </head>

        <body>

            <div class="form-box">
                <h2>Update Profile</h2>

                <form action="${pageContext.request.contextPath}/UpdateProfile" method="post"
                    enctype="multipart/form-data">

                    <!-- Hidden ID -->
                    <input type="hidden" name="userId" value="${user.userID}">
                    <input type="hidden" name="oldImage" value="${user.userImageURL}">

                    <!-- Image Preview -->
                    <div class="preview">
                        <img src="${pageContext.request.contextPath}/${user.userImageURL}" />
                    </div>

                    <!-- Upload -->
                    <label>Change Profile Image</label>
                    <input type="file" name="image">

                    <label>First Name</label>
                    <input type="text" name="firstName" value="${user.userFirstName}" required>

                    <label>Last Name</label>
                    <input type="text" name="lastName" value="${user.userLastName}" required>

                    <label>Phone</label>
                    <input type="text" name="phone" value="${user.userPhone}" required>

                    <label>Address</label>
                    <input type="text" name="address" value="${user.userAddress}" required>

                    <button type="submit">Update Profile</button>
                </form>

            </div>

        </body>

        </html>