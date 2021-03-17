package com.example.EducationSystem.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentScholarshipChangeEventHandler implements ApplicationListener<StudentScholarshipChangeEvent> {
    @Override
    @EventListener
    public void onApplicationEvent(StudentScholarshipChangeEvent event) {
        System.out.println("Student scholarship was changed");
    }
}
