package com.example.calculator.responses;

public class ResponseTemperaturaFahrenheit {

    private double fahrenheit;

    public ResponseTemperaturaFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }
}
