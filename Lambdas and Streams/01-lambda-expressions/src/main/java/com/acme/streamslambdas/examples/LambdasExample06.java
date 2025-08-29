package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LambdasExample06 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        try (FileWriter writer = new FileWriter("products.txt")) {
            products.forEach(product -> {
                try {
                    writer.write(product.toString() + System.lineSeparator());
                } catch (IOException e) {
                    // Handle the checked exception inside the lambda
                    System.err.println("Error writing product: " + product.getName());
                    e.printStackTrace();
                }
            });
            System.out.println("Products written to products.txt");
        } catch (IOException e) {
            System.err.println("Failed to open file for writing.");
            e.printStackTrace();
        }
    }
}