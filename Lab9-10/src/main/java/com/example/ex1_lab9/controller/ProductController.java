package com.example.ex1_lab9.controller;

import com.example.ex1_lab9.APIs.CustomResponse;
import com.example.ex1_lab9.model.Product;
import com.example.ex1_lab9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    ResponseEntity<CustomResponse> all() {
        List<Product> products = productService.getAll();
        CustomResponse<Product> response = new CustomResponse(true, products);
        return ResponseEntity.ok(response);
    }
    @PostMapping("")
    ResponseEntity<CustomResponse> getNewProduct(@RequestBody Product newProduct) {
        productService.create(newProduct);
        CustomResponse<Product> response = new CustomResponse(true,"Thêm thành công");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    Product one(@PathVariable Long id) {
        return productService.get(id);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<CustomResponse> delete(@PathVariable Long id){
        productService.delete(id);
        CustomResponse<Product> response = new CustomResponse(true,"Xóa thành công");
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    ResponseEntity<CustomResponse> replaceEmployee(@RequestBody Product newProduct, @PathVariable Long id) {
        Product product = productService.get(id);
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setDescription(newProduct.getDescription());
        product.setIllustration(newProduct.getIllustration());
        productService.create(product);
        CustomResponse<Product> response = new CustomResponse(true,"Sửa thành công");
        return ResponseEntity.ok(response);
    }
}
