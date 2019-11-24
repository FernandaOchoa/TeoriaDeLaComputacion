package com.MinimizacionAutomatas.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.MinimizacionAutomatas.model.AFD;

public class AlgoritmoEquivalencia {
    public AlgoritmoEquivalencia(){
        //Constructor por omision
    }
    /* Metodo de equivalencia de Automatas Finitos Deterministas
       afdPC para el automata con el que se compara
       faltanEstadosPorAnalizar ->para saber si faltan estados o ya todos se analizaron
       estadosAnalizados -> lista para guardar los estados analizados
       estados[] -> array para estados devueltos al hacer la transicion por los simbolos del alfabeto
       pila -> para guardar estados pendientes
     */
    public boolean equivalenteA(AFD afdPC){
        boolean faltanEstadosPorAnalizar = true;
        List<String> estadosAnalizados = new ArrayList();
        String estados[];
        Stack<String> pila = new Stack();

        //obtener estados iniciales
        String estadoActual = afdPC.mEstadoInicial;
        String estadoActualPC = afdPC.getEstadoInicial();

        //mientras haya estados no analizados
        while(faltanEstadosPorAnalizar){
            //agregar estados a la lista para evitar repeticion
            estadosAnalizados.add(estadoActual + "," + estadoActualPC);
            //obtener la transicion de estados por cada simbolo del alfabeto
            estados = transicion(afdPC, estadoActual, estadoActualPC);
            //iterar por los estados dados por las transiciones
            for (String estado : estados) {
                //si los estados no son compatibles
                if (afdPC.esEstadoFinal(estado.split(",")[0])
                        != afdPC.esEstadoFinal(estado.split(",")[1])) {
                    //falso
                    return false;
                }
                //si no
                else {
                    //ingresar a una pila
                    pila.push(estado);
                }
            }
            //hacer mientras el estado se encuentre en la lista de analizados
            String estadoSiguiente = "";
            do{
                if(!pila.isEmpty()){
                    //sacar el siguiente elemento de la pila
                    estadoSiguiente = pila.pop();
                }else{
                    faltanEstadosPorAnalizar = false;
                    break;
                }
            }while(estadosAnalizados.contains(estadoSiguiente));
            //si la cadena no esta vacia
            if(!estadoSiguiente.isEmpty()){
                //dividir la cadena de la pila por "," y asignar a los estados actuales
                estadoActual = estadoSiguiente.split(",")[0];
                estadoActualPC = estadoSiguiente.split(",")[1];
            }
        }
        return true;
    }

    /* Metodo para regresar todos los estados de transicion de los simbolos del alfabeto
       afdPC -> automata finito determinista que se esta comparando
       ea -> estado actual del automata comparado
       eaC-> estado actual del automata al que se compara
       return -> conjunto de estados igual al numero de simbolos del alfabeto
     */
    public String[] transicion(AFD afdPC, String ea, String eaC){
        //los estados son iguales al numero de simbolos en el alfabeto
        String []resultado = new String[afdPC.mAlfabeto.length];
        String nuevoEstado,nuevoEstadoPC;
        //iteramos por cada simbolo del alfabeto
        //Creamos la funcion para obtener la transición
        for(int i = 0; i < afdPC.mAlfabeto.length; i++){
            //obtenemos el estado al que se hace la transicion de dicho simbolo
            nuevoEstado = afdPC.mFuncionTransicion.get(ea + "," + afdPC.mAlfabeto[i]);
            nuevoEstadoPC = afdPC.getFuncionTransicion().get(eaC + "," +afdPC.getAlfabeto()[i]);
            resultado[i] = nuevoEstado + "," + nuevoEstadoPC;
        }
        return resultado;
    }
}