<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Registration</title>
</head>
<body>
    <h2>Register New Admin</h2>
    <form action="adminRegister" method="post">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <input type="submit" value="Register">
    </form>
    <p style="color: green;">
        <%=request.getAttribute("message") %>
    </p>
</body>
</html>