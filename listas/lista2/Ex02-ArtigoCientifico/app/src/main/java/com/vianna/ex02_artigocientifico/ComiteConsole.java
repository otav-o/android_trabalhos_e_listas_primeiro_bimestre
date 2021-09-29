package com.vianna.ex02_artigocientifico;

import com.vianna.ex02_artigocientifico.models.Artigo;

import java.util.List;

public class ComiteConsole {
    public ComiteConsole(List<Artigo> artigos) {
        artigosParaAvaliar = artigos;
    }

    public String retornarResultado () {
        ordenarArtigosPorNota();
        Artigo primeiro = artigosParaAvaliar.get(0);
        Artigo segundo = artigosParaAvaliar.get(1);
        Artigo terceiro = artigosParaAvaliar.get(2);

        return String.format("Artigos vencedores: \n" +
                "1° - %s, nota: %.2f\n" +
                "2° - %s, nota: %.2f\n" +
                "3° - %s, nota: %.2f"
        , primeiro.getTitulo(), primeiro.getNota(),
                segundo.getTitulo(), segundo.getNota(),
                terceiro.getTitulo(), terceiro.getNota());
    }

    private void ordenarArtigosPorNota() {
        int fim = artigosParaAvaliar.size() - 1; // inicialmente, o fim é a última posição do vetor.
        int pos; // indica a posição da última troca

        do
        {
            pos = -1;
            for (int i = 0; i < fim; i++)
                if (artigosParaAvaliar.get(i).getNota() < artigosParaAvaliar.get(i + 1).getNota())
                {
                    inverterPosicoes(i, i + 1);
                    pos = i;
                }
            fim = pos; // só vai pesquisar até a última posição trocada
        } while (pos > 0);
    }

    private void inverterPosicoes(int i, int j) {
        Artigo aux = artigosParaAvaliar.get(i);
        artigosParaAvaliar.set(i, artigosParaAvaliar.get(j));
        artigosParaAvaliar.set(j, aux);
    }

    public List<Artigo> getArtigosParaAvaliar() {
        return artigosParaAvaliar;
    }

    private List<Artigo> artigosParaAvaliar;
}
