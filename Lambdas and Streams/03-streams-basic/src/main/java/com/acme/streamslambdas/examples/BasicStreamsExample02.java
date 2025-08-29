package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicStreamsExample02 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Stream<Product> stream1 = products.stream();

        String[] array = new String[]{"one", "two", "three"};
        Stream<String> stream2 = Arrays.stream(array);

        Stream<String> stream3 = Stream.of("one", "two", "three");

        Stream<String> stream4 = Stream.ofNullable("four");

        Stream<?> stream5 = Stream.empty();

        IntStream dice = new Random().ints(1, 7);


        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        BasicStreamsExample02.class.getResourceAsStream("/sample.txt")))){
            Stream<String> lineStream = reader.lines();
            lineStream.forEach(line -> System.out.println("Line: " + line));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}
