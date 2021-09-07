package com.vianna.ex06_eleicaorepresentante.models;

public class Aluno {

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        jaVotou = false;
    }

    public void votar(Aluno a) throws Exception {
        if (this.jaVotou)
            throw new Exception(this.nome + " já votou.");

        a.votosRecebidos++;
        this.jaVotou = true;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getVotosRecebidos() {
        return votosRecebidos;
    }

    private String nome;
    private boolean jaVotou;
    private int votosRecebidos;
    private int matricula;
}