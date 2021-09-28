package com.vianna.ex01_salarioprofessor.models;

import java.io.Serializable;

public class Disciplina implements Serializable {

    public Disciplina(String nome, int creditos, boolean ehEad) {
        this.nome = nome;
        this.creditos = creditos;
        this.ehEad = ehEad;
    }

    public int getCreditos() {
        return creditos;
    }

    public boolean getEhEad() {
        return ehEad;
    }

    private String nome;
    private int creditos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean isEhEad() {
        return ehEad;
    }

    public void setEhEad(boolean ehEad) {
        this.ehEad = ehEad;
    }

    private boolean ehEad;
}
