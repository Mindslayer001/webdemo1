<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2>Student Registration</h2>
    <form action="studentregistration" method="post">
        <input type="text" name="studentName" placeholder="Student Name" required><br>
        <input type="email" name="studentEmail" placeholder="Student Email" required><br>
        <input type="password" name="studentPassword" placeholder="Student Password" required><br>
        <input type="text" name="studentMobile" placeholder="Student Mobile" required pattern="\d{10}" title="Please enter a valid 10-digit mobile number"><br>
        <input type="submit" value="Register Here">
    </form>
    <div class="error-message">
        <%= request.getAttribute("result") != null ? request.getAttribute("result") : "" %>
    </div>
</body>
</html>
