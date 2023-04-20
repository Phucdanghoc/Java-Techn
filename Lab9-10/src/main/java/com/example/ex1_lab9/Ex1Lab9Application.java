package com.example.ex1_lab9;

import com.example.ex1_lab9.model.Product;
import com.example.ex1_lab9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex1Lab9Application implements CommandLineRunner {
    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Ex1Lab9Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productService.create(new Product(1,"Book",12.2,"img.png","book about economic"));
    }
}
