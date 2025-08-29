package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamsExercise01 {

    public List<Product> findUtensilsSortedByName(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory() == Category.UTENSILS)
                .sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).collect(Collectors.toList());
    }
}
