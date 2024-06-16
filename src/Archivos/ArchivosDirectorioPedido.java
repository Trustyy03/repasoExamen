package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArchivosDirectorioPedido {

    public static void main(String[] args) throws IOException {

        //Colores
        String blue = "\u001B[34m";
        String reset = "\u001B[0m";

        File f = new File(".");

        for (File a : f.listFiles()){
            imprimirFichero(a);
        }
    }

    private static void imprimirFichero(File e) {
        if (!e.isHidden()) {
            if (e.isFile()) {
                System.out.println(e.getName() + " " + e.length());
            }
            if (e.isDirectory()){
                System.out.println(e.getName() + " <Directorio>");
            }
        }
    }
}
