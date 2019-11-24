package com.AutomatasEquivalentes;

import com.AutomatasEquivalentes.logica.AFD;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Leemos el archivo y extraemos los siguientes datos.
        String[] estados;
        String[] estadosFinales;
        String[] alfabeto;
        Map<String, String> funcionDeTransicion;
        String estadoInicial;
        //cadena auxiliar
        String auxiliar;

        //automatas finitos deterministas
        AFD afd[] = new AFD[2];
        List<String> maquina = new ArrayList<>();

        System.out.println("Equivalencia de automatas:");

        String[] nombre = {"C:\\maquina0.txt","C:\\maquina1.txt"};
        for (int i = 0; i<2; i++) {
            //Leemos desde archivo
            BufferedReader br = new BufferedReader(new FileReader(nombre[i]));
            maquina = br.lines().collect(Collectors.toList());

            auxiliar = maquina.get(0);
            auxiliar = auxiliar.replace("{", "");
            auxiliar = auxiliar.replace("}", "");
            alfabeto = auxiliar.split(",");
            System.out.println("Alfabeto: "+auxiliar);

            auxiliar = maquina.get(1);
            auxiliar = auxiliar.replace("{", "");
            auxiliar = auxiliar.replace("}", "");
            estados = auxiliar.split(",");
            System.out.println("Estados: "+auxiliar);

            //Conjunto de Estados Finales
            auxiliar = maquina.get(2);
            auxiliar = auxiliar.replace("{", "");
            auxiliar = auxiliar.replace("}", "");
            estadosFinales = auxiliar.split(",");
            System.out.println("Estados Finales: "+auxiliar);

            //Estado Inicial
            estadoInicial = maquina.get(3);
            System.out.println("Estado Inicial: "+estadoInicial);

            //Funcion de Transicion
            funcionDeTransicion = pedirFuncionTransicion(estados, alfabeto);

            afd[i] = new AFD(estados, alfabeto,
                    funcionDeTransicion, estadoInicial, estadosFinales);
        }

        if (afd[0].equivalenteA(afd[1])) {
            System.out.println("\n\nSon equivalentes");
        } else {
            System.out.println("\n\nNo son equivalentes");
        }

    }

    /**
     * @param estados -> estados del AFD
     * @param alfab   -> simbolos en el alfabeto del AFD
     * @return -> funcion de transicion en hashMap
     */

    private static Map pedirFuncionTransicion(String[] estados, String[] alfab) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> mapa = new HashMap();
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

}
