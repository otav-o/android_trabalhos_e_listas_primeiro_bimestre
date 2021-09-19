package com.vianna.ex01_salarioprofessor.models;

public class Disciplina {

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
    private boolean ehEad;
}
