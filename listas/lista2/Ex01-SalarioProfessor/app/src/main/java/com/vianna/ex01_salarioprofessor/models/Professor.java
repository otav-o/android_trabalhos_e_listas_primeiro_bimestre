package com.vianna.ex01_salarioprofessor.models;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    public Professor(String nome, int especializacao) {
        this.nome = nome;
        setEspecializacao(especializacao);
    }

    public double calcularSalario(double valorPorHora) {
        if (possuiDoutorado) valorPorHora *= 1.75;
        else if (possuiMestrado) valorPorHora *= 1.45;
        else if (possuiEspecializacao) valorPorHora *= 1.15;

        double creditos = 0;

        for (Disciplina d: disciplinas) {
            if (d.getEhEad())
                creditos += d.getCreditos() * 0.75;
            else
                creditos += d.getCreditos();
        }
        return creditos * 4 * valorPorHora;
    }

    public void addDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public void setEspecializacao (int n) {
        switch (n) {
            case 2: possuiEspecializacao = true; break;
            case 3: possuiMestrado = true; break;
            case 4: possuiDoutorado = true; break;
        }
    }

    private List<Disciplina> disciplinas = new ArrayList<>();

    private boolean possuiMestrado = false;
    private boolean possuiEspecializacao = false;
    private boolean possuiDoutorado = false;

    private String nome;
}
