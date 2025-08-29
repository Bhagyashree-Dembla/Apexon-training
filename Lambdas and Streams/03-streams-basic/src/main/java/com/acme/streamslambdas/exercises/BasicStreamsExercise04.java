package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BasicStreamsExercise04 {

    public Optional<Product> findCheapestCleaning(List<Product> products) {

        return products.stream()
                .filter(product -> product.getCategory() == Category.CLEANING) // Filter by CLEANING category
                .min(Comparator.comparing(Product::getPrice));
    }
}
