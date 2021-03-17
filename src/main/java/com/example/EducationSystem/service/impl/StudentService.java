package com.example.EducationSystem.service.impl;

import com.example.EducationSystem.entity.Teachers;
import com.example.EducationSystem.repository.StudentRepository;
import com.example.EducationSystem.entity.Students;
import com.example.EducationSystem.event.StudentScholarshipChangeEvent;
import com.example.EducationSystem.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class StudentService implements StudentServiceInterface, ApplicationEventPublisherAware {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    Scanner scan = new Scanner(System.in);
    @Override
    public void create(Students students) {
        studentRepository.save(students);
    }

    @Override
    public void createStudent() {
        System.out.println("Enter the name");
        String name = scan.next();
        System.out.println("Enter the password");
        String password = scan.next();
        System.out.println("Enter the scholarship");
        double scholarship = scan.nextDouble();
        if (studentRepository.existsByNameAndPassword(name, password)) {
            System.out.println("Student with this name and password is already exists");
        }
        else {
            Students students = new Students(name, password, scholarship);
            System.out.println("Teacher is created.");
            studentRepository.save(students);
        }
    }

    @Override
    public boolean exist(String name, String password) {
        return studentRepository.existsByNameAndPassword(name, password);
    }

    @Override
    public void scholarshipChange() {
        System.out.println("Enter the student ID");
        long id = scan.nextLong();
        System.out.println("Enter the new scholarship ");
        int scholarship = scan.nextInt();
        if (studentRepository.existsById(id)) {
            Optional<Students> students = studentRepository.findById(id);
            Students student = students.get();
            student.setScholarship((double) scholarship);
            System.out.println("The student with ID: " + student.getId() + " scholarship was changed to " + scholarship);
            studentRepository.deleteById(student.getId());
            studentRepository.save(student);
        }
        else {
            System.out.println("Student with this ID does not exist");
        }
        this.eventPublisher.publishEvent(new StudentScholarshipChangeEvent(this, this));
    }

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
