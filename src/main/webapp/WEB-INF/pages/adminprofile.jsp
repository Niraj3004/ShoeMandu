<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Profile - ShoesMandu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminprofile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="admin-profile-page">

    <div class="admin-profile-card">

        <div class="profile-side">
            <c:choose>
                <c:when test="${not empty admin.userImageURL}">
                    <img src="${pageContext.request.contextPath}/${admin.userImageURL}" class="profile-photo">
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/default-user.png" class="profile-photo">
                </c:otherwise>
            </c:choose>

            <h2>${admin.userFirstName} ${admin.userLastName}</h2>
            <p>${admin.userEmail}</p>

            <span class="admin-badge">
                <i class="fa fa-user-shield"></i> Admin
            </span>

            <div class="profile-info">
                <span><i class="fa fa-phone"></i> ${admin.userPhone}</span>
                <span><i class="fa fa-location-dot"></i> ${admin.userAddress}</span>
            </div>

            <a href="${pageContext.request.contextPath}/dashboard" class="back-btn">
                <i class="fa fa-arrow-left"></i> Back to Dashboard
            </a>
        </div>

        <div class="profile-main">
            <h1>Admin Profile</h1>
            <p class="subtitle">View and update your admin information</p>

            <c:if test="${not empty success}">
                <div class="success-message">${success}</div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>

            <form action="${pageContext.request.contextPath}/update-admin-profile"
                  method="post"
                  enctype="multipart/form-data">

                <div class="form-group">
                    <label>Change Profile Image</label>
                    <input type="file" name="image" accept="image/*">
                </div>

                <div class="form-grid">
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" name="firstName" value="${admin.userFirstName}" required>
                    </div>

                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" name="lastName" value="${admin.userLastName}" required>
                    </div>
                </div>

                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" value="${admin.userEmail}" readonly>
                    <small>This is your admin login email and cannot be changed.</small>
                </div>

                <div class="form-group">
                    <label>Phone Number</label>
                    <input type="text" name="phone" value="${admin.userPhone}" required>
                </div>

                <div class="form-group">
                    <label>Address</label>
                    <textarea name="address" required>${admin.userAddress}</textarea>
                </div>

                <button type="submit" class="save-btn">
                    <i class="fa fa-save"></i> Save Changes
                </button>

            </form>
        </div>

    </div>

</div>

</body>
</html>