package com.MinimizacionAutomatas.model;

import java.util.Map;
/* Conjunto de Estados - mEstados
 Alfabeto - mAlfabeto
 Transiciones - mFuncionTransición
 Estado inicial - mEstadoInicial
 Conjunto de estados Finales - mEstadosFinales
 * protected: para que esten disponibles en el paquete.
*/
public class AFD {
    public String mEstados[];
    public String mAlfabeto[];
    public Map<String,String> mFuncionTransicion;
    public String mEstadoInicial;
    public String mEstadosFinales[];

    AFD(){
        //Constructor por omision
    }

    // Constructor parametrizado
    public AFD(String[] estados, String[] alfabeto,
               Map<String, String> funcionTransicion, String estadoInicial, String[] estadosFinales) {
        mEstados = estados;
        mAlfabeto = alfabeto;
        mFuncionTransicion = funcionTransicion;
        mEstadoInicial = estadoInicial;
        mEstadosFinales = estadosFinales;
    }

    public void setEstados(String[] estados) {
        mEstados = estados;
    }
    public void setAlfabeto(String[] alfabeto) {
        mAlfabeto = alfabeto;
    }
    public void setFuncionTransicion(Map<String, String> funcionTransicion) {
        mFuncionTransicion = funcionTransicion;
    }
    public void setEstadoInicial(String estadoInicial) {
        mEstadoInicial = estadoInicial;
    }
    public void setEstadosFinales(String[] estadosFinales) {
        mEstadosFinales = estadosFinales;
    }

    public String[] getEstados() {  return mEstados; }
    public String[] getAlfabeto() {  return mAlfabeto;  }
    public Map<String, String> getFuncionTransicion() {
        return mFuncionTransicion;
    }
    public String getEstadoInicial() {  return mEstadoInicial; }
    public String[] getEstadosFinales() {
        return mEstadosFinales;
    }

    public boolean esEstadoFinal(String estado){
        for(int i = 0; i < mEstadosFinales.length; i++ ){
            if(estado.equals(mEstadosFinales[i]))
                return true;
        }
        return false;
    }
}