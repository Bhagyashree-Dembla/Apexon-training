package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BasicStreamsExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();


        Optional<Product> expensiveProduct = products.stream()
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(500)) > 0)
                .findFirst();

        expensiveProduct.ifPresent(product ->
                System.out.println("First expensive product: " + product.getName()));

        boolean hasElectronics = products.stream()
                .anyMatch(product -> product.getCategory() == Category.ELECTRONICS);


        boolean allExpensive = products.stream()
                .allMatch(product -> product.getPrice().compareTo(BigDecimal.valueOf(10)) > 0);

        boolean noBooks = products.stream()
                .noneMatch(product -> product.getCategory() == Category.BOOKS);

    }
}
