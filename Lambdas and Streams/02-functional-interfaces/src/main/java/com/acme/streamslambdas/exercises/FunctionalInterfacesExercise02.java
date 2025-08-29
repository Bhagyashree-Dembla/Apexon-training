package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class FunctionalInterfacesExercise02 {

    public static class SearchCriteria {
        private Category category;
        private String namePattern;
        private BigDecimal minimumPrice;
        private BigDecimal maximumPrice;

        public SearchCriteria(Category category, String namePattern, BigDecimal minimumPrice, BigDecimal maximumPrice) {
            this.category = category;
            this.namePattern = namePattern;
            this.minimumPrice = minimumPrice;
            this.maximumPrice = maximumPrice;
        }

        public Category getCategory() {
            return category;
        }

        public String getNamePattern() {
            return namePattern;
        }

        public BigDecimal getMinimumPrice() {
            return minimumPrice;
        }

        public BigDecimal getMaximumPrice() {
            return maximumPrice;
        }


    }

    public Predicate<Product> createSearchPredicate(SearchCriteria criteria) {
        Predicate<Product> predicate = product -> true;

        if (criteria.getCategory() != null) {
            Predicate<Product> categoryIs = product -> product.getCategory().equals(criteria.getCategory());
            predicate = predicate.and(categoryIs);
        }

        if (criteria.getNamePattern() != null) {
            Predicate<Product> nameMatches = product -> product.getName().matches(criteria.getNamePattern());
            predicate = predicate.and(nameMatches);
        }

        if (criteria.getMinimumPrice() != null) {
            Predicate<Product> minimumPriceIs = product -> product.getPrice().compareTo(criteria.getMinimumPrice()) >= 0;
            predicate = predicate.and(minimumPriceIs);
        }

        if (criteria.getMaximumPrice() != null) {
            Predicate<Product> maximumPriceIs = product -> product.getPrice().compareTo(criteria.getMaximumPrice()) <= 0;
            predicate = predicate.and(maximumPriceIs);
        }
        return predicate;
    }
}
