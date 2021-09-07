package com.vianna.ex03_calculosalario.models;

public class Empregado {

    public Empregado(Emprego emprego, int numeroDependentes) {
        this.emprego = emprego;
        this.numeroDependentes = numeroDependentes;
    }

    public double getSalarioLiquido() {
        return emprego.getSalarioLiquido(this);
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    private Emprego emprego;
    private int numeroDependentes;
}
