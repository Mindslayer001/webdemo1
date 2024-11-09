package com.training.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.training.model.Admin;
import com.training.model.Student;
public class DataAccessObject {

    private static final Logger LOGGER = Logger.getLogger(DataAccessObject.class.getName());

    public void insertStudent(Student s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lendi", "root", "2318");
                 PreparedStatement ps = con.prepareStatement("INSERT INTO student(name, email, pw, mobile) VALUES (?, ?, ?, ?)")) {

                ps.setString(1, s.getName());
                ps.setString(2, s.getEmail());
                ps.setString(3, s.getPw());
                ps.setString(4, s.getMobile());

                ps.executeUpdate();
                LOGGER.info("Row is inserted: " + s);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting student: " + s, e);
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> all = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String pw = rs.getString("pw");
                    String mobile = rs.getString("mobile");

                    Student s1 = new Student();
                    s1.setName(name);
                    s1.setEmail(email);
                    s1.setPw(pw);
                    s1.setMobile(mobile);

                    all.add(s1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching students", e);
        }
        return all;
    }
    
    public Student getStudentByEmailAndPassword(String email, String password) {
        Student student = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE email = ? AND pw = ?")) {

                ps.setString(1, email);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        student = new Student();
                        student.setName(rs.getString("name"));
                        student.setEmail(rs.getString("email"));
                        student.setPw(rs.getString("pw"));
                        student.setMobile(rs.getString("mobile"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching student by email and password", e);
        }
        return student;
    }

    public Admin getAdminByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?")) {

                ps.setString(1, username);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        admin = new Admin();
                        admin.setUsername(rs.getString("username"));
                        admin.setPassword(rs.getString("password"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching admin by username and password", e);
        }
        return admin;
    }

    public Student getStudentByEmail(String email) {
        Student student = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE email = ?")) {

                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    student = new Student();
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setPw(rs.getString("pw"));
                    student.setMobile(rs.getString("mobile"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching student by email: " + email, e);
        }
        return student;
    }

    public void updateStudent(Student s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 PreparedStatement ps = con.prepareStatement("UPDATE student SET name = ?, email = ?, pw = ?, mobile = ? WHERE email = ?")) {

                ps.setString(1, s.getName());
                ps.setString(2, s.getEmail());
                ps.setString(3, s.getPw());
                ps.setString(4, s.getMobile());
                ps.setString(5, s.getEmail());

                ps.executeUpdate();
                LOGGER.info("Row is updated: " + s);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating student: " + s, e);
        }
    }

    public void deleteStudent(String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE email = ?")) {

                ps.setString(1, email);

                ps.executeUpdate();
                LOGGER.info("Row is deleted: " + email);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting student with email: " + email, e);
        }
    }

    public void insertAdmin(Admin admin) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "PremNaidu1");
                 PreparedStatement ps = con.prepareStatement("INSERT INTO admin(username, password) VALUES (?, ?)")) {

                ps.setString(1, admin.getUsername());
                ps.setString(2, admin.getPassword());

                ps.executeUpdate();
                LOGGER.info("Admin is inserted: " + admin);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting admin: " + admin, e);
        }
    }
}