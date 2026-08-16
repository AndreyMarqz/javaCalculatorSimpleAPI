package com.example.calculator;

import com.example.calculator.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

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

        if(request.getTabuadaNum() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo");
        }

        List<String> resultado = service.imprimirTabuada(request.getTabuadaNum());

        return ResponseEntity.ok(new ResponseImprimirTabuada(resultado));
    }

    @PostMapping("/calcularAreaTriangulo")
    public ResponseEntity<?> calcularAreaTriangulo(@RequestBody Request request) {

        if(request.getAlturaTriangulo() < 0 || request.getBaseTriangulo() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo");
        }

        double areaTriangulo = service.calcularAreaTriangulo(request.getBaseTriangulo(), request.getAlturaTriangulo());

        return ResponseEntity.ok(new ResponseAreaTriangulo(areaTriangulo));
    }

    @PostMapping("/parOuImpar")
    public ResponseEntity<?> parOuImpar(@RequestBody Request request) {

        if(request.getParOuImpar() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        String parOuImpar = service.verificarParOuImpar(request.getParOuImpar());

        return ResponseEntity.ok(new ResponseParOuImpar(parOuImpar));
    }

    @PostMapping("/restoDivisao")
    public ResponseEntity<?> restoDivisao(@RequestBody Request request) {

        if(request.getNum1() <= 0 || request.getNum2() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        double restoDivisao = service.restoDivisao(request.getNum1(), request.getNum2());

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

    @PostMapping("/calcularFatorial")
    public ResponseEntity<?> calcularFatorial(@RequestBody Request request) {

        if(request.getFatorial() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        Integer fatorial = service.calcularFatorial(request.getFatorial());

        return ResponseEntity.ok(new ResponseFatorial(fatorial));
    }

    @PostMapping("/fibonacci")
    public ResponseEntity<?> fibonacci(@RequestBody Request request) {

        if(request.getFibonacci() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        List<Integer> fibonacci = service.fibonacci(request.getFibonacci());

        return ResponseEntity.ok(new ResponseFibonacci(fibonacci));
    }

    @PostMapping("/verificarPrimo")
    public ResponseEntity<?> verificarPrimo(@RequestBody Request request) {

        if(request.getNumeroPrimo() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        String numeroPrimo = service.verificarPrimo(request.getNumeroPrimo());

        return ResponseEntity.ok(new ResponseNumeroPrimo(numeroPrimo));
    }

    @PostMapping("/contarCaracteres")
    public ResponseEntity<?> contarCaracteres(@RequestBody Request request) {

        Integer qtdCaracteres = service.contarCaracteres(request.getPalavra());

        return ResponseEntity.ok(new ResponseCaracteres(qtdCaracteres));
    }

    @PostMapping("/inverterString")
    public ResponseEntity<?> inverterString(@RequestBody Request request) {

        String palavraInvertida = service.inverterString(request.getPalavra());

        return ResponseEntity.ok(new ResponsePalavraInvertida(palavraInvertida));
    }

    @PostMapping("/maiorEMenor")
    public ResponseEntity<?> maiorEMenor(@RequestBody Request request) {

        String maiorEMenorNumero = service.maiorEMenor(request.getListaDeNumeros());

        return ResponseEntity.ok(new ResponseListaDeNumeros(maiorEMenorNumero));
    }

    @PostMapping("/calculaIdade")
    public ResponseEntity<?> calculaIdade(@RequestBody Request request) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate.parse(request.getDataDeNascimento(), formatter);

            String idade = service.calculaIdade(request.getDataDeNascimento());

            return ResponseEntity.ok(new ResponseDataDeNascimento(idade));

        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Formato de data inválido. Use o formato dd/mm/aaaa.");
        }
    }

    @PostMapping("/somaDigitos")
    public ResponseEntity<?> somaDigitos(@RequestBody Request request) {

        if(request.getSomaDigitosNum() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um número positivo maior que 0");
        }

        Integer resultado = service.somaDigitos(request.getSomaDigitosNum());

        return ResponseEntity.ok(new ResponseSomaDigitos(resultado));
    }

    @PostMapping("/calculoIMC")
    public ResponseEntity<?> calculoIMC(@RequestBody Request request) {

        if(Objects.isNull(request.getPeso()) || Objects.isNull(request.getAltura())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira altura e peso");
        }

        if (request.getPeso() <= 0 || request.getAltura() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira valores positivos e maiores que 0 para peso e altura");
        }

        double resultado = service.calculaIMC(request.getPeso(), request.getAltura());

        Double resultadoFormatado = BigDecimal.valueOf(resultado).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return ResponseEntity.ok(new ResponseCalculoIMC(resultadoFormatado));
    }

    @PostMapping("/ordenaLista")
    public ResponseEntity<?> ordenarLista(@RequestBody Request request) {

        if(request.getListaDeNumeros() == null || request.getListaDeNumeros().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A lista de números não pode estar vazia ou nula");
        }

        List<Integer> resultado = service.ordenarLista(request.getListaDeNumeros());

        return ResponseEntity.ok(new ResponseListaOrdenada(resultado));
    }
}
