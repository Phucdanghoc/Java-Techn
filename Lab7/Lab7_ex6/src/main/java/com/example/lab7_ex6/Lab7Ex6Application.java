package com.example.lab7_ex6;

import com.example.lab7_ex6.Model.Student;
import com.example.lab7_ex6.Repostory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Lab7Ex6Application implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab7Ex6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Student> studentList = studentRepository.findAll( Sort.by("age").descending().and(Sort.by("ielts")));
//        studentList.forEach(p-> System.out.println(p.toString()));

        Page<Student> allProducts = studentRepository.findAll(PageRequest.of(1,3));
        allProducts.forEach(p-> System.out.println(p.toString()));

    }
}
