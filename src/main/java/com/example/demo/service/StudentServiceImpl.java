package com.example.demo.service;

import com.example.demo.domain.StudentEntity;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.PersistenceException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //konstruktor potrzebny do testów jednostowkowych
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();

    }
    @Override
    public StudentEntity getStudentByName(String name) {
        return studentRepository.findByName(name);
    }
    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public boolean exists(String name) {
        if (studentRepository.findByName(name)!=null) {
            return true;
        }
        return false;
    }
    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }
}