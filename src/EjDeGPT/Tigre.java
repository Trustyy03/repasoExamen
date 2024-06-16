package EjDeGPT;

public class Tigre extends Mamifero {

    public Tigre(boolean vivo, boolean recienNacido) {
        super(vivo, recienNacido);
    }

    @Override
    public boolean estaVivo() {
        return vivo;
    }

    @Override
    public boolean recienNacido() {
        return recienNacido;
    }

    public void rugir() {
        System.out.println("ROOOARRR");
    }
}
