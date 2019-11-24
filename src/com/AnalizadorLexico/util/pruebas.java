package com.AnalizadorLexico.util;

public class pruebas {
    public static void main(String[] args) {
        System.out.println("\n Pares \n");
        //Para elementos pares lado izquierdo
        for(int i=0; i<=10; i+=2){
            System.out.println(i);
        }

        System.out.println("\n Impares \n");

        //Para elementos pares lado derecho
        for(int i=1; i<=10; i+=2){
            System.out.println(i);
        }
    }
/*
    //Para la lista partir en dos impares (lado derecho) pares (lado izquierdo)
        for (String l : lista){
        for (String side : l.split("->"))
            listaBoth.add(side.trim());
    }

    //Para imprimir todos elementos de la lista
        for(String n : listaBoth)
            // System.out.println(n);

            //Para los elementos pares (Lado izquierdo)
            for(int i=0; i < listaBoth.size(); i+=2) {
        //System.out.println(listaBoth.get(i));
        listaLeft.add(listaBoth.get(i));
    }

    //Para elementos pares lado derecho
        for(int i=1; i< listaBoth.size(); i+=2){
        //System.out.println(listaBoth.get(i));
        listaRight.add(listaBoth.get(i));
    }

        //Ya tengo ambas listas
        for(String a : listaRight){
            for (int i=0; i < listaLeft.size(); i++){
                String aux = listaLeft.get(i);
                if(!listaRight.contains(aux)){
                    ListaTerminales.add(a);
                }
            }
        }
        //Imprimo los terminales
        for(String m : ListaTerminales)
            System.out.println(m);
*/
}
