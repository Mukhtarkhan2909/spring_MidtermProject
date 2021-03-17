package com.example.EducationSystem.service.impl;

import com.example.EducationSystem.entity.Students;
import com.example.EducationSystem.repository.ResourceRepository;
import com.example.EducationSystem.entity.Resources;
import com.example.EducationSystem.service.ResourceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ResourceService implements ResourceServiceInterface {

    @Autowired
    private ResourceRepository resourceRepository;
    Scanner scan = new Scanner(System.in);

    @Override
    public void create(Resources resources) {
        resourceRepository.save(resources);
    }

    @Override
    public void createResource() {
        System.out.println("Enter the title");
        String title = scan.next();
        System.out.println("Enter the content");
        String content = scan.next();
        Resources resources = new Resources(title, content);
        System.out.println("Resource is created.");
        resourceRepository.save(resources);
    }

    @Override
    public List<Resources> findAll() {
        return resourceRepository.findAll();
    }

}
