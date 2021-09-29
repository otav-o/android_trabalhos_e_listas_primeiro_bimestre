package com.vianna.ex02_artigocientifico.models.Pessoa;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    public String getNome() { return nome; }
    protected String nome;
}
