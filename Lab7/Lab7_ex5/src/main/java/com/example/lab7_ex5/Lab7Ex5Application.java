package com.example.lab7_ex5;

import com.example.lab7_ex5.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab7Ex5Application implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(Lab7Ex5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.findByName("Jane Smith").forEach(p-> System.out.println(p.toString()));
        studentRepository.findByAgeGreaterThanEqual(18).forEach(p-> System.out.println(p.toString()));
        studentRepository.findByEmailContaining("@gmail.com").forEach(p-> System.out.println(p.toString()));

    }
}
