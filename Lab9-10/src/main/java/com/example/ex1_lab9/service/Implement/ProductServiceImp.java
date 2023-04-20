package com.example.ex1_lab9.service.Implement;

import com.example.ex1_lab9.model.Product;
import com.example.ex1_lab9.repository.ProductRepository;
import com.example.ex1_lab9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void  delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
