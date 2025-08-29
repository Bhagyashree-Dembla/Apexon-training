package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FunctionalInterfacesExample04 {

    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {
        for (Product product : products) {
            if (predicate.test(product)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("2.00");

        Predicate<Product> isFood = p -> p.getCategory() == Category.FOOD;
        Predicate<Product> isCheap = p -> p.getPrice().compareTo(priceLimit) < 0;

        Predicate<Product> isCheapFood = isFood.and(isCheap);

        Optional<Product> productOpt = findProduct(products, isCheapFood);

        productOpt.ifPresentOrElse(
                product -> {
                    System.out.println("Found cheap food product:");
                    System.out.println("Name: " + product.getName());
                    System.out.println("Price: " + product.getPrice());
                },
                () -> System.out.println("No cheap food product found.")
        );

    }
}
