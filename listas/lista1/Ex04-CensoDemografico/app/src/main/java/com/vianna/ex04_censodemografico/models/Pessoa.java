package com.vianna.ex04_censodemografico.models;

public class Pessoa {

    public Pessoa(Genero sexo, String corOlhos, String corCabelos, int idade, double altura) {
        this.sexo = sexo;
        this.corOlhos = corOlhos;
        this.corCabelos = corCabelos;
        this.idade = idade;
        this.altura = altura;
    }

    public Genero sexo;
    public String corOlhos;
    public String corCabelos;
    public int idade;
    public double altura;
}