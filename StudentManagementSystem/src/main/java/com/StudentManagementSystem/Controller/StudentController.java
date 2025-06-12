package com.StudentManagementSystem.Controller;

import com.StudentManagementSystem.Entity.Student;
import com.StudentManagementSystem.Service.StudentImpl;
import com.StudentManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/home")
    public String home(){
        return "home";// View HTML file -> home.html
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students",service.getAllStudents());
        return "students";
    }

    @GetMapping("students/new")
    public String createStudentForm(Model model){
        Student student=new Student();// to hold the student object
        model.addAttribute("students",student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model){
        model.addAttribute("student",service.getById(id));
        return "edit_student";
    }

    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/students";
    }
}
