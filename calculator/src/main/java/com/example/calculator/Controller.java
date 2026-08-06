package com.example.calculator;

import com.example.calculator.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculadora")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody Request request) {
        try {
            double resultado = service.calcular(request.getNum1(), request.getNum2(), request.getOperador());

            return ResponseEntity.ok(new ResponseCalcular(resultado, "Cálculo realizado"));

        } catch (IllegalArgumentException | ArithmeticException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/imprimirTabuada")
    public ResponseEntity<?> imprimirTabuada(@RequestBody Request request) {
        List<String> resultado = service.imprimirTabuada(request.getTabuadaNum());

        if(request.getTabuadaNum() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo");
        }

        return ResponseEntity.ok(new ResponseImprimirTabuada(resultado));
    }

    @PostMapping("/calcularAreaTriangulo")
    public ResponseEntity<?> calcularAreaTriangulo(@RequestBody Request request) {
        double areaTriangulo = service.calcularAreaTriangulo(request.getBaseTriangulo(), request.getAlturaTriangulo());

        if(areaTriangulo < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo");
        }

        return ResponseEntity.ok(new ResponseAreaTriangulo(areaTriangulo));
    }

    @PostMapping("/parOuImpar")
    public ResponseEntity<?> parOuImpar(@RequestBody Request request) {

        String parOuImpar = service.verificarParOuImpar(request.getParOuImpar());

        if(request.getParOuImpar() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        return ResponseEntity.ok(new ResponseParOuImpar(parOuImpar));
    }

    @PostMapping("/restoDivisao")
    public ResponseEntity<?> restoDivisao(@RequestBody Request request) {

        double restoDivisao = service.restoDivisao(request.getNum1(), request.getNum2());

        if(request.getNum1() <= 0 || request.getNum2() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        return ResponseEntity.ok(new ResponseRestoDivisao(restoDivisao));
    }

    @PostMapping("/converterParaCelsius")
    public ResponseEntity<?> converterParaCelsius(@RequestBody Request request) {

        double resultado = service.converterParaCelsius(request.getTemperaturaFahrenheit());

        return ResponseEntity.ok(new ResponseTemperaturaCelsius(resultado));
    }

    @PostMapping("/converterParaFahrenheit")
    public ResponseEntity<?> converterParaFahrenheit(@RequestBody Request request) {

        double resultado = service.converterParaFahrenheit(request.getTemperaturaCelsius());

        return ResponseEntity.ok(new ResponseTemperaturaFahrenheit(resultado));
    }
}
