package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;

public class LambdasExample02 {
    interface Filter {
        boolean filter(Product product);
    }

    static void printProducts(List<Product> products, Filter filter) {
        for (Product p : products) {
            if (filter.filter(p)) {
                System.out.println(p.getPrice());
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");
        Filter filter = product -> product.getPrice().compareTo(priceLimit) < 0;
        printProducts(products, filter);
    }
}
