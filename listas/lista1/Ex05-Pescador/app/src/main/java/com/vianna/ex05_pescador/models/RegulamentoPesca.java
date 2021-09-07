package com.vianna.ex05_pescador.models;

public class RegulamentoPesca {

    public double calcularMulta(IPescado[] pescados) {
        double pesoExcedido = 0;
        for (IPescado p : pescados) {
            if (p.getPeso() > pesoMaximoPorPescado)
                pesoExcedido += p.getPeso() - pesoMaximoPorPescado;
        }
        return pesoExcedido * multaPorQuiloExcedente;
    }

    private double multaPorQuiloExcedente = 4;
    private double pesoMaximoPorPescado = 50;
}
