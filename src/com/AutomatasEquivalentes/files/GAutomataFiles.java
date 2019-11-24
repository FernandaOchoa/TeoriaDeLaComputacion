package com.AutomatasEquivalentes.files;

import java.io.FileOutputStream;
import java.io.IOException;

public class GAutomataFiles {
    public static void main(String[] args) throws IOException {
        createFile();
    }
    private static void createFile() throws IOException {
        //Definiendo la maquina0
        FileOutputStream fos0 = new FileOutputStream("C:\\maquina0.txt");
        String alfabeto0 = "{a,b,c}\n";
        String estados0 = "{q0,q1,q2,q3}\n";
        String estadoFinal0 = "{q0,q1,q2}\n";
        String estadoInicial0 = "q0\n";
        String transiciones0= "{q0,a,q0},{q0,b,q1},{q0,c,q0},{q1,a,q2},{q1,b,q1},{q1,c,q3}," +
                "{q2,a,q2},{q2,b,q1},{q2,c,q2},{q3,a,q3},{q3,b,q3},{q3,c,q3}";

        byte a0[] = alfabeto0.getBytes();
        byte e0[] = estados0.getBytes();
        byte ef0[] = estadoFinal0.getBytes();
        byte ei0[] = estadoInicial0.getBytes();
        byte t0[] = transiciones0.getBytes();

        //Escribo la maquina0
        fos0.write(a0);
        fos0.write(e0);
        fos0.write(ef0);
        fos0.write(ei0);
        fos0.write(t0);
        fos0.close();

        //Defino la Maquina 1 en un Archivo
        FileOutputStream fos = new FileOutputStream("C:\\maquina1.txt");
        String alfabeto = "{a,b,c}\n";
        String estados = "{q0,q1,q2}\n";
        String estadoFinal = "{q0,q1}\n";
        String estadoInicial = "q0\n";
        String transiciones = "{q0,a,q0},{q0,b,q1},{q0,c,q0},{q1,a,q0},{q1,b,q1},{q1,c,q2}," +
                "{q2,a,q2},{q2,b,q2},{q2,c,q2}";

        byte a[] = alfabeto.getBytes();
        byte e[] = estados.getBytes();
        byte ef[] = estadoFinal.getBytes();
        byte ei[] = estadoInicial.getBytes();
        byte t[] = transiciones.getBytes();

        fos.write(a);
        fos.write(e);
        fos.write(ef);
        fos.write(ei);
        fos.write(t);
        fos.close();
        System.out.println("Listo...");

    }
}