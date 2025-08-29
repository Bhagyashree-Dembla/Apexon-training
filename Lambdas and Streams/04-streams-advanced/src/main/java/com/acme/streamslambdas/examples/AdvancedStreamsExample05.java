package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        Map<Category, List<String>> productNamesByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));

        productNamesByCategory.forEach((category, names) -> {
            System.out.println(category);
            names.forEach(name -> System.out.println("- " + name));
        });

        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getPrice, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }
}
