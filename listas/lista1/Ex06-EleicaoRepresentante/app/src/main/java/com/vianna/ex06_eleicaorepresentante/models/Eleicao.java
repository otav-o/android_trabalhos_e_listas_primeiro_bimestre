package com.vianna.ex06_eleicaorepresentante.models;
import java.util.List;
import java.util.Scanner;


public class Eleicao {

    public Eleicao (List<Aluno> turma) {
        this.turma = turma;
    }

    public String retornarResultados() {
        Aluno vencedor = retornarVencedor();

        return String.format("O(A) aluno(a) %s é o(a) novo(a) representante de turma, com %.2f%% dos votos.",
                vencedor.getNome(), (double) vencedor.getVotosRecebidos() / turma.size() * 100);
    }

    private Aluno retornarVencedor() {
        Aluno vencedor = turma.get(0);
        for (Aluno a : turma)
            if (a.getVotosRecebidos() > vencedor.getVotosRecebidos())
                vencedor = a;
        return vencedor;
    }

    public Aluno retornarAlunoPorMatricula(int matricula) throws Exception {
        for (Aluno a : turma)
            if (a.getMatricula() == matricula)
                return a;
        throw new Exception("Não existe aluno com esta matrícula.");
    }

    private List<Aluno> turma;
}
