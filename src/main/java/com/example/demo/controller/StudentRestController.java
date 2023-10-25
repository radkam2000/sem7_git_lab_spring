package com.example.demo.controller;

import com.example.demo.domain.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/students")
    public ResponseEntity<StudentEntity>
    createStudent(@RequestBody StudentEntity student) {
        HttpStatus status = HttpStatus.CREATED;
        StudentEntity saved = studentService.save(student);
        return new ResponseEntity<>(saved, status);
    }
    @GetMapping("/students")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }
}
