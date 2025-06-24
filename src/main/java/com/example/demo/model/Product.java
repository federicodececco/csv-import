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
    private Long id;

    private String name;

    private String barcode;

    private String brand;

    private String category;

    private Integer quantity;

    private Double weight;

    private Double price;

    // Costruttore completo
    public Product(String name, String barcode, String brand, String category,
            Integer quantity, Double weight, Double price) {
        this.name = name;
        this.barcode = barcode;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', barcode='%s', brand='%s', category='%s', " +
                "quantity=%d, weight=%.2f, price=%.2f}",
                id, name, barcode, brand, category, quantity, weight, price);
    }
}
