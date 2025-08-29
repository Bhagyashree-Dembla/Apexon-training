package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AdvancedStreamsExercise01 {

    public Set<String> getSortedProductNames(List<Product> products) {

        return products.stream()
                .map(Product::getName)
                .collect(
                        TreeSet::new,           // Supplier: creates a new TreeSet
                        Set::add,               // Accumulator: adds an element to the set
                        Set::addAll             // Combiner: merges two sets
                );
    }
}
