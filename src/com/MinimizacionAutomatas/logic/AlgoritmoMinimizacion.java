package com.MinimizacionAutomatas.logic;
import com.MinimizacionAutomatas.model.AFD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AlgoritmoMinimizacion extends AFD {
    //Constructor parametrizado
    public AlgoritmoMinimizacion(String[] estados, String[] alfabeto, Map<String, String> funcionTransicion, String estadoInicial, String[] estadosFinales) {
        super(estados, alfabeto, funcionTransicion, estadoInicial, estadosFinales);
    }

    /* Metodo para reducir el AFD
       true: Si se puede reducir
       false: Si no
     */
    public boolean reducirAutomata() {
        AFD automataEquivalente;
        AlgoritmoEquivalencia ae = new AlgoritmoEquivalencia();
        List<String> lista = new ArrayList();
        Stack<String> pila = new Stack();
        String[] transiciones;
        //ekA <- elemento del conjunto de estados {k} actual
        //ekApc <- elemento del conjunto de estados {k} actual por comparar
        String transicionActual, ekA, ekApc;

        //iterar por cada uno de los elementos del conjunto de estados {k}.
        for (String k : mEstados) {
            //iterar por los estados del automata, llamados k'(kpc) para comparar
            for (String kpc : mEstados) {
                //limpiamos la lista
                lista.clear();
                //si k es equivalente a k' (son o no finales los 2) y k no es k'(kpc)
                if ((esEstadoFinal(k) == esEstadoFinal(kpc)) && !k.equals(kpc)) {
                    //se agregan a la lista y pila k y k'(kpc)
                    lista.add(k + "," + kpc);
                    pila.push(k + "," + kpc);
                    //hacer mientras la pila no este vacia
                    do {
                        //sacamos la transicion de la pila y la asignamos
                        transicionActual = pila.pop();
                        ekA = transicionActual.split(",")[0];
                        ekApc = transicionActual.split(",")[1];
                        //obtener las transiciónes posibles de cada simbolo
                        transiciones = ae.transicion(this, ekA, ekApc);
                        //iterar por el par de estados de cada transicion
                        for (String transicion : transiciones) {
                            //separamos la transicion a cada estado k y k'(kpc)
                            ekA = transicion.split(",")[0];
                            ekApc = transicion.split(",")[1];
                            //si los estados actuales no estan en la lista
                            if (!lista.contains(transicion)) {
                                //si los estados actuales son equivalentes
                                if (esEstadoFinal(ekA) == esEstadoFinal(ekApc)) {
                                    //agregar a la pila y lista las transiciónes
                                    pila.push(ekA + "," + ekApc);
                                    lista.add(ekA + "," + ekApc);
                                    //si no
                                } else {
                                    //vaciar la pila
                                    pila.clear();
                                    //limpiar lista
                                    lista.clear();
                                    //salir del ciclo
                                    break;
                                }
                            }
                        }
                    } while (!pila.isEmpty());
                    //si la lista no esta vacia
                    if (!lista.isEmpty()) {
                        //obtenemos los estados que comparamos para equivalencia
                        ekA = lista.get(0).split(",")[0];
                        ekApc = lista.get(0).split(",")[1];
                        System.out.println(ekA + " y " + ekApc + " son equivalentes: ");
                        System.out.println(lista.toString());
                        //creamos el automata equivalente
                        automataEquivalente = crearAutomataEquivalente(ekA, ekApc);
                        //si el nuevo automata se reduce
                        ((AlgoritmoMinimizacion) automataEquivalente).reducirAutomata();
                        //asignamos los nuevos valores al automata local
                        setValuesFromAutomata(automataEquivalente);
                        //regresamos verdadero
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* Metodo para Eliminar el estado equivalente del conjunto de estados del AFD
       ek -> estado a comparar
       ekPC -> estado primo al comparado
       retun -> arrelgo de estados sin el estado primo
     */
    private String[] eliminarEstadoEquivalente(String ek, String ekPC) {
        String[] nuevosEstados = new String[mEstados.length - 1];
        int contador = 0;
        //si son iguales, retornamos los estados actuales
        if (ek.equals(ekPC)) {
            return mEstados;
        }
        //iterar por los estados
        for(String estado: mEstados){
            //si el estado actual no es igual a ek'
            if(!estado.equals(ekPC)){
                //agregamos al nuevo arreglo el estado
                nuevosEstados[contador] = estado;
                contador++;
            }
        }
        //regresamos el nuevo arreglo
        return nuevosEstados;
    }

    /* Metodo para Eliminar las transiciones redundantes,
       quitando el estado equivalente primo(pC) y redirigiendo las transiciones al estado equivalente (ek)
       ek -> el estado comparado
       ekPc -> el estado Equivalente al comparado
       return -> funcion de transicion sin transiciones a el estado primo (ek')
     */
    private Map <String,String> eliminarTransicionEquivalente(String ek, String ekPc){
        Map <String,String> funcionTranicion = mFuncionTransicion;
        //buscar transiciones que apuntent a el estado ek' y apuntarlas a ekPc
        for(Map.Entry<String, String> entry :funcionTranicion.entrySet()){
            if(entry.getValue().equals(ekPc)){
                entry.setValue(ek);
            }
        }
        //eliminar las transiciones de ek'
        for(String simbolo: mAlfabeto){
            funcionTranicion.remove(ekPc + "," + simbolo);
        }
        //regresamos la funcion de transicion modificada
        return funcionTranicion;
    }

    /* Metodo para eliminar el estado final equivalente y devuelve los nuevos estados finales
       ek -> el estado comparado
       ekPc -> el estado equivalente al comparado
       return los estados finales sin el equivalente, si los estados no son finales regresa los mismos
     */
    private String[] eliminarEstadoFinalEquivalente(String ek, String ekPc){
        String[] nuevosEdosFinales = new String[mEstadosFinales.length - 1];
        int contador = 0;
        //si son finales, quitamos el estado eqivalente ek' (ekPc)
        if(esEstadoFinal(ek) && esEstadoFinal(ekPc)){
            for(String edoFinal : mEstadosFinales){
                if(!edoFinal.equals(ekPc)){
                    nuevosEdosFinales[contador] = edoFinal;
                    contador++;
                }
            }
            //si no devolver los mismos estados finales
        }else{
            return mEstadosFinales;
        }
        return nuevosEdosFinales;
    }

    /* Metodo para crear un nuevo automata
      sin uno de los estados equivalentes
      ek estado equivalente
      ekPc estado primo equivalente
      AFD equivalente sin el estado ek'
     */
    private AlgoritmoMinimizacion crearAutomataEquivalente(String ek, String ekPc) {
        //Creamos un nuevo Automata
        return new AlgoritmoMinimizacion(  //con los mismos estados menos ek'
                eliminarEstadoEquivalente(ek, ekPc),
                //con el mismo alfabeto
                mAlfabeto,
                //las transiciones que apuntan a ek' ahora apuntan a ek, y las que salian de ek' se eliminan
                eliminarTransicionEquivalente(ek, ekPc),
                //con el mismo estado inicial
                mEstadoInicial,
                //con los nuevos estados finales (si ek y ek' no eran finales, quedaran los mismso edos. finales)
                eliminarEstadoFinalEquivalente(ek, ekPc));
    }

    /* Metodo para Setear los valores de los atributos del automata parametro a
       este automata
       afd -> automata del que se quieren asignar los valores
       al automata actual
     */
    public void setValuesFromAutomata(AFD afd){
        setEstados(afd.getEstados());
        setAlfabeto(afd.getAlfabeto());
        setFuncionTransicion(afd.getFuncionTransicion());
        setEstadoInicial(afd.getEstadoInicial());
        setEstadosFinales(afd.getEstadosFinales());
    }
}