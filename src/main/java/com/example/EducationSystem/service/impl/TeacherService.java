package com.example.EducationSystem.service.impl;

import com.example.EducationSystem.repository.TeacherRepository;
import com.example.EducationSystem.entity.Teachers;
import com.example.EducationSystem.service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class TeacherService implements TeacherServiceInterface {

    Scanner scan = new Scanner(System.in);
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void create(Teachers teachers) {
        teacherRepository.save(teachers);
    }

    @Override
    public void createTeacher() {
        System.out.println("Enter the name: ");
        String name = scan.next();
        System.out.println("Enter the password: ");
        String password = scan.next();

        if (teacherRepository.existsByNameAndPassword(name, password)) {
            System.out.println("Teacher with this name and password is already exists");
        }
        else {
            Teachers teacher = new Teachers(name, password);
            System.out.println("Teacher is created.");
            teacherRepository.save(teacher);
        }
    }

    @Override
    public boolean exist(String name, String password) {
        return teacherRepository.existsByNameAndPassword(name, password);
    }

    @Override
    public List<Teachers> findAll() {
        return teacherRepository.findAll();
    }

}
