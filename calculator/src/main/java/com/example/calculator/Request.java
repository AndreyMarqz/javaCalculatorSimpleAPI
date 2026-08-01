package com.example.calculator;

public class Request {

    private double num1;
    private double num2;
    private String operador;
    private Integer tabuadaNum;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Integer getTabuadaNum() {
        return tabuadaNum;
    }

    public void setTabuadaNum(Integer tabuadaNum) {
        this.tabuadaNum = tabuadaNum;
    }
}
