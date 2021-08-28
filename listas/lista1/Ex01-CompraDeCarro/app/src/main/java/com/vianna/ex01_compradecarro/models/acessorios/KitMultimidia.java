package com.vianna.ex01_compradecarro.models.acessorios;

public class KitMultimidia implements IAcessorio{
    @Override
    public double getPreco() {
        return preco;
    }

    private double preco = 1.800;
}
