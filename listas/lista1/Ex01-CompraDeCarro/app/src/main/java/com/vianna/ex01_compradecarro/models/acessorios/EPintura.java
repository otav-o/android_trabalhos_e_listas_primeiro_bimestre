package com.vianna.ex01_compradecarro.models.acessorios;

public enum EPintura implements IAcessorio {

    ESPECIAL(5000),
    METALICA(5000),
    COMEMORATIVA(5000);

    @Override
    public double getPreco() {
        return preco;
    }

    private EPintura(double preco) {
        this.preco = preco;
    }
    private double preco;
}
