package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.stream.Stream;

public class BasicStreamsExample01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();


        Stream<Product> productStream = products.stream()
                .filter(product -> product.getPrice().doubleValue() > 100.0) // Intermediate operation
                .map(product -> {
                    System.out.println("Mapping: " + product.getName()); // Demonstrates laziness
                    return product;
                });


        long count = productStream.count();

        System.out.println("Number of products with price > 100: " + count);

    }
}
