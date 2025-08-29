package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExercise02 {


    public Map<Category, Long> countProductsPerCategory(List<Product> products) {

        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,   // Classifier: group by category
                        Collectors.counting()   // Downstream collector: count the number of products in each group
                ));
    }
}
