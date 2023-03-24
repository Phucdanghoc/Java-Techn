package com.example.demo;

import com.example.demo.Config.AppConfig;
import com.example.demo.Model.Product;
import com.example.demo.Config.GreetingConfig;
import com.example.demo.Utils.GreetingService;
import com.example.demo.Utils.TextEditor;
import com.example.demo.Config.TextEditorConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

        System.out.println("Ex1");
        Product product1 = (Product) context.getBean("product1");
        Product product2 = (Product) context.getBean("product2");
        Product product3 = (Product) context.getBean("product3");

        System.out.println(product1.toString());
        System.out.println(product2.toString());
        System.out.println(product3.toString());


        System.out.println("Ex2");
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        product1 = (Product) context.getBean("product1");
        product2 = (Product) context.getBean("product2");
        product3 = (Product) context.getBean("product3");

        System.out.println(product1.toString());
        System.out.println(product2.toString());
        System.out.println(product3.toString());

//
        System.out.println("Ex3-4");
        context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        TextEditor textEditor = context.getBean(TextEditor.class);
        textEditor.input("input a text");
        textEditor.save("test.txt");
//
        System.out.println("Ex5");

        context = new AnnotationConfigApplicationContext(GreetingConfig.class);
        GreetingService greetingService = (GreetingService) context.getBean("greetingService");
        System.out.println(greetingService.greet());
    }

}
