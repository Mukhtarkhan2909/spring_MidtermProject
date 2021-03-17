package com.example.EducationSystem.service;

import com.example.EducationSystem.entity.Teachers;

import java.util.List;

public interface TeacherServiceInterface {
    void create(Teachers teachers);
    void createTeacher();
    boolean exist(String name, String password);
    List<Teachers> findAll();
}
