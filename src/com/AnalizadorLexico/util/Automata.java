package com.AnalizadorLexico.util;
import java.util.ArrayList;

public class Automata {
    protected ArrayList<String> estados;
    protected ArrayList<String> alfabeto;
    protected String estadoInicial;
    protected ArrayList<String> estadosFinales;
    protected ArrayList<FuncionTransicion> transiciones;

    public Automata(ArrayList<String> estados, ArrayList<String> alfabeto, String estadoInicial, ArrayList<String> estadosFinales,
                    ArrayList<FuncionTransicion> transiciones){
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
        this.transiciones = transiciones;
        System.out.println(this);
    }

    public Automata(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosFinales,
                    ArrayList<FuncionTransicion> transiciones){
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
        this.transiciones = transiciones;
    }

    public void setEstadosDeTransiciones(int i, String estado){
        if(estados.contains(estado)){
            transiciones.get(i).setEstadoFinal(estado);
        } else {
            System.out.println("Error, el estado no existe en el conjunto de estados");
        }
    }

    public boolean compararAlfabeto(ArrayList<String> alfabeto){
        return this.alfabeto.equals(alfabeto);
    }

    public boolean verificarAutomata(){
        boolean key = true;
        if(!estados.contains(estadoInicial))
            key = false;
        if(!estados.containsAll(estadosFinales))
            key = false;
        return key;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public String getEstado(String estadoInicial, String simbolo){
        FuncionTransicion transicion;
        String estado = "";
        for (int i = 0; i < transiciones.size(); i++) {
            transicion = transiciones.get(i);
            if(transicion.getEstadoInicial().equals(estadoInicial) && transicion.getSimbolo().equals(simbolo))
                estado = transicion.getEstadoFinal();
        }
        return estado;
    }

    public boolean esInicial(String estado){
        return estadoInicial.equals(estado);
    }

    public boolean esFinal(String estado){
        return estadosFinales.contains(estado);
    }

    public boolean esEstadoInicial(String estado){
        return this.estadoInicial.equals(estado);
    }

    public boolean esEstadoFinal(String estado){
        return this.estadosFinales.contains(estado);
    }

    @Override
    public String toString(){
        return "Estados: "+ estados + "\n"
                + "Alfabeto: "+ alfabeto + "\n"
                + "Estado inicial: " + estadoInicial + "\n"
                + "Estados finales: " + estadosFinales +  "\n"
                + "Funciones de Transicion: " + transiciones;
    }
}
