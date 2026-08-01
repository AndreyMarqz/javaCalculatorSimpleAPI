package com.example.calculator;

import com.example.calculator.responses.ResponseAreaTriangulo;
import com.example.calculator.responses.ResponseCalcular;
import com.example.calculator.responses.ResponseImprimirTabuada;
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
}
