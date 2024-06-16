package FichBinConFormato;

public class Jugador {
    public int codPais;
    public String nomPais;
    public String nomJugador;
    public int fechaNacimiento;
    public float alturaJugador;
    public String clubJugador;


    public Jugador( int codPais, String nomPais,  String nomJugador, int fechaNacimiento, float alturaJugador, String clubJugador){
        this.codPais = codPais;
        this.nomPais = nomPais;
        this.nomJugador = nomJugador;
        this.fechaNacimiento = fechaNacimiento;
        this.alturaJugador = alturaJugador;
        this.clubJugador = clubJugador;
    }

}
