package com.example.calculator.responses;

import java.util.List;

public class ResponseFibonacci {

    private List<Integer> fibonacci;

    public ResponseFibonacci(List<Integer> fibonacci) {
        this.fibonacci = fibonacci;
    }

    public List<Integer> getFibonacci() {
        return fibonacci;
    }
}
