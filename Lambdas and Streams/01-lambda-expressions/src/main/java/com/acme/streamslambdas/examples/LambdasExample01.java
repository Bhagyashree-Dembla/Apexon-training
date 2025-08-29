package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.Comparator;
import java.util.List;

public class LambdasExample01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
