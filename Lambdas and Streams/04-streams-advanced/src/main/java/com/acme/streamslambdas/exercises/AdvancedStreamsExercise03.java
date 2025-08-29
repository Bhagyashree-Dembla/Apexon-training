package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExercise03 {

    public enum PriceRange {
        CHEAP, MEDIUM, EXPENSIVE
    }

    public Map<PriceRange, List<Product>> groupProductsByPriceRange(List<Product> products, BigDecimal cheapLimit, BigDecimal expensiveLimit) {

        return products.stream()
                .collect(Collectors.groupingBy(product -> {
                    BigDecimal price = product.getPrice();
                    if (price.compareTo(cheapLimit) < 0) {
                        return PriceRange.CHEAP;
                    } else if (price.compareTo(expensiveLimit) > 0) {
                        return PriceRange.EXPENSIVE;
                    } else {
                        return PriceRange.MEDIUM;
                    }
                }));
    }
}
