<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to external CSS for styling -->
</head>
<body>
    <div class="container">
        <h2>Admin Login</h2>
        <form action="adminAuthenticate" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required placeholder="Enter your username"><br/><br/>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required placeholder="Enter your password"><br/><br/>
            
            <input type="submit" value="Login">
        </form>
        <p style="color: red;">
            <%=request.getAttribute("errorMessage") %>
        </p>
    </div>
</body>
</html>
