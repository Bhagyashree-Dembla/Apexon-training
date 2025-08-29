package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");


        List<Product> cheapProducts = products.stream()
                .filter(product -> product.getPrice().compareTo(priceLimit) < 0)
                .collect(Collectors.toList());

        System.out.println("Cheap products:");
        cheapProducts.forEach(System.out::println);

    }
}
