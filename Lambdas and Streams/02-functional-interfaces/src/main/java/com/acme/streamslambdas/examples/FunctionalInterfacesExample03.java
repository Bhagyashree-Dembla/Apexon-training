package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample03 {

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

        String name = "Spaghetti";


        Predicate<Product> hasName = p -> p.getName().equalsIgnoreCase(name);

        Function<Product, BigDecimal> productToPrice = Product::getPrice;

        Function<BigDecimal, String> priceToMessage = price -> "The price is: " + price;

        Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);

        Optional<Product> productOpt = findProduct(products, hasName);

        productOpt.ifPresent(product -> {
            String message = productToMessage.apply(product);
            System.out.println("Product found: " + product.getName());
            System.out.println(message);
        });

        Function<Product, String> productToMessageUsingCompose = priceToMessage.compose(productToPrice);

        productOpt.ifPresent(product -> {
            String message = productToMessageUsingCompose.apply(product);
            System.out.println("Using compose: " + message);
        });

    }
}
