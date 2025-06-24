package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.script.CsvManager;
import com.example.demo.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/csv")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/upload")
    public ResponseEntity<List<Product>> upload() {

        try {
            List<Product> products = CsvManager.getAllProducts();

            for (Product product : products) {
                productService.create(product);
            }
            return new ResponseEntity<List<Product>>(products, HttpStatus.CREATED);
        } catch (IOException e) {
            System.err.println("second mistake" + e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        if (productService.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteById(id);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> show(@PathVariable Long id) {
        Optional<Product> productTry = productService.findById(id);
        if (productTry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(productTry.get(), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Product> index() {
        return productService.findAll();
    }

}
