package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.training.dao.DataAccessObject;
import com.training.model.Admin;
import com.training.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@Controller
public class AdminController {

    @RequestMapping("/adminLogin")
    public ModelAndView adminLoginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminLogin.jsp");
        return mv;
    }

    @RequestMapping("/adminAuthenticate")
    public ModelAndView adminAuthenticate(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        DataAccessObject dao = new DataAccessObject();
        Admin admin = dao.getAdminByUsernameAndPassword(username, password);
        ModelAndView mv = new ModelAndView();
        if (admin != null) {
            mv.setViewName("adminDashboard.jsp");
        } else {
            mv.setViewName("adminLogin.jsp");
            mv.addObject("errorMessage", "Invalid username or password.");
        }
        return mv;
    }


    @RequestMapping(value = "/adminEditStudent", method = RequestMethod.POST)
    public ModelAndView adminEditStudent(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("studentEmail");
        DataAccessObject dao = new DataAccessObject();
        Student student = dao.getStudentByEmail(email); 
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminEditStudent.jsp");
        mv.addObject("student", student);
        return mv;
    }

    @RequestMapping(value = "/adminUpdateStudent", method = RequestMethod.POST)
    public ModelAndView adminUpdateStudent(HttpServletRequest req, HttpServletResponse res) {
        String name = req.getParameter("studentName");
        String email = req.getParameter("studentEmail");
        String pw = req.getParameter("studentPassword");
        String mobile = req.getParameter("studentMobile");
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setPw(pw);
        s.setMobile(mobile);
        DataAccessObject dao = new DataAccessObject();
        dao.updateStudent(s);
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminDashboard.jsp");
        mv.addObject("message", "Student updated successfully.");
        return mv;
    }

    @RequestMapping(value = "/adminDeleteStudent", method = RequestMethod.POST)
    public ModelAndView adminDeleteStudent(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("studentEmail");
        DataAccessObject dao = new DataAccessObject();
        dao.deleteStudent(email);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminDashboard.jsp");
        mv.addObject("message", "Student deleted successfully.");
        return mv;
    }

    @RequestMapping("/adminRegisterPage")
    public ModelAndView adminRegisterPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminRegister.jsp");
        return mv;
    }

    @RequestMapping(value = "/adminRegister", method = RequestMethod.POST)
    public ModelAndView adminRegister(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        DataAccessObject dao = new DataAccessObject();
        dao.insertAdmin(admin);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminLogin.jsp");
        mv.addObject("message", "Admin registered successfully.");
        return mv;
    }
}