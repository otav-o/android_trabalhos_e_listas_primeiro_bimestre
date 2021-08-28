package com.vianna.ex01_compradecarro.models.acessorios;

public class CambioAutomatico implements IAcessorio{
    @Override
    public double getPreco() {
        return preco;
    }

    private double preco = 5000;
}
