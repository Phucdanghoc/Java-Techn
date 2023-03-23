package com.example.lab7_ex2;

import com.example.lab7_ex2.Model.Student;
import com.example.lab7_ex2.Respository.StudentRepository;
import com.example.lab7_ex2.Service.StudentImplement;
import com.example.lab7_ex2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab7Ex2Application implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(Lab7Ex2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("List ");

        Student student1 = new Student(1L,"John Doe", "john.doe@example.com", 25, 6.5);
        Student student2 = new Student(2L,"Jane Smith","jane.smith@example.com", 21,  7.0);
        Student student3 = new Student(3L,"Bob Johnson","bob.johnson@example.com", 30,  6.0);
        studentService.add(student1);
        studentService.add(student2);
        studentService.add(student3);

        studentService.getAll().forEach(p-> System.out.println(p.toString()));
        System.out.println("\n ");
        System.out.println("\n ");

        student1.setAge(30);
        studentService.add(student1);
        System.out.println("Set John 's age = 30");
        System.out.println("After Update ");
        studentService.getAll().forEach(p-> System.out.println(p.toString()));

        System.out.println("\n ");
        System.out.println("\n ");
        System.out.println("Delete John 's age = 30");
        studentService.delete(student1.getId());
        System.out.println("After Update ");
        studentService.getAll().forEach(p-> System.out.println(p.toString()));

    }
}
