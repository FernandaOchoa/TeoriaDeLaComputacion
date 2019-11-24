package com.MinimizacionAutomatas.files;

import java.io.FileOutputStream;
import java.io.IOException;

public class GAutomatasFiles {
    public static void main(String[] args) throws IOException {
        createFile();
    }
    private static void createFile() throws IOException {
        //Defino la Maquina 1 de los ejercicios en un Archivo
        FileOutputStream fos = new FileOutputStream("C:\\maquinaE1.txt");
        String alfabeto = "{a,b}\n";
        String estados = "{A,B,C,D,E,F,G,H,I,J}\n";
        String estadoFinal = "{D,E,G}\n";
        String estadoInicial = "A\n";
        String transiciones = "{A,a,B},{A,b,C},{B,a,D},{B,b,E},{C,a,A},{C,b,B},{D,a,C},{D,b,F},{E,a,G},{E,b,H},{F,a,H}"+
                "{F,b,B},{G,a,I},{G,b,I},{H,a,J},{H,b,F},{I,a,H},{I,b,J},{J,a,G},{J,b,E}";

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
        System.out.println("Maquina 1 Lista...");

        //Defino la Maquina 2 de los ejercicios en un Archivo
        FileOutputStream fos2 = new FileOutputStream("C:\\maquinaE2.txt");
        String alfabeto2 = "{a,b}\n";
        String estados2 = "{A,B,C,D,E,F}\n";
        String estadoFinal2 = "{F}\n";
        String estadoInicial2 = "A\n";
        String transiciones2 = "{A,a,B},{A,b,C},{B,a,D},{B,b,E},{C,a,E},{C,b,D},{D,a,F},{D,b,E},{E,a,F},{E,b,D},{F,a,F}"+
                "{F,b,F}";

        byte a2[] = alfabeto2.getBytes();
        byte e2[] = estados2.getBytes();
        byte ef2[] = estadoFinal2.getBytes();
        byte ei2[] = estadoInicial2.getBytes();
        byte t2[] = transiciones2.getBytes();

        fos2.write(a2);
        fos2.write(e2);
        fos2.write(ef2);
        fos2.write(ei2);
        fos2.write(t2);
        fos2.close();
        System.out.println("Maquina 2 lista...");

        //Defino la Maquina 3 de los ejercicios en un Archivo
        FileOutputStream fos3 = new FileOutputStream("C:\\maquinaE3.txt");
        String alfabeto3 = "{0,1}\n";
        String estados3 = "{A,B,C,D,E,F}\n";
        String estadoFinal3 = "{F}\n";
        String estadoInicial3 = "A\n";
        String transiciones3 = "{A,0,B},{A,1,A},{B,0,A},{B,1,C},{C,0,D},{C,1,B},{D,0,D}"+
                "{D,1,A},{E,0,D},{E,1,F},{F,0,G},{F,1,E},{G,0,F},{G,1,G},{H,0,G},{H,I,D}";

        byte a3[] = alfabeto3.getBytes();
        byte e3[] = estados3.getBytes();
        byte ef3[] = estadoFinal3.getBytes();
        byte ei3[] = estadoInicial3.getBytes();
        byte t3[] = transiciones3.getBytes();

        fos3.write(a3);
        fos3.write(e3);
        fos3.write(ef3);
        fos3.write(ei3);
        fos3.write(t3);
        fos3.close();
        System.out.println("Maquina 3 lista...");

        //Defino la Maquina 4 de los ejercicios en un Archivo
        FileOutputStream fos4 = new FileOutputStream("C:\\maquinaE4.txt");
        String alfabeto4 = "{0,1}\n";
        String estados4 = "{A,B,C,D,E,F,G,H,I}\n";
        String estadoFinal4 = "{C,I,F}\n";
        String estadoInicial4 = "A\n";
        String transiciones4 = "{A,0,B},{A,1,E},{B,0,C},{B,1,F},{C,0,D},{C,1,H},{D,0,E},{D,1,H},{E,0,F}"+
                "{E,1,I},{F,0,G},{F,1,B},{G,0,H},{G,1,B},{H,0,I},{H,1,C},{I,0,A},{I,1,E}";
        byte a4[] = alfabeto4.getBytes();
        byte e4[] = estados4.getBytes();
        byte ef4[] = estadoFinal4.getBytes();
        byte ei4[] = estadoInicial4.getBytes();
        byte t4[] = transiciones4.getBytes();

        fos4.write(a4);
        fos4.write(e4);
        fos4.write(ef4);
        fos4.write(ei4);
        fos4.write(t4);
        fos4.close();
        System.out.println("Maquina 4 lista...");

    }
}
