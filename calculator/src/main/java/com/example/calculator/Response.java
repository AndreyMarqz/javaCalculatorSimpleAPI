package com.example.calculator;

public class Response {

    private double resultado;
    private String mensagem;

    public Response(double resultado, String mensagem) {
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
