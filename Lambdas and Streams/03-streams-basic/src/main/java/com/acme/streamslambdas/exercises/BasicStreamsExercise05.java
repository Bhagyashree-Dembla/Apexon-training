package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;

public class BasicStreamsExercise05 {

    public boolean areAllOfficeProductsCheap(List<Product> products, BigDecimal priceLimit) {
        return products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE) // Filter OFFICE products
                .allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
    }
}
