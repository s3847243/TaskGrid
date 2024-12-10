package com.jdbcproject.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcproject.demo.model.Student;
import com.jdbcproject.demo.repository.StudentRepo;

@Service
public class StudentService {
    private StudentRepo repo;
    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }
    public void addStudent(Student s) {
        // TODO Auto-generated method stub
       repo.save(s);
    }
    public List<Student> getStudents() {
        // TODO Auto-generated method stub
       return repo.findAll();
    }
    
}
