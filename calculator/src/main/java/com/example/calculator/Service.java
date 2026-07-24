package com.example.calculator;

@org.springframework.stereotype.Service
public class Service {

    private double soma(double num1, double num2) {
        return num1 + num2;
    }

    private double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    private double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    private double divisao(double num1, double num2) {
        if(num2 == 0) {
            throw new ArithmeticException("Não é possível realizar divisão por zero");
        }
        return num1 / num2;
    }

    public double calcular(double num1, double num2, String operador) {

        switch (operador) {
            case "+":
                return soma(num1, num2);
            case "-":
                return subtracao(num1, num2);
            case "*":
                return multiplicacao(num1, num2);
            case "/":
                return divisao(num1, num2);
            default:
                throw new IllegalArgumentException("Operador inválido");
        }
    }
}