package com.vianna.ex05_pescador.models;

public class Peixe implements IPescado{
    public Peixe(double peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
    private double peso;
}
