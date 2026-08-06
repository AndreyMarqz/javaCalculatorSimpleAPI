package com.example.calculator.responses;

public class ResponseTemperaturaCelsius {

    private double celsius;

    public ResponseTemperaturaCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }
}
