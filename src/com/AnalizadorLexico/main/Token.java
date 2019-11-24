package com.AnalizadorLexico.main;

public class Token {
    private int tipo;
    private String lexema;

    public Token(int tipo, String lexema){
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public int getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    @Override
    public String toString(){
        return tipo +"\t\t"+lexema;
    }
}
