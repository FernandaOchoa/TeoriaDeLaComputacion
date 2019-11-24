package com.MinimizacionAutomatas;

import com.MinimizacionAutomatas.logic.AlgoritmoMinimizacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        //Leemos el archivo y extraemos los siguientes datos.
        String[] estados;
        String[] estadosFinales;
        String[] alfabeto;
        Map<String, String> funcionDeTransicion;
        String estadoInicial;
        //cadena auxiliar
        String auxiliar;

        //automatas finitos deterministas
        AlgoritmoMinimizacion afd;
        List<String> maquina;

        System.out.println("Minimizacion de automatas:");

        String nombre = "C:\\maquinaE2.txt";
        //Leemos desde archivo
        BufferedReader br = new BufferedReader(new FileReader(nombre));
        maquina = br.lines().collect(Collectors.toList());

        auxiliar = maquina.get(0);
        auxiliar = auxiliar.replace("{", "");
        auxiliar = auxiliar.replace("}", "");
        alfabeto = auxiliar.split(",");
        System.out.println("Alfabeto: " + auxiliar);

        auxiliar = maquina.get(1);
        auxiliar = auxiliar.replace("{", "");
        auxiliar = auxiliar.replace("}", "");
        estados = auxiliar.split(",");
        System.out.println("Estados: " + auxiliar);

        //Conjunto de Estados Finales
        auxiliar = maquina.get(2);
        auxiliar = auxiliar.replace("{", "");
        auxiliar = auxiliar.replace("}", "");
        estadosFinales = auxiliar.split(",");
        System.out.println("Estados Finales: " + auxiliar);

        //Estado Inicial
        estadoInicial = maquina.get(3);
        System.out.println("Estado Inicial: " + estadoInicial);

        //Funcion de Transicion
        funcionDeTransicion = pedirFuncionTransicion(estados, alfabeto);

        afd = new AlgoritmoMinimizacion(estados, alfabeto,
                funcionDeTransicion, estadoInicial, estadosFinales);

        //si se puede reducir se imprime el nuevo automata
        if (afd.reducirAutomata()) {
            mostrar(afd);
        } else {
            System.out.println("El automata no se pudo reducir");
        }

    }

    /* Metodo para pedir la funcion de transicion por teclado
       estados -> estados del AFD
       alfab   -> simbolos en el alfabeto del AFD
       return -> funcion de transicion en hashMap
     */
    private static Map<String, String> pedirFuncionTransicion(String[] estados, String[] alfab) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> mapa = new HashMap<>();
        String transicion, valor;
        for (int i = 0; i < (estados.length * alfab.length); i++) {
            transicion = String.format("%s,%s", estados[i / alfab.length], alfab[i % alfab.length]);
            System.out.println("Ingresa el estado de trancision para ("
                    + transicion + ") : ");
            valor = reader.readLine();
            mapa.put(transicion, valor);
        }
        return mapa;
    }
    /* Metodo para mostrar el AFD minimizado
       afd -> El AFD ya minimizado
     */
    private static void mostrar(AlgoritmoMinimizacion afd){
        System.out.print("Estados: \n"+Arrays.toString(afd.getEstados())+"\n");
        System.out.print("Alfabeto: \n"+Arrays.toString(afd.getAlfabeto())+"\n");
        System.out.print("Funcion Trancision: \n"+afd.getFuncionTransicion().toString()+"\n");
        System.out.print("Estado inicial: \n"+afd.getEstadoInicial()+"\n");
        System.out.print("Estados Finales: \n"+Arrays.toString(afd.getEstadosFinales())+"\n");
    }
}