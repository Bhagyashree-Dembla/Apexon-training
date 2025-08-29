package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamsExercise06 {

    public String formatProductList(List<Product> products) {

        return products.stream()
                .map(Product::toString)               // Convert each product to its string representation
                .collect(Collectors.joining("\n"));
    }
}
