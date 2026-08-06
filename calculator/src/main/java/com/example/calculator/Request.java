package com.example.calculator;

public class Request {

    private Double num1;
    private Double num2;
    private String operador;
    private Integer tabuadaNum;
    private Integer baseTriangulo;
    private Integer alturaTriangulo;
    private Integer parOuImpar;
    private Double temperaturaFahrenheit;
    private Double temperaturaCelsius;

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

    public Integer getBaseTriangulo() {
        return baseTriangulo;
    }

    public void setBaseTriangulo(Integer baseTriangulo) {
        this.baseTriangulo = baseTriangulo;
    }

    public Integer getAlturaTriangulo() {
        return alturaTriangulo;
    }

    public void setAlturaTriangulo(Integer alturaTriangulo) {
        this.alturaTriangulo = alturaTriangulo;
    }

    public Integer getParOuImpar() {
        return parOuImpar;
    }

    public void setParOuImpar(Integer parOuImpar) {
        this.parOuImpar = parOuImpar;
    }

    public double getTemperaturaFahrenheit() {
        return temperaturaFahrenheit;
    }

    public void setTemperaturaFahrenheit(double temperaturaFahrenheit) {
        this.temperaturaFahrenheit = temperaturaFahrenheit;
    }

    public double getTemperaturaCelsius() {
        return temperaturaCelsius;
    }

    public void setTemperaturaCelsius(double temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }
}
