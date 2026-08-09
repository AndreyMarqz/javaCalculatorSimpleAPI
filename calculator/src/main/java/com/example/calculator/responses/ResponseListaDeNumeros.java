package com.example.calculator.responses;

public class ResponseListaDeNumeros {

    private String maiorEMenorNumero;


    public ResponseListaDeNumeros(String maiorEMenorNumero) {
        this.maiorEMenorNumero = maiorEMenorNumero;
    }

    public String getMaiorEMenorNumero() {
        return maiorEMenorNumero;
    }
}
