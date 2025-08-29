package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        List<Product> foodProducts = products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .collect(Collectors.toList());

        System.out.println("Food products:");
        foodProducts.forEach(product -> System.out.println(product.getName()));

        String productNames = products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        System.out.println("All product names: " + productNames);

    }
}
