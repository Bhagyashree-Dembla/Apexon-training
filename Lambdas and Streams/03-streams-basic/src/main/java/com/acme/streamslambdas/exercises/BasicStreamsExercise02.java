package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamsExercise02 {


    public List<String> getProductNamesForCategory(List<Product> products, Category category) {


        return products.stream()
                .filter(product -> product.getCategory() == category)
                .map(Product::getName).
                collect(Collectors.toList());


    }

    public List<String> categoriesToProductNames(Map<Category, List<Product>> productsByCategory, Stream<Category> categories) {

        return categories
                .flatMap(category -> productsByCategory.getOrDefault(category, List.of()).stream()) // Get products for each category
                .map(Product::getName)                                                              // Map to product name
                .collect(Collectors.toList());

    }
}
