package com.vianna.ex03_loteriaesportiva.models;

import com.vianna.ex03_loteriaesportiva.models.Loteria.Cartao;

import java.util.ArrayList;
import java.util.List;

public class Apostador {

    public Apostador(String nome) {
        this.nome = nome;
        cartoes = new ArrayList<>();
    }

    public int getNumeroAcertos(Cartao gabarito, int numeroCartao) throws Exception {
        int qtd = 0;
        Cartao cartao = getCartao(numeroCartao);
        for (int i = 0; i < gabarito.getNumeroJogosPorCartao(); i++) {
            if (cartao.getJogos().get(i).getResultado()
                    == gabarito.getJogos().get(i).getResultado())
                qtd++;
        }
        return qtd;
    }

    public void addCartao(Cartao c) {
        cartoes.add(c);
    }

    public Cartao getCartao(int numero) throws Exception {
        for (Cartao c : cartoes)
            if (c.getNumero() == numero)
                return c;

        throw new Exception("Não existe cartão com este número.");
    }

    public String getNome() {
        return nome;
    }

    private String nome;
    private List<Cartao> cartoes;
}
