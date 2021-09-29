package com.vianna.ex03_loteriaesportiva.models.Loteria;

// Representa uma partida de futebol

public class Jogo {

    public Jogo(String time1, String time2, int golsTime1, int golsTime2) {
        this.time1 = time1;
        this.time2 = time2;
        this.golsTime1 = golsTime1;
        this.golsTime2 = golsTime2;
    }
    
    public int getResultado() {
        if (golsTime1 > golsTime2) return 1;
        else if (golsTime2 > golsTime1) return 2;
        else return 3;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    private String time1;
    private String time2;
    private int golsTime1;
    private int golsTime2;
}
