package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping
    public List<Student> readAll() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
