package com.vianna.ex01_salarioprofessor.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor implements Serializable {

    public Professor(String nome, int especializacao, double salarioPorHora) {
        this.nome = nome;
        this.salarioPorHora = salarioPorHora;
        setEspecializacao(especializacao);
    }

    private double salarioPorHora;

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public boolean isPossuiMestrado() {
        return possuiMestrado;
    }

    public void setPossuiMestrado(boolean possuiMestrado) {
        this.possuiMestrado = possuiMestrado;
    }

    public boolean isPossuiEspecializacao() {
        return possuiEspecializacao;
    }

    public void setPossuiEspecializacao(boolean possuiEspecializacao) {
        this.possuiEspecializacao = possuiEspecializacao;
    }

    public boolean isPossuiDoutorado() {
        return possuiDoutorado;
    }

    public void setPossuiDoutorado(boolean possuiDoutorado) {
        this.possuiDoutorado = possuiDoutorado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double calcularSalario() {
        if (possuiDoutorado) salarioPorHora *= 1.75;
        else if (possuiMestrado) salarioPorHora *= 1.45;
        else if (possuiEspecializacao) salarioPorHora *= 1.15;

        double creditos = 0;

        for (Disciplina d: disciplinas) {
            if (d.getEhEad())
                creditos += d.getCreditos() * 0.75;
            else
                creditos += d.getCreditos();
        }
        return creditos * 4 * salarioPorHora;
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
