package com.vianna.ex03_calculosalario.models;

public class Emprego {

    public Emprego(double cargaHoraria, double salarioHora) {
        horasTrabalhadas = cargaHoraria;
        this.salarioHora = salarioHora;
    }

    public double getSalarioLiquido(Empregado empregado) {
        double salarioBruto = getSalarioBruto(empregado);
        double inss = calcularInss(salarioBruto);
        double ir = calcularIR(salarioBruto);

        return (salarioBruto - inss - ir);
    }

    private double getSalarioBruto(Empregado empregado) {
        return horasTrabalhadas * salarioHora + (50 * empregado.getNumeroDependentes());
    }
    private double calcularInss(double salarioBruto) {
        double contribuicao = 0;
        if (salarioBruto <= 1000)
            contribuicao = salarioBruto * 0.085;
        else if (salarioBruto > 1000)
            contribuicao = salarioBruto * 0.09;

        return contribuicao;
    }

    private double calcularIR (double salarioBruto) {
        double contribuicao;

        if (salarioBruto <= 500) contribuicao = 0;
        else if (salarioBruto <= 1000) contribuicao = salarioBruto * 0.05;
        else contribuicao = salarioBruto * 0.07;

        return contribuicao;
    }
    private double horasTrabalhadas;
    private double salarioHora;
}