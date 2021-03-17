package com.example.EducationSystem.repository;

import com.example.EducationSystem.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Long> {
    List<Teachers> findAll();
    Teachers findByNameAndPassword(String name, String password);
    boolean existsByNameAndPassword(String name, String password);
}
