package com.AnalizadorLexico.util;

public class FuncionTransicion {
    private String estadoInicial;
    private String simbolo;
    private String estadoFinal;

    public FuncionTransicion(String estadoInicial, String simbolo, String estadoFinal){
        this.estadoInicial = estadoInicial;
        this.simbolo = simbolo;
        this.estadoFinal = estadoFinal;
    }

    public FuncionTransicion(String estadoInicial, String simbolo){
        this.estadoInicial = estadoInicial;
        this.simbolo = simbolo;
        this.estadoFinal = "Not defined";
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    @Override
    public String toString(){
        return estadoInicial+" X "+simbolo+" -> "+estadoFinal;
    }
}
