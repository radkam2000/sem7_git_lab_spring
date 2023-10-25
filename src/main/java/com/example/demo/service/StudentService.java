package com.example.demo.service;

import com.example.demo.domain.StudentEntity;

import java.util.List;
public interface StudentService {
    public StudentEntity getStudentById(Long id);
    public StudentEntity getStudentByName(String name);
    public List<StudentEntity> getAllStudents();
    public boolean exists(String email);
    public StudentEntity save(StudentEntity student);
}