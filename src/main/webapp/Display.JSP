<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.training.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SPRING MVC</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Welcome to Result Page</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <!-- <th>Password</th> --> <!-- Consider removing this -->
                <th>Mobile</th>
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
                <!-- <td><%= student.getPw() %></td> --> <!-- Consider removing this -->
                <td><%= student.getMobile() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No students found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
