package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;

public class LambdasExample03 {

    interface ProductFilter {
        boolean filter(Product product);
    }

    static void printProducts(List<Product> products, ProductFilter filter) {


        for (Product product : products) {
            if (filter.filter(product)) {
                System.out.println(product);
            }
        }

    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        printProducts(products, product -> product.getPrice().compareTo(priceLimit) < 0);

    }
}
