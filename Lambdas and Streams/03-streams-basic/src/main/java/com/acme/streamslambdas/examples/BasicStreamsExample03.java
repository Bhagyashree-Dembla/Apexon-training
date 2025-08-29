
package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BasicStreamsExample03 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Stream<Product> filtered = products.stream()
                .filter(product -> product.getCategory() == Category.FOOD);

        filtered.forEach(product -> System.out.println("Filtered (FOOD): " + product.getName()));


        Stream<String> mapped = products.stream()
                .map(Product::getName);
        mapped.forEach(name -> System.out.println("Mapped name: " + name));
        Pattern spaces = Pattern.compile("\\s+");

        Stream<String> flatMapped = products.stream()
                .map(Product::getName)
                .flatMap(name -> spaces.splitAsStream(name));
        flatMapped.forEach(word -> System.out.println("FlatMapped word: " + word));

    }
}
