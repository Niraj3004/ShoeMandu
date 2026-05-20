<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>

            <meta charset="UTF-8">

            <title>My Profile - ShoesMandu</title>

            <!-- PROFILE CSS -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">

            <!-- HEADER CSS -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">

            <!-- FONT AWESOME -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

        </head>

        <body>

            <!-- HEADER -->
            <jsp:include page="header.jsp" />

            <!-- PROFILE SECTION -->
            <div class="profile-wrapper">

                <!-- PROFILE CARD -->
                <div class="profile-card">

                    <!-- PROFILE TOP -->
                    <div class="profile-top">

                        <!-- USER IMAGE -->
                        <c:choose>

                            <c:when test="${not empty user.userImageURL}">

                                <img src="${pageContext.request.contextPath}/${user.userImageURL}"
                                    class="profile-photo">

                            </c:when>

                            <c:otherwise>

                                <img src="${pageContext.request.contextPath}/images/default-user.png"
                                    class="profile-photo">

                            </c:otherwise>

                        </c:choose>

                        <!-- USER NAME -->
                        <h2>${user.userFirstName}${user.userLastName}</h2>

                        <!-- USER EMAIL -->
                        <p>${user.userEmail}</p>

                    </div>

                    <!-- USER INFO -->
                    <div class="profile-info">

                        <p>

                            <i class="fa fa-phone"></i> ${user.userPhone}

                        </p>

                        <p>

                            <i class="fa fa-location-dot"></i> ${user.userAddress}

                        </p>

                    </div>

                    <hr>

                    <!-- UPDATE PROFILE FORM -->
                    <form action="${pageContext.request.contextPath}/UpdateProfile" method="post"
                        enctype="multipart/form-data">

                        <!-- FIRST NAME -->
                        <label> First Name </label> <input type="text" name="firstName" value="${user.userFirstName}"
                            required>

                        <!-- LAST NAME -->
                        <label> Last Name </label> <input type="text" name="lastName" value="${user.userLastName}"
                            required>

                        <!-- EMAIL -->
                        <label> Email </label> <input type="email" value="${user.userEmail}" readonly>

                        <!-- PHONE -->
                        <label> Phone </label> <input type="text" name="phone" value="${user.userPhone}" required>

                        <!-- ADDRESS -->
                        <label> Address </label>

                        <textarea name="address" required>${user.userAddress}</textarea>

                        <!-- CHANGE IMAGE -->
                        <label> Change Profile Image </label> <input type="file" name="image">

                        <!-- SAVE BUTTON -->
                        <button type="submit">

                            <i class="fa fa-save"></i> Save Changes

                        </button>

                    </form>

                    <!-- LOGOUT BUTTON -->
                    <a href="${pageContext.request.contextPath}/logout" class="logout-btn"> <i
                            class="fa fa-sign-out-alt"></i> Logout

                    </a>

                </div>

            </div>

            <jsp:include page="footer.jsp" />

        </body>

        </html>