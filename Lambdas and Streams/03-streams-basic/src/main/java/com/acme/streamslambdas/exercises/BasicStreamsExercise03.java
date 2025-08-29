package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BasicStreamsExercise03 {

    public Optional<Product> findProductCheaperThan(List<Product> products, BigDecimal priceLimit) {

        return products.stream()
                .filter(product -> product.getPrice().compareTo(priceLimit) < 0) // Filter products cheaper than priceLimit
                .findAny();
    }
}
