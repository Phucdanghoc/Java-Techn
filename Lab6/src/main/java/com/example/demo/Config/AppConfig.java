package com.example.demo.Config;

import com.example.demo.Model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    public Product product1(){
        return  new Product(1,"Product 1",10.21,"this is product 1");
    }
    @Bean
    public Product product2(){
        return  new Product(2,"Product 2",10.22,"this is product 2");
    }
    @Bean
    @Scope("singleton")
    public Product product3(){
        return  new Product(3,"Product 3",10.121,"this is product 3");
    }
}
