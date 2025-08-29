package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionalInterfacesExample02 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            Category category = product.getCategory();

            if (!productsByCategory.containsKey(category)) {
                productsByCategory.put(category, new ArrayList<>());
            }

            productsByCategory.get(category).add(product);
        }

        System.out.println("Grouped using traditional approach:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(product -> System.out.println("  - " + product.getName()));
        });


        Map<Category, List<Product>> productsByCategoryLambda = new HashMap<>();

        for (Product product : products) {
            productsByCategoryLambda
                    .computeIfAbsent(product.getCategory(), c -> new ArrayList<>())
                    .add(product);
        }


        System.out.println("\nGrouped using computeIfAbsent:");


        productsByCategoryLambda.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(product -> System.out.println("  - " + product.getName()));
        });


    }
}
