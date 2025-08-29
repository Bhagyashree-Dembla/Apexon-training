package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfacesExercise01 {

    public List<Product> filterProducts(List<Product> products, Predicate<Product> f) {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (f.test(product)) {
                result.add(product);
            }
        }
        return result;
    }
}
