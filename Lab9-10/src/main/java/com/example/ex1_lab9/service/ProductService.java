package com.example.ex1_lab9.service;

import com.example.ex1_lab9.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product get(Long id);

    void delete(Long id);

    Product update(Product product);

    Product create(Product product);

}
