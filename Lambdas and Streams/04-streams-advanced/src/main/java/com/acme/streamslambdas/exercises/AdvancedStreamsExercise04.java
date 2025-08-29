package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExercise04 {

    public Map<Boolean, List<String>> getFoodAndNonFoodProductNames(List<Product> products) {

        return products.stream()
                .collect(Collectors.partitioningBy(
                        p -> p.getCategory().equals(Category.FOOD),                     // Predicate: true for food, false for non-food
                        Collectors.mapping(Product::getName,  // Downstream collector: map to product names
                                Collectors.toList())
                ));
    }
}
