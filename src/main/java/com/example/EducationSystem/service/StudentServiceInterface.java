package com.example.EducationSystem.service;

import com.example.EducationSystem.entity.Students;

import java.util.List;

public interface StudentServiceInterface {
    void create(Students students);
    void scholarshipChange();
    void createStudent();
    boolean exist(String name, String password);
    List<Students> findAll();
}
