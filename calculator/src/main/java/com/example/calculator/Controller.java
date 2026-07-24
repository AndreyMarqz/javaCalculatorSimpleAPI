package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody Request request) {
        try {
            double resultado = service.calcular(request.getNum1(), request.getNum2(), request.getOperador());

            return ResponseEntity.ok(new Response(resultado, "Cálculo realizado"));

        } catch (IllegalArgumentException | ArithmeticException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
