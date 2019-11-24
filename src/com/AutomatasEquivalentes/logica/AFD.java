package com.AutomatasEquivalentes.logica;
import java.util.Map;

public class AFD extends Algoritmo {
    /* Conjunto de Estados - mEstados
    Alfabeto - mAlfabeto
    Transiciones - mFuncionTransición
    Estado inicial - mEstadoInicial
    Conjunto de estados Finales - mEstadosFinales
    * protected: para que esten disponibles en el paquete.
  */
    protected String mEstados[];
    protected String mAlfabeto[];
    protected Map<String,String> mFuncionTransicion;
    protected String mEstadoInicial;
    protected String mEstadosFinales[];

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

    public String[] getEstados() {  return mEstados; }

    public String[] getAlfabeto() {  return mAlfabeto;  }

    public Map<String, String> getFuncionTransicion() {
        return mFuncionTransicion;
    }

    public String getEstadoInicial() {  return mEstadoInicial; }

    public boolean esEstadoFinal(String estado){
        for(int i = 0; i < mEstadosFinales.length; i++ ){
            if(estado.equals(mEstadosFinales[i]))
                return true;
        }
        return false;
    }
}
