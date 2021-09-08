package com.vianna.ex05_pescador.models;

public class RegulamentoPesca {

    public static double calcularMulta(IPescado[] pescados) {
        double pesoExcedido = 0;
        for (IPescado p : pescados) {
            if (p.getPeso() > pesoMaximoPorPescado)
                pesoExcedido += p.getPeso() - pesoMaximoPorPescado;
        }
        return pesoExcedido * multaPorQuiloExcedente;
    }

    public static double getMultaPorQuiloExcedente() {
        return multaPorQuiloExcedente;
    }

    public static double getPesoMaximoPorPescado() {
        return pesoMaximoPorPescado;
    }

    private static double multaPorQuiloExcedente = 4;
    private static double pesoMaximoPorPescado = 50;
}
