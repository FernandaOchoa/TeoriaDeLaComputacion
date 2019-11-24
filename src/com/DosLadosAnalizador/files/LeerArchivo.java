package com.DosLadosAnalizador.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivo {
    //se asigna a esta variable el archivo que queremos abri
    File archivo = new File("C:\\gramatica.txt");
    Scanner s = null;
    int nProd;//se lee la cantidad de lineas que tiene el archivo
    public String [] arreProd;  //arreglo para guardar las producciones(estructura estatica)

    public void readFile() throws IOException{
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        //System.out.println("El fichero tiene " + br.lines().count() + " lineas");
        nProd = (int)br.lines().count();//se lee la cantidad de lineas del archivo
        //System.out.println(nProd);
        br.close();//cierra el archivo
        //se crea la estructura estatica con la cantidad de lineas del archivo
        arreProd = new String[nProd];
        //System.out.println("length"+arreProd.length);
        s = new Scanner(archivo);
        int i=0;
        while(s.hasNext()){
            //se guarda la linea leida del archivo en "linea"
            String linea = s.nextLine();
            //System.out.println(linea);
            //se guarda cada linea del archivo en cada posicion de arreglo
            arreProd[i]=linea;
            //se incrementa la variable controladora del arreglo
            i++;
        }
        //cuando s no tiene nada se termino el archivo y se cierra
        if (s!=null)
            s.close();
    }
}
