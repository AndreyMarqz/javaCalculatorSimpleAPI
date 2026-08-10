package com.example.calculator;

import java.text.DecimalFormat;
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

        DecimalFormat formatter = new DecimalFormat("0");
        List<String> resultado = new ArrayList<>();
        int contador = 0;

        while(contador <= 10) {
            double tabuada = multiplicacao(num1, contador);
            String tabuadaFormatada = formatter.format(tabuada);
            String linha = num1 + " x " + contador + " = " + tabuadaFormatada;
            resultado.add(linha);
            contador += 1;
        }

        return resultado;
    }

    public double calcularAreaTriangulo(double baseTriangulo, double alturaTriangulo) {

        return multiplicacao(baseTriangulo, alturaTriangulo) / 2;
    }

    public String verificarParOuImpar(Integer parOuImpar) {

        if(parOuImpar % 2 == 0){
            return "O número " + parOuImpar + " é par";
        } return "O número " + parOuImpar + " é ímpar";
    }

    public double restoDivisao(double num1, double num2) {

        if(num1 > num2) {
            return num1 % num2;
        } return num2 % num1;
    }

    public double converterParaCelsius(double temperaturaFahrenheit) {

        return (temperaturaFahrenheit - 32) * 5 / 9;
    }

    public double converterParaFahrenheit(double temperaturaCelsius) {

        return (temperaturaCelsius * 1.8) + 32;
    }

    public Integer calcularFatorial(Integer num) {

        for(int i = num; i > 1; i--) {
            num = (int) multiplicacao(num, i - 1);
        }
        return num;
    }

    public List<Integer> fibonacci(Integer num) {

        List<Integer> sequenciaDeFibonacci = new ArrayList<>(List.of(0, 1));

        for(int i = 0, j = 1; ; i++, j++) {

            int ultimoNumero = sequenciaDeFibonacci.get(i);
            int penultimoNumero = sequenciaDeFibonacci.get(j);

            int proximoNumero = (int) soma(ultimoNumero, penultimoNumero);
            if(proximoNumero > num) {
                break;
            }

            sequenciaDeFibonacci.add(proximoNumero);
        }

        return sequenciaDeFibonacci;
    }

    public String verificarPrimo(Integer num) {

        if(num <= 1) {
            return "O número " + num + " não é primo";
        } else if(num == 2) {
            return "O número " + num + " é primo";
        }

        for(int i = 2; i < num; i++) {
            if(num % i == 0){
                return "O número " + num + " não é primo";
            }
        }
        return "O número " + num + " é primo";
    }

    public Integer contarCaracteres(String palavra) {

        List<Character> caracteres = new ArrayList<>();

        for(char caracter : palavra.toCharArray()) {
            caracteres.add(caracter);
        }

        return caracteres.size();
    }

    public String inverterString(String palavra) {

        StringBuilder palavraInvertida = new StringBuilder();

        for(int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida.append(palavra.charAt(i));
        }

        return palavraInvertida.toString();
    }

    public String maiorEMenor(List<Integer> numeros) {

        Integer maiorNumero = numeros.getFirst();
        Integer menorNumero = numeros.getFirst();

        for(int j = 1, i = 0; i < numeros.size() - 1; j++, i++) {
            if(numeros.get(i) < numeros.get(j) && numeros.get(j) > maiorNumero) {
                maiorNumero = numeros.get(j);
            }

            if(numeros.get(i) > numeros.get(j) && numeros.get(j) < menorNumero) {
                menorNumero = numeros.get(j);
            }
        }

        return "O maior número da lista é " + maiorNumero + " e o menor número da lista é " + menorNumero + ".";
    }
}