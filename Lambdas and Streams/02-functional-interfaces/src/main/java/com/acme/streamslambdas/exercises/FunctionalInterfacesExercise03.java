package com.acme.streamslambdas.exercises;

import java.util.function.DoubleBinaryOperator;

public class FunctionalInterfacesExercise03 {

    public enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b);

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public DoubleBinaryOperator getOperator() {
            return operator;
        }
    }
    public double calculate(double a, double b, ArithmeticOperation operation) {
        return operation.getOperator().applyAsDouble(a, b);

    }
}
