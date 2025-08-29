package com.acme.streamslambdas.exercises;

import com.acme
        .streamslambdas.Product;

import java.util.List;

public class LambdasExercise01 {

    public void sortProductsByName(List<Product> products) {
        // TODO: Use a lambda expression to sort the list of products by name
        // products.sort(<lambda expression>);
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }
}
