package com.vianna.ex03_loteriaesportiva.models.Loteria;

import java.util.ArrayList;
import java.util.List;

public class Cartao {

    public Cartao(int numero) {
        this.numero = numero;
    }

    public Cartao() { }

    public void addJogo(Jogo j) {
        if (jogos.size() <= numeroJogosPorCartao)
            jogos.add(j);
    }

    public List<Jogo> getJogos() {
        return this.jogos;
    }

    public int getNumero() {
        return numero;
    }

    public int getNumeroJogosPorCartao() {
        return numeroJogosPorCartao;
    }

    final int numeroJogosPorCartao = 13;
    private int numero;
    private List<Jogo> jogos = new ArrayList<>();
}
