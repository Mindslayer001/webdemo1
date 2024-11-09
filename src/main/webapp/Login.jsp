<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #333;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background: #5cb85c;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #4cae4c;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h2>Login</h2>
    <form action="login2" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="studentEmail" required aria-required="true" aria-label="Email">
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="studentPassword" required aria-required="true" aria-label="Password">
        
        <input type="submit" value="Login">
    </form>
    
    <p class="error">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
</body>
</html>
