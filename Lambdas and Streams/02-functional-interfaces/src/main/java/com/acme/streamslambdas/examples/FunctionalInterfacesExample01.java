package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FunctionalInterfacesExample01 {

    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {

        return products.stream().filter(predicate).findFirst();

    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        String name = "Spaghetti";

        Predicate<Product> nameMatches = product -> product.getName().equalsIgnoreCase(name);

        Optional<Product> result = findProduct(products, nameMatches);

        result.map(Product::getPrice).ifPresentOrElse(price -> System.out.println("Price of " + name + ": " + price), () -> System.out.println(name + " not found."));

    }


}
