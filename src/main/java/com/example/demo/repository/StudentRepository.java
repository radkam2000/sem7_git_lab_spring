package com.example.demo.repository;

import com.example.demo.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Repository
@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    public StudentEntity findByName(String name);
    public List<StudentEntity> findAll();
    public StudentEntity findByBirthdayAfter(Date date);
    public StudentEntity findByBirthdayBeforeAndName(Date
                                                             date, String name);
}