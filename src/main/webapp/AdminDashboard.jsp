<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.training.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Admin Dashboard</h2>
    <a href="adminRegisterPage">Register New Admin</a><br><br>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Mobile</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");
                if (students != null) {
                    for (Student student : students) {
            %>
            <tr>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getPw() %></td>
                <td><%= student.getMobile() %></td>
                <td>
                    <form action="adminEditStudent" method="post" style="display:inline;">
                        <input type="hidden" name="studentEmail" value="<%= student.getEmail() %>">
                         <input type="submit" value="Edit">
                    </form>
                    <form action="adminDeleteStudent" method="post" style="display:inline;">
                        <input type="hidden" name="studentEmail" value="<%= student.getEmail() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No students found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <p style="color: green;">
        <%= request.getAttribute("message") %>
    </p>
</body>
</html>
                        
                        