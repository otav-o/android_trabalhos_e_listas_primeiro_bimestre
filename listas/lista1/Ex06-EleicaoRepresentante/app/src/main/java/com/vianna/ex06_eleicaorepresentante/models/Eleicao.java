package com.vianna.ex06_eleicaorepresentante.models;
import java.util.List;
import java.util.Scanner;

/* Reconheço que o tratamento de exceções não está bom, e estou imprimindo a partir da classe Eleicao (apesar de ser em poucos pontos)
* Também sei do bug em que tentar votar novamente gasta uma iteração no foreach de iniciarVotacao() - eu deveria lançar exceção em Eleição,
* e não em Aluno. Mas fiz só para testar!*/

public class Eleicao {

    public Eleicao (List<Aluno> turma) {
        this.turma = turma;
    }

    public void iniciarVotacao() {
        for (Aluno a : turma) {
            Aluno eleitor = logarEleitor();
            colherVoto(eleitor);
        }
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

    private Aluno logarEleitor() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira a SUA matrícula: ");
        Aluno eleitor = null;
        try {
            eleitor = retornarAlunoPorMatricula(s.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage()); // provavelmente se imprime no main ou em uma view
            eleitor = logarEleitor();
        }
        return eleitor;
    }

    private void colherVoto(Aluno eleitor) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Olá, %s. Insira a matrícula do seu candidato: ", eleitor.getNome());
        Aluno candidato = null;
        try {
            candidato = retornarAlunoPorMatricula(s.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            colherVoto(eleitor);
        }
        try {
            eleitor.votar(candidato);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Voto não registrado.");
        }
    }

    private Aluno retornarAlunoPorMatricula(int matricula) throws Exception {
        for (Aluno a : turma)
            if (a.getMatricula() == matricula)
                return a;
        throw new Exception("Não existe aluno com esta matrícula.");
    }

    private List<Aluno> turma;
}
