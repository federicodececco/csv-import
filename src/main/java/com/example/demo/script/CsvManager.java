package com.example.demo.script;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Product;

public class CsvManager {

    private static String CSV_PATH = "products.csv";

    public static List<Product> getAllProducts() throws IOException {

        String line;
        List<Product> products = new ArrayList<Product>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] productString = line.split(",");
                Product product = new Product();
                product.setName(productString[0]);
                product.setBarcode(productString[1]);
                product.setBrand(productString[2]);
                product.setCategory(productString[3]);
                product.setQuantity(Integer.valueOf(productString[4]));
                product.setWeight(Double.valueOf(productString[5]));
                Double stringPrice = (productString.length > 6 && !productString[6].isBlank())
                        ? Double.valueOf(productString[6])
                        : 0.0;
                product.setPrice(stringPrice);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            System.out.println("mistakes were made:" + e.getMessage());
        }

        return products;

    }
}
