package EjDeGPT;

public abstract class Mamifero implements Animal {
    boolean vivo;
    boolean recienNacido;
    protected Mamifero(boolean vivo, boolean recienNacido){
        this.vivo = vivo;
        this.recienNacido = recienNacido;
    }
}
