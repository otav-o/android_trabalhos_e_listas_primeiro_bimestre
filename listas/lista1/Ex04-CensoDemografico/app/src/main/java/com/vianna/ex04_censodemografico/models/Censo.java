package com.vianna.ex04_censodemografico.models;

import java.util.ArrayList;
import java.util.List;

public class Censo {

    public Censo (Pessoa[] populacao) {
        this.populacao = populacao;
    }

    private double maiorAltura() {
        return maisAlta().altura;
    }

    private double menorAltura() {
        return maisBaixa().altura;
    }

    public String retornarPesquisa() {
        return "DADOS SOBRE ESTA POPULAÇÃO:\n" +
                "Maior altura: " + maiorAltura() + "m.\n"+
                "Menor altura: " + menorAltura() + "m.\n" +
                "Altura média das mulheres: " + mediaAlturaMulheres() + "m.\n" +
                "Número de homens: " + numeroPorSexo(Genero.masculino)+ "\n" +
                "Porcentagem de homens: " + (double) numeroPorSexo(Genero.masculino)/populacao.length * 100 + "%\n" +
                "Porcentagem de mulheres: " + (double) numeroPorSexo(Genero.feminino)/populacao.length * 100 + "%\n" +
                "Mulheres loiras de olhos verdes entre 18 e 35 anos: "
                + porcentagemPorSexoIdadeOlhosECabelos(18, 35, Genero.feminino, "Verde", "Loiro") + "% do total";
    }

    private int numeroPorSexo(Genero g) {
        return pessoasPorSexo(g).size(); // problema de desempenho: vai executar toda vez que for chamado (em vez de guardar o cálculo)
    }

    private double porcentagemPorSexoIdadeOlhosECabelos(int idadeMin, int idadeMax, Genero g, String corOlhos, String corCabelos) { // horrível!
        int cont = 0;
        for (Pessoa p : populacao)
            if (p.idade >= idadeMin &&
                    p.idade <= idadeMax &&
                    p.sexo == g &&
                    p.corOlhos == corOlhos &&
                    p.corCabelos == corCabelos)
                cont++;

        return (double)cont / populacao.length * 100;
    }

    private double mediaAlturaMulheres() {
        double somaAltura = 0;

        List<Pessoa> mulheres = pessoasPorSexo(Genero.feminino);
        for (Pessoa p : mulheres) // para cada pessoa na lista de mulheres
            somaAltura += p.altura;

        return somaAltura / mulheres.size();
    }

    private List<Pessoa> pessoasPorSexo(Genero g) {
        List<Pessoa> lista = new ArrayList<>();

        for (int i = 0; i < populacao.length; i++)
            if (populacao[i].sexo == g)
                lista.add(populacao[i]);

        return lista;
    }

    private Pessoa maisAlta() {

        Pessoa maisAlta = populacao[0];

        for (int i = 0; i < populacao.length; i++) {
            if (populacao[i].altura > maisAlta.altura)
                maisAlta = populacao[i];
        }
        return maisAlta;
    }

    private Pessoa maisBaixa() { // código repetido!

        Pessoa maisBaixa = populacao[0];

        for (int i = 0; i < populacao.length; i++) {
            if (populacao[i].altura < maisBaixa.altura)
                maisBaixa = populacao[i];
        }
        return maisBaixa;
    }

    private Pessoa[] populacao;
}