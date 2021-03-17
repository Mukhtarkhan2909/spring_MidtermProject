package com.example.EducationSystem.event;

import com.example.EducationSystem.service.impl.StudentService;
import org.springframework.context.ApplicationEvent;

public class StudentScholarshipChangeEvent extends ApplicationEvent {
    StudentService service;
    public StudentScholarshipChangeEvent(Object source, StudentService service) {
        super(source);
        this.service = service;
    }
}
