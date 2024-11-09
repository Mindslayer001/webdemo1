<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.training.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student</h2>
    <%
        Student student = (Student) request.getAttribute("student");
    %>
    <form action="adminUpdateStudent" method="post">
        <input type="hidden" name="studentEmail" value="<%= student.getEmail() %>" required><br>
        <input type="text" name="studentName" placeholder="Student Name" value="<%= student.getName() %>" required><br>
        <input type="password" name="studentPassword" placeholder="Student Password" value="<%= student.getPw() %>" required><br>
        <input type="text" name="studentMobile" placeholder="Student Mobile" value="<%= student.getMobile() %>" required><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>