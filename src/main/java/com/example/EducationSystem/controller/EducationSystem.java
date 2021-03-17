package com.example.EducationSystem.controller;

import com.example.EducationSystem.entity.Resources;
import com.example.EducationSystem.entity.Students;
import com.example.EducationSystem.entity.Teachers;
import com.example.EducationSystem.service.ResourceServiceInterface;
import com.example.EducationSystem.service.StudentServiceInterface;
import com.example.EducationSystem.service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Controller
public class EducationSystem {
    @Autowired
    private TeacherServiceInterface teacherService;
    @Autowired
    private StudentServiceInterface studentService;
    @Autowired
    private ResourceServiceInterface resourceService;
    Scanner scan = new Scanner(System.in);
    int menu;
    @PostConstruct
    void showMenu() {
        System.out.println("\n================Menu=====================");
        System.out.println("1. Login as a admin");
        System.out.println("2. Login as a teacher");
        System.out.println("3. Login as a student");
        System.out.println("4. Exit");
        System.out.println("===========================================\n");
        menu = scan.nextInt();
        while (menu != 3) {
            switch (menu) {
                case 1: {
                    showAdminMenu();
                    break;
                }
                case 2: {
                    showTeacherMenu();
                    break;
                }
                case 3: {
                    showStudentMenu();
                    break;
                }
                case 4: {
                    System.out.println("Good Bye!");
                    break;
                }
                default:
                {
                    System.out.println("Wrong input.");
                    break;
                }
            }
        }
    }
    void showAdminMenu(){
        System.out.println("\n==============Admin====================");
        System.out.println("Enter the admin login");
        String login = scan.next();
        System.out.println("Enter the admin password");
        String password = scan.next();
        if (!login.equals("admin") || !password.equals("admin")) {
            System.out.println("Admin login or password is wrong");
            showMenu();
        }
        System.out.println("1. Add teacher");
        System.out.println("2. Add student");
        System.out.println("3. List of teacher");
        System.out.println("4. List of students");
        System.out.println("5. Change students scholarship");
        System.out.println("6. Back");
        System.out.println("===========================================\n");
        int choice = scan.nextInt();
        switch (choice) {
            case 1: {
                teacherService.createTeacher();
                break;
            }
            case 2: {
                studentService.createStudent();
                break;
            }
            case 3: {
                if (teacherService.findAll().size() == 0) {
                    System.out.println("There is no teacher");
                }
                else {
                    System.out.println("List of teachers");
                    for (Teachers teacher: teacherService.findAll()) {
                        System.out.println(teacher.getId() + ": Name - " + teacher.getName() +
                                ", Password - " + teacher.getPassword());
                    }
                }
                break;
            }
            case 4: {
                if (studentService.findAll().size() == 0) {
                    System.out.println("There is no student");
                }
                else {
                    System.out.println("List of students");
                    for (Students student: studentService.findAll()) {
                        System.out.println(student.getId() + ": Name - " + student.getName() +
                                ", Password - " + student.getPassword() +
                                ", Scholarship - " + student.getScholarship());
                    }
                }
                break;
            }
            case 5: {
                studentService.scholarshipChange();
                break;
            }
            case 6: {
                this.showMenu();
                break;
            }
            default:
            {
                System.out.println("Wrong input.");
            }
        }
    }
    void showTeacherMenu() {
        System.out.println("\n================Teacher===================");
        System.out.println("Enter the name");
        String login = scan.next();
        System.out.println("Enter the password");
        String password = scan.next();
        if (!teacherService.exist(login, password)) {
            System.out.println("Teacher login or password is wrong");
            showMenu();
        }
        System.out.println("1. Add resource");
        System.out.println("2. List of resources");
        System.out.println("3. Back");
        System.out.println("===========================================\n");
        int choice = scan.nextInt();
        switch (choice) {
            case 1: {
                resourceService.createResource();
                break;
            }
            case 2: {
                if (resourceService.findAll().size() == 0) {
                    System.out.println("There is no resource.");
                }
                else {
                    for(Resources resource: resourceService.findAll()) {
                        System.out.println(resource.getId() + ":" +
                                "\n\tTitle " + resource.getTitle() +
                                "\n\tContent " + resource.getContent());
                    }
                }
                break;
            }
            case 3: {
                this.showMenu();
                break;
            }
            default:
            {
                System.out.println("Wrong input.");
            }
        }
    }
    void showStudentMenu() {
        System.out.println("\n================Student===================");
        System.out.println("Enter the name");
        String login = scan.next();
        System.out.println("Enter the password");
        String password = scan.next();
        if (!studentService.exist(login, password)) {
            System.out.println("Student login or password is wrong");
            showMenu();
        }
        System.out.println("1. List of resources");
        System.out.println("2. Back");
        System.out.println("===========================================\n");
        int choice = scan.nextInt();
        switch (choice) {
            case 1: {
                if (resourceService.findAll().size() == 0) {
                    System.out.println("There is no resource.");
                }
                else {
                    for(Resources resource: resourceService.findAll()) {
                        System.out.println(resource.getId() + ":" +
                                "\n\tTitle " + resource.getTitle() +
                                "\n\tContent " + resource.getContent());
                    }
                }
                break;
            }
            case 2: {
                this.showMenu();
                break;
            }
            default:
            {
                System.out.println("Wrong input.");
            }
        }
    }
}
