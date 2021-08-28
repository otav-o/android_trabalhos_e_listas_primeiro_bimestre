package com.vianna.ex01_compradecarro.models;

import com.vianna.ex01_compradecarro.models.acessorios.IAcessorio;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    public Carro (String modelo, Motor motor) {
        this.modelo = modelo;
        this.motor = motor;
    }

    public double getPrecoFinal() {
        preco = getPrecoModelo() +
                calcularSomaAcessorios();

        preco += preco * (1 + calcularAliquotaImposto());

        return preco;
    }

    public void adicionarAcessorio(IAcessorio... ac) {
        for (IAcessorio a : ac)
            acessorios.add(a);
    }

    private double getPrecoModelo() {
        if (modelo == "Celta")
            return 15000;
        else
            return 10000;
    }

    private double calcularAliquotaImposto() {
        return calcularIpi() + calcularImpostoImportacao();
    }

    private double calcularImpostoImportacao() {
        if (ehImportado)
            return 0.3;
        else
            return 0;
    }

    private double calcularIpi() {
        double ipi = 0.2;
        if (motor.getCilindradas() == 1.0)
            ipi = 0.1;
        return ipi;
    }

    private double calcularSomaAcessorios() {
        double somaAcessorios = 0;
        for (IAcessorio a : acessorios)
            somaAcessorios += a.getPreco();
        return somaAcessorios;
    }

    private List<IAcessorio> acessorios = new ArrayList<>();
    private double preco;
    private Motor motor;
    private boolean ehImportado;
    private String modelo;
}
