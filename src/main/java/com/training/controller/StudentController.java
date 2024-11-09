package com.training.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.training.dao.DataAccessObject;
import com.training.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
	
    @RequestMapping("/reg")
    public ModelAndView f1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register.jsp");
        return mv;
    }
    
    @RequestMapping("/log")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.jsp");
        return mv;
    }
    
    @RequestMapping("/studentregistration")
    public ModelAndView registerStudent(HttpServletRequest req, HttpServletResponse res) {
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
        dao.insertStudent(s);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register.jsp");
        mv.addObject("result", "inserted..");
        return mv;
    }
    
    @RequestMapping("/show")
    public ModelAndView showStudents() {
        ModelAndView mv = new ModelAndView();
        DataAccessObject dao = new DataAccessObject();
        ArrayList<Student> all = dao.getStudents();
        mv.setViewName("display.jsp");
        mv.addObject("students", all);
        return mv;
    }
    
    @RequestMapping("/login2")
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("studentEmail");
        String password = req.getParameter("studentPassword");
        DataAccessObject dao = new DataAccessObject();
        Student student = dao.getStudentByEmailAndPassword(email, password);
        ModelAndView mv = new ModelAndView();
        if (student != null) {
            mv.setViewName("welcome.jsp");
            mv.addObject("student", student);
        } else {
            mv.setViewName("login.jsp");
            mv.addObject("errorMessage", "Invalid email or password. Please try again or register if you are a new user.");
        }
        return mv;
    }
}