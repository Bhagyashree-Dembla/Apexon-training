package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.util.ArrayList;
import java.util.List;

public class LambdasExercise02 {

    public interface ProductFilter {
        boolean accept(Product product);
    }

    public List<Product> findProductsByCategory(List<Product> products, Category category) {
        ProductFilter filter = product -> product.getCategory() == category;
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (filter.accept(product)) {
                result.add(product);
            }

        }
        return result;
    }
}
