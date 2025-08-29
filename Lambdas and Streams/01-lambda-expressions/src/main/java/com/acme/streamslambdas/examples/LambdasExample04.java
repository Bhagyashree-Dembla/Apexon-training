package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;

public class LambdasExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        long numberOfCheapProducts = products.stream().filter(product -> product.getPrice().compareTo(priceLimit) < 0).count();
        System.out.println("There are " + numberOfCheapProducts + " cheap products");

    }
}
