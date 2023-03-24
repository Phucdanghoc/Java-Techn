package com.example.lab7_ex4;

import com.example.lab7_ex4.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab7Ex4Application implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(Lab7Ex4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.findByAgeGreaterThanEqual(24).forEach(p-> System.out.println(p.toString()));

        System.out.println(studentRepository.countByIelts(7));

        studentRepository.findByNameContainingIgnoreCase("doe").forEach(p-> System.out.println(p.toString()));
    }
}
