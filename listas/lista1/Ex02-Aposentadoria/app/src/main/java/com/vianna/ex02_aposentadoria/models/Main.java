/*
    Crie um programa para verificar se um empregado está qualificado para a
    aposentadoria ou não. Para estar em condições, um dos seguintes requisitos deve ser
    satisfeito:
    - Ter no mínimo 65 anos de idade.
    - Ter trabalhado no mínimo 30 anos.
    - Ter no mínimo 60 anos e ter trabalhado no mínimo 25 anos.
 */
package com.vianna.ex02_aposentadoria.models;

public class Main {

    public static void main(String[] args) {

        Empregado otavio = new Empregado(2001, 0);
        Empregado daves = new Empregado(1854, 0);

        System.out.println(otavio.podeAposentar());
        System.out.println(daves.podeAposentar());
    }
}
