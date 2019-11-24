package com.AnalisisTokenLexico.main;
import com.AnalisisTokenLexico.util.Automata;
import com.AnalisisTokenLexico.util.FuncionTransicion;

import java.util.ArrayList;

public class AutomataTokens extends Automata {
    public static final String IS_DIGIT = "0";
    public static final String OTHER = "1";
    public static final String IS_ALPHA = "2";
    public static final String IS_ALNUM = "3";

    public String estadoActual;

    public AutomataTokens(){
        super(
                new ArrayList<String>(){{
                    add("0");
                    add("1");
                    add("2");
                    add("3");
                    add("4");
                    add("5");
                    add("6");
                }}, "0",
                new ArrayList<String>(){{
                    add("2");
                    add("5");
                    add("6");
                }},
                new ArrayList<FuncionTransicion>(){{
                    add(new FuncionTransicion("0", IS_DIGIT, "1"));
                    add(new FuncionTransicion("0", OTHER, "3"));
                    add(new FuncionTransicion("1", IS_DIGIT, "1"));
                    add(new FuncionTransicion("1", OTHER, "2"));
                    add(new FuncionTransicion("3", IS_ALPHA, "4"));
                    add(new FuncionTransicion("3", OTHER, "6"));
                    add(new FuncionTransicion("4", IS_ALNUM, "4"));
                    add(new FuncionTransicion("4", OTHER, "5"));
                }}
        );
        estadoActual = estadoInicial;
    }

    public String cambiarEstadoActual(String funcion){
        FuncionTransicion func;
        for (FuncionTransicion transicione : transiciones) {
            func = transicione;
            if (func.getEstadoInicial().equals(estadoActual) && func.getSimbolo().equals(funcion)) {
                estadoActual = func.getEstadoFinal();
                break;
            }
        }
        return estadoActual;
    }

    public void reiniciar(){
        this.estadoActual = "0";
    }

    public String getEstadoActual(){
        return estadoActual;
    }
}
