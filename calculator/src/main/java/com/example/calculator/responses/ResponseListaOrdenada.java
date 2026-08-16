package com.example.calculator.responses;

import java.util.List;

public class ResponseListaOrdenada {

    private List<Integer> listaOrdenada;

    public ResponseListaOrdenada(List<Integer> listaOrdenada) {
        this.listaOrdenada = listaOrdenada;
    }

    public List<Integer> getListaOrdenada() {
        return listaOrdenada;
    }
}
