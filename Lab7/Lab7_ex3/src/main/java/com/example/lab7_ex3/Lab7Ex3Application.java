package com.example.lab7_ex3;

import com.example.lab7_ex3.Model.Student;
import com.example.lab7_ex3.Respository.StudentRepository;
import com.example.lab7_ex3.Service.StudentImplement;
import com.example.lab7_ex3.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Lab7Ex3Application  implements CommandLineRunner {
    @Autowired
    private  StudentRepository studentService;
    public static void main(String[] args) {
        SpringApplication.run(Lab7Ex3Application.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(1,"John Doe", "john.doe@example.com", 25, 6.5);
        Student student2 = new Student(2,"Jane Smith","jane.smith@example.com", 21,  7.0);
        Student student3 = new Student(3,"Bob Johnson","bob.johnson@example.com", 30,  6.0);

//        studentService.save(student1);
//        studentService.save(student3);

        studentService.findAll().forEach(p-> System.out.println(p.getId()));
//        System.out.println("\n ");
//        System.out.println("\n ");
//
//        student1.setAge(30);
//        studentService.add(student1);
//        System.out.println("Set John 's age = 30");
//        System.out.println("After Update ");
//        studentService.getAll().forEach(p-> System.out.println(p.toString()));
//
//        System.out.println("\n ");
//        System.out.println("\n ");
//        System.out.println("Delete John 's age = 30");
//        studentService.delete(student1.getId());
//        System.out.println("After Update ");
//        studentService.getAll().forEach(p-> System.out.println(p.toString()))

    }
}
