package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LambdasExercise03 {

    public interface ShoppingCartFactory {
        ShoppingCart newShoppingCart();
    }

    public ShoppingCartFactory getShoppingCartFactory() {
        return ShoppingCart::new; // Replace 'null' by your solution
    }

    public static class ShoppingCart {
        private final List<Product> products = new ArrayList<>();

        public void add(Product product) {
            this.products.add(product);
        }

        public BigDecimal getTotalAmount() {
            BigDecimal total = BigDecimal.ZERO;

            return products.stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

        }
    }
}
