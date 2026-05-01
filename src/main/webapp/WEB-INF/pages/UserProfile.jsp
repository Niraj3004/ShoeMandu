<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
        :root {
            --primary-color: #4a90e2;
            --text-dark: #333;
            --text-light: #777;
            --bg-color: #f4f7f6;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--bg-color);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .profile-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
            width: 350px;
            padding: 30px;
            text-align: center;
        }

        .profile-image {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            object-fit: cover;
            border: 4px solid var(--primary-color);
            margin-bottom: 15px;
        }

        h2 {
            margin: 10px 0 5px 0;
            color: var(--text-dark);
            font-size: 24px;
        }

        .username {
            color: var(--primary-color);
            font-weight: 600;
            margin-bottom: 20px;
        }

        .details-container {
            text-align: left;
            margin: 20px 0;
            border-top: 1px solid #eee;
            padding-top: 20px;
        }

        .detail-item {
            margin-bottom: 10px;
            font-size: 14px;
            color: var(--text-dark);
        }

        .detail-item strong {
            color: var(--text-light);
            width: 80px;
            display: inline-block;
        }

        .logout-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 25px;
            background-color: #e74c3c;
            color: white;
            text-decoration: none;
            border-radius: 25px;
            transition: background 0.3s ease;
        }

        .logout-btn:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

    <div class="profile-card">
        <img class="profile-image" 
             src="${pageContext.request.contextPath}/${student.image}" 
             alt="Profile Image" 
             onerror="this.style.display='none'">

        <h2>${student.firstName} ${student.lastName}</h2>
        <div class="username">@${student.userName}</div>

        <div class="details-container">
            <div class="detail-item"><strong>Username:</strong> ${student.userName}</div>
            <div class="detail-item"><strong>Email:</strong> ${student.email}</div>
            <div class="detail-item"><strong>Phone:</strong> ${student.number}</div>
            <div class="detail-item"><strong>Gender:</strong> ${student.gender}</div>
            <div class="detail-item"><strong>Program:</strong> ${student.program}</div>
            <div class="detail-item"><strong>DOB:</strong> ${student.dob}</div>
        </div>

        <a href="${pageContext.request.contextPath}/Logout" class="logout-btn">Logout</a>
    </div>

</body>
</html>