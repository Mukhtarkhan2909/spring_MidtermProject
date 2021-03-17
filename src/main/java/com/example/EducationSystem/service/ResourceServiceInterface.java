package com.example.EducationSystem.service;

import com.example.EducationSystem.entity.Resources;
import java.util.List;

public interface ResourceServiceInterface {
    void create(Resources medicines);
    void createResource();
    List<Resources> findAll();
}
