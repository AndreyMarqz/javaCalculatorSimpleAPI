package com.example.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    public double soma(double num1, double num2) {
        return num1 + num2;
    }

    public double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    public double divisao(double num1, double num2) {
        if(num2 == 0) {
            throw new ArithmeticException("Não é possível realizar divisão por zero");
        }
        return num1 / num2;
    }

    public double calcular(double num1, double num2, String operador) {

        return switch (operador) {
            case "+" -> soma(num1, num2);
            case "-" -> subtracao(num1, num2);
            case "*" -> multiplicacao(num1, num2);
            case "/" -> divisao(num1, num2);
            default -> throw new IllegalArgumentException("Operador inválido");
        };
    }

    public List<String> imprimirTabuada(Integer num1) {

        List<String> resultado = new ArrayList<>();
        int contador = 0;

        while(contador <= 10) {
            int tabuada = num1 * contador;
            String linha = num1 + " x " + contador + " = " + tabuada;
            resultado.add(linha);
            contador += 1;
        }

        return resultado;
    }

    public double calcularAreaTriangulo(double baseTriangulo, double alturaTriangulo) {

        return multiplicacao(baseTriangulo, alturaTriangulo) / 2;
    }
}