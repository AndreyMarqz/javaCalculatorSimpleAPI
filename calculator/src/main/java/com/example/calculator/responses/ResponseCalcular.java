package com.example.calculator.responses;

public class ResponseCalcular {

    final private double resultado;
    final private String mensagem;

    public ResponseCalcular(double resultado, String mensagem) {
        this.resultado = resultado;
        this.mensagem = mensagem;
    }

    public double getResultado() {
        return resultado;
    }

    public String getMensagem() {
        return mensagem;
    }
}
