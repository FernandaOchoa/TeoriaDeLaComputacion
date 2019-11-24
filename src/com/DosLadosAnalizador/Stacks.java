package com.DosLadosAnalizador;

import com.DosLadosAnalizador.files.LeerArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stacks {

    //objeto instanciado de clase para leer archivo
    LeerArchivo l = new LeerArchivo();
    ArrayList<String> temp;
    ArrayList<String> palabras;
    ArrayList<String> words;
    String[] scnd, thrd, frth;
    String blank = " ";
    Scanner leer;

    Stacks() throws IOException {
        leer = new Scanner(System.in);
        l.readFile();//se llama el metodo leer archivo
        scnd = new String[22];
        thrd = new String[13];
        thirdStack(l.arreProd);
        fourStack(l.arreProd);
        menu();
    }

    public void secondStack(String[] arreglo) {
        String signo = "-";
        for (int i = 0; i < arreglo.length; i++) {
            String cad = null;
            String cadena;
            int index = arreglo[i].indexOf(signo);
            cadena = arreglo[i];
            cad = arreglo[i].substring((index + 2)).trim();
            scnd[i] = cad;
        }
    }

    //Para no terminales
    public void thirdStack(String[] arreglo) {
        String signo = "->";//signo final para delimitar la cadena
        String punto = ".";//signo inicial para delimitar la cadena
        boolean band;
        temp = new ArrayList<String>();

        //ciclo para recorrer el arreglo
        for (String s : arreglo) {
            String cad = null;//cadena deonde se guarda parte izq de produccion
            //indice(num) de donde se encuentra el signo no terminal
            int index = s.indexOf(punto);
            //inddice final de donde se encuentra el lado izquierdo
            int fin = s.lastIndexOf(signo);
            //for para guuardar las palabras y los lados izquierdo, al mismo tiempo
            //se guarda el lado izquierdo de la produccion
            cad = s.substring((index + 1), fin).trim();
            band = temp.contains(cad);
            if (!band)
                temp.add(cad);
        }
        for (int j = 0; j < temp.size(); j++) thrd[j] = temp.get(j);
    }

    //para terminales
    private void fourStack(String[] arreglo) {
        //thirdStack(l.arreProd);
        temp = new ArrayList<String>();
        words = new ArrayList<String>();
        String signo = "->";
        boolean band = false;
        boolean b = true;
        //string para gguardar simbolos terminales y palabras a excluir
        String word = "", exclWord = "", cont;
        int start = 0, last = 0, elemento = 0;
        for (String s : arreglo) {
            String cad = null;
            String cadena = "";
            int index = s.indexOf(signo);
            cad = s.substring((index + 2));

            for (int k = 0; k < thrd.length - 1; k++) {
                cont = thrd[k];
                cad = cad.replaceAll(cont, " ");
                cad = cad.replace("   ", " ");
                split(' ', cad);
                temp.addAll(palabras);
            }
        }
        String t = "<primary><primary_tail>", ar;
        for (String s : thrd) {
            for (int h = 0; temp.size() > h; h++) {
                ar = temp.get(h);
                temp.remove(s);
                temp.remove(t);
                temp.remove("null");
                temp.remove("");
                if (!words.contains(ar))
                    words.add(ar);
                words.remove(s);
                words.remove("");
            }
        }
        frth = new String[words.size()];
        for (int v = 0; v < words.size(); v++) {
            frth[v] = words.get(v);
        }
    }

    private void split(char delimeter, String line) {
        StringBuilder word = new StringBuilder();
        ArrayList<String> wordsArr = new ArrayList<>();

        int k = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != delimeter) {
                word.append(line.charAt(i));
            } else {
                wordsArr.add(word.toString());
                word = new StringBuilder();
                k++;
            }
        }
        wordsArr.add(word.toString());
        palabras = new ArrayList<>();
        palabras.addAll(wordsArr);
    }

    private void imprimir(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Elemento " + i + ": " + a[i]);
        }
    }

    private void menu() {
        System.out.println("Ver arreglo\n"
                + "1) Producciones\n"
                + "2) no terminales\n"
                + "3) terminales\n"
                + "4) lados derechos");
        int opc = leer.nextInt();

        switch (opc) {
            case 1:
                for (int i = 0; i < l.arreProd.length; i++)
                    System.out.println(l.arreProd[i]);
                break;
            case 2:
                System.out.println("leng: " + thrd.length);
                imprimir(thrd);
                break;
            case 3:
                imprimir(frth);
                break;
            case 4:
                secondStack(l.arreProd);
                imprimir(scnd);
                break;

        }
    }
}
