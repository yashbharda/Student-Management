package com.StudentManagementSystem.Service;

import com.StudentManagementSystem.Entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student saveStudent(Student student);

    public Student getById(int id);

    public void deleteById(int id);

}
