package FichBinConFormato;

import FichBinConFormato.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*0. salir
* 1. cargar datos iniciales
* 2. mostrar datos
* 3. guardar datos.
* 4. borrar datos.
* 5. Incorporar datos de fichero.
* 6. Ordenar datos.
*/
public class ListaJugadores {

    static Scanner inputValue = new Scanner(System.in);
    static ArrayList<Jugador> jugadores = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        boolean fin = false;
        while (!fin) {
            menu();
            int valor = obtenerOpcion();
            if (valor != 0) {
                ejecutarOpcion(valor);
            } else {
                System.out.println("Seguro que quieres salir?(Y/n)");
                String respuesta = inputValue.nextLine();
                if (respuesta.equalsIgnoreCase("y") || respuesta.equalsIgnoreCase("yes") || respuesta.equalsIgnoreCase("ye")) {
                    fin = true;
                }
            }
        }
    }

    public static void menu(){
        System.out.println("0. Salir");
        System.out.println("1. Cargar datos iniciales");
        System.out.println("2. Mostrar datos");
        System.out.println("3. Guardar");
        System.out.println("4. Borrar datos");
        System.out.println("5. Incorporar datos de un fichero");
        System.out.println("6. Ordenar");
    }

    public static int obtenerOpcion(){
        Scanner inputValue = new Scanner(System.in);
        System.out.println("Dame una opción: ");
        return inputValue.nextInt();
    }

    public static void ejecutarOpcion(int opcion) throws IOException {
        switch(opcion){
            case 1:
                DatosIniciales();
                break;
            case 2:
                LeerDatos();
                break;
            case 3:
                GuardarDatos();
                break;
            case 4:
                BorrarDatos();
                break;
            case 5:
                CargarArchivo();
                break;
            case 6:
                algoritmoBurbuja();
                break;
            case 7:
                GuardarArchivo();
        }
    }

    private static void DatosIniciales() {
        jugadores.add(new Jugador(7,"Brasil", "Alisson", 1992, 193, "Liverpool"));
        jugadores.add(new Jugador(5,"Brasil", "Weverton", 1987, 189, "Palmeiras"));
        jugadores.add(new Jugador(5,"Brasil", "Ederson", 1993, 188, "Manchester City"));
        jugadores.add(new Jugador(5,"Brasil", "Danilo", 1991, 184, "Juventus"));
        jugadores.add(new Jugador(5,"Brasil", "Thiago Silva", 1984, 183, "Chelsea"));
        jugadores.add(new Jugador(5,"Brasil", "Marquinhos", 1994, 183, "PSG"));
        jugadores.add(new Jugador(5,"Brasil", "Alex Sandro", 1991, 180, "Juventus"));
        jugadores.add(new Jugador(5,"Brasil", "Dani Alves", 1983, 172, "UNAM"));
        jugadores.add(new Jugador(5,"Brasil", "Eder Militao", 1998, 186, "Real Madrid CF"));
        jugadores.add(new Jugador(5,"Brasil", "Alex Telles", 1992, 181, "Sevilla FC"));
        jugadores.add(new Jugador(5,"Brasil", "Bremer", 1997, 188, "Juventus"));
        jugadores.add(new Jugador(5,"Brasil", "Casemiro", 1992, 195, "Manchester United"));
        jugadores.add(new Jugador(5,"Brasil", "Lucas Paqueta", 1997, 180, "West Ham United"));
        jugadores.add(new Jugador(5,"Brasil", "Fred", 1993, 169, "Manchester United"));
        jugadores.add(new Jugador(5,"Brasil", "Fabinho", 1993, 188, "Liverpool"));
        jugadores.add(new Jugador(5,"Brasil", "Bruno Guimaraes", 1997, 182, "Newcastle United"));
        jugadores.add(new Jugador(5,"Brasil", "Everton Ribeiro", 1989, 174, "Flamengo"));
        jugadores.add(new Jugador(5,"Brasil", "Richarlison", 1997, 184, "Tottenham Hotspur"));
        jugadores.add(new Jugador(5,"Brasil", "Neymar Jr.", 1992, 175, "PSG"));
        jugadores.add(new Jugador(5,"Brasil", "Raphinha", 1996, 176, "FC Barcelona"));
        jugadores.add(new Jugador(5,"Brasil", "Gabriel Jesus", 1997, 175, "Arsenal"));
        jugadores.add(new Jugador(5,"Brasil", "Antony", 2000, 172, "Juventus"));
        jugadores.add(new Jugador(5,"Brasil", "Vinicius Junior", 2000, 176, "Real Madrid CF"));
        jugadores.add(new Jugador(5,"Brasil", "Rodrygo", 2001, 174, "Real Madrid CF"));
        jugadores.add(new Jugador(5,"Brasil", "Pedro", 1997, 185, "Flamengo"));
        jugadores.add(new Jugador(5,"Brasil", "Gabriel Martinelli", 2001, 178, "Arsenal"));
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("| He añadido los datos al ArrayList. |");
        System.out.println("--------------------------------------");
        System.out.println();

    }

    private static void LeerDatos() {

        if (!jugadores.isEmpty()) {
            System.out.println();
            for (Jugador jugadore : jugadores) {
                System.out.print(" Código Pais = " + jugadore.codPais + "  / ");
                System.out.print(" Pais = " + jugadore.nomPais + "  / ");
                System.out.print(" Nombre = " + jugadore.nomJugador + "  / ");
                System.out.print(" Año Nacimiento = " + jugadore.fechaNacimiento + "  / ");
                System.out.print(" Altura = " + jugadore.alturaJugador + "  / ");
                System.out.print(" Club = " + jugadore.clubJugador + "  / ");
                System.out.println();
            }
            System.out.println();
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("| El ArrayList está vacío: nada que mostrar. |");
            System.out.println("----------------------------------------------");
        }
    }

    public static void BorrarDatos() {

        if (!jugadores.isEmpty()) {
            jugadores.clear();
            System.out.println("------------------------------------------------------");
            System.out.println("| Se ha borrado el contenido del ArrayList con éxito |");
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("----------------------------------------------------");
            System.out.println("| El ArrayList está vacío: no hay nada que borrar. |");
            System.out.println("----------------------------------------------------");
        }
    }

    public static void GuardarDatos() throws IOException {
        try (DataOutputStream flujoSalida = new DataOutputStream(new FileOutputStream("jugadores.dat", true))) {
            // Utilizamos "true" como segundo parámetro para abrir el archivo en modo de apendizaje

            for (Jugador jugador : jugadores) {
                flujoSalida.writeInt(jugador.codPais);
                flujoSalida.writeUTF(jugador.nomPais);
                flujoSalida.writeUTF(jugador.nomJugador);
                flujoSalida.writeInt(jugador.fechaNacimiento);
                flujoSalida.writeFloat(jugador.alturaJugador);
                flujoSalida.writeUTF(jugador.clubJugador);
            }

            System.out.println("--------------------------" +
                    "| He guardado el archivo |" +
                    "--------------------------");
        }
    }

    public static String pedirArchivo() {

        Scanner inputValue = new Scanner(System.in);
        System.out.println("Dame la ruta de tu archivo: ");
        return inputValue.nextLine();
    }

    public static void CargarArchivo() throws IOException {

        String archivo = pedirArchivo();

        try {
            DataInputStream flujoEntrada = new DataInputStream(new FileInputStream(archivo));
            DataOutputStream flujoSalida = new DataOutputStream(new FileOutputStream("jugadores.dat"));

        while (flujoEntrada.available() > 0) {
            int codigoPais = flujoEntrada.readInt();
            flujoSalida.writeInt(codigoPais);
            String nombrePais = flujoEntrada.readUTF();
            flujoSalida.writeUTF(nombrePais);
            String nombreJugador = flujoEntrada.readUTF();
            flujoSalida.writeUTF(nombreJugador);
            int fechaNacimiento = flujoEntrada.readInt();
            flujoSalida.writeInt(fechaNacimiento);
            float alturaJugador = flujoEntrada.readFloat();
            flujoSalida.writeFloat(alturaJugador);
            String clubJugador = flujoEntrada.readUTF();
            flujoSalida.writeUTF(clubJugador);

            Jugador nuevoJugador = new Jugador(codigoPais, nombrePais, nombreJugador, fechaNacimiento, alturaJugador, clubJugador);

            // Añadimos el nuevo jugador a la lista
            jugadores.add(nuevoJugador);
        }}catch (FileNotFoundException e) {
            System.out.println("Ruta incorrecta, nada se ha cambiado");

        }
    }

    public static void algoritmoBurbuja() {
        int n = jugadores.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (jugadores.get(j).fechaNacimiento > jugadores.get(j + 1).fechaNacimiento) {
                    // Swap jugadores[j] y jugadores[j + 1]
                    Jugador temp = jugadores.get(j);
                    jugadores.set(j, jugadores.get(j + 1));
                    jugadores.set(j + 1, temp);
                }
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("| He ordenado los jugadores utilizando burbuja |");
        System.out.println("------------------------------------------------");
    }

    private static void GuardarArchivo() throws IOException {

        DataInputStream flujoEntrada = new DataInputStream(new FileInputStream(("jugadores.dat")));

        // Para finalizar la lectura utilizamos "available" que indica la cantidad de bytes pendientes de lectura.
        while (flujoEntrada.available()>0){

            jugadores.add(new Jugador(flujoEntrada.readInt(), flujoEntrada.readUTF(), flujoEntrada.readUTF(), flujoEntrada.readInt(), flujoEntrada.readFloat(), flujoEntrada.readUTF()));

        }
        System.out.println("      ");
        flujoEntrada.close();


    }

}
