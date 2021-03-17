package com.example.EducationSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private Double scholarship;

    public Students() {

    }
    public Students(String name, String password, Double scholarship) {
        this.name = name;
        this.password = password;
        this.scholarship = scholarship;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }
}
