package com.example.studentmanagement;

import com.example.studentmanagement.Student;
import com.example.studentmanagement.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        existing.setAge(updated.getAge());
        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }
} 