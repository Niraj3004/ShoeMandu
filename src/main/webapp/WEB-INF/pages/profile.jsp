<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Profile - ShoesMandu</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>

<body>

<jsp:include page="header.jsp" />

<div class="profile-wrapper">

    <div class="profile-card">

        <!-- PROFILE IMAGE + INFO -->
        <div class="profile-top">

            <c:choose>
                <c:when test="${not empty user.userImageURL}">
                    <img src="${pageContext.request.contextPath}/${user.userImageURL}" class="profile-photo">
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/default-user.png" class="profile-photo">
                </c:otherwise>
            </c:choose>

            <h2>${user.userFirstName} ${user.userLastName}</h2>
            <p>${user.userEmail}</p>

        </div>

        <!-- USER INFO -->
        <div class="profile-info">
            <p><i class="fa fa-phone"></i> ${user.userPhone}</p>
            <p><i class="fa fa-location-dot"></i> ${user.userAddress}</p>
        </div>

        <hr>

        <!-- EDIT FORM -->
        <form action="${pageContext.request.contextPath}/UpdateProfile"
              method="post"
              enctype="multipart/form-data">

            <label>First Name</label>
            <input type="text" name="firstName" value="${user.userFirstName}" required>

            <label>Last Name</label>
            <input type="text" name="lastName" value="${user.userLastName}" required>

            <label>Email</label>
            <input type="email" value="${user.userEmail}" readonly>

            <label>Phone</label>
            <input type="text" name="phone" value="${user.userPhone}" required>

            <label>Address</label>
            <textarea name="address" required>${user.userAddress}</textarea>

            <label>Change Image</label>
            <input type="file" name="image">

            <button type="submit">
                <i class="fa fa-save"></i> Save Changes
            </button>

        </form>

        <!-- LOGOUT -->
        <a href="${pageContext.request.contextPath}/logout" class="logout-btn">
            <i class="fa fa-sign-out-alt"></i> Logout
        </a>

    </div>

</div>

</body>
</html>