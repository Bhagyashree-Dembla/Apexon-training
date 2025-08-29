package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasExample07 {


    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();


        products.forEach(System.out::println);

        products.forEach(LambdasExample07::printProductDetails);

        List<String> productNames = products.stream()
                .map(Product::getName) // Instance method reference on Product
                .toList();

        System.out.println("Product names:");
        productNames.forEach(System.out::println);

        List<BigDecimal> prices = products.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        System.out.println("Product prices:");
        prices.forEach(System.out::println);

    }


    public static void printProductDetails(Product product) {
        System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice());
    }


}
