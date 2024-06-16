package Archivos;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Scanner;

public class GestionArchivosActuales {

    public static void main(String[] args) throws IOException {

        //Colores
        String blue = "\u001B[34m";
        String reset = "\u001B[0m";

        File f = new File(".");
        f = f.getCanonicalFile();
        while(true) {
            System.out.println(blue + "Lista de directorios:\n" +
                    "---------------------" + reset);
            imprimeDirectorio(f);
            System.out.println(blue + "-----------------------------------------------------\n" +
                    "Dame un directorio de la ruta actual (-1 para salir): \n" +
                    "-----------------------------------------------------" + reset);

            //Leer directorio en String
            Scanner inputValue = new Scanner(System.in);
            int ent = inputValue.nextInt();



            if (ent==0){
                // verificar q existe padre
                if (f.getParentFile()!=null) {
                    f = f.getParentFile();
                }else if (f.getParentFile()==null){
                    System.out.println(blue + "Ya no existe directorio padre." + reset);
                    break;
                }
            }else if (ent==-1){
                break;
            }else {
                if (f.isDirectory()) {
                    //verificar que es un directorio
                    f = f.listFiles()[ent - 1];
                }
            }
        }
    }

    private static void imprimeDirectorio(File f) {
        int i=1;
        //verificar que existe padre
        if (f.getParentFile()!=null)
            System.out.println("0.- <Directorio Padre>");
        for (File e : f.listFiles()) {

            if (e.isFile()) {
                System.out.println(i + ".-  " + permisos(e) + " " + fechaModificacion(e) + "\t" + e.getName());
                i++;
            }
            if (e.isDirectory()) {
                System.out.println(i + ".-  " + permisos(e) + " " + fechaModificacion(e) + "\t" + e.getName());
                i++;
            }
        }
    }
    private static String permisos(File f) {
        String[] permisos = {"-","-","-","-"};
        String salida="";

            if (f.isDirectory()){
                permisos[0] = "d";
            }
            if (f.canRead()){
                permisos[1] = "r";
            }
            if (f.canWrite()){
                permisos[2] = "w";
            }
            if (f.canExecute()){
                permisos[3] = "x";
            }
            for (String e:permisos){
                salida+=e;
            }
            return salida;
    }

    private static String fechaModificacion(File e) {

        DateFormat formatter;

        formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());

        return(String.format("%-15d", e.length()) + formatter.format(e.lastModified()));
    }

}



