package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product;

    private String name;

    private String barcode;

    private String brand;

    private String category;

    private Integer weight;

    private Double price;

    public Product(String name, String barcode, String brand, String category, Integer weight, Double price) {
        this.name = name;
        this.barcode = barcode;
        this.brand = brand;
        this.category = category;
        this.weight = weight;
        this.price = price;
    }

}
