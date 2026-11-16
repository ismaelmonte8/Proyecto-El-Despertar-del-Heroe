package src;

public class Enemigo {

    private String nombre;
    private int vida;
    private int dañoMinimo;
    private int dañoMaximo;

    // Constructor
    public Enemigo(String nombre, int vida, int dañoMinimo, int dañoMaximo) {
        this.nombre = nombre;
        this.vida = vida;
        this.dañoMinimo = dañoMinimo;
        this.dañoMaximo = dañoMaximo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDañoMinimo() {
        return dañoMinimo;
    }

    public void setDañoMinimo(int dañoMinimo) {
        this.dañoMinimo = dañoMinimo;
    }

    public int getDañoMaximo() {
        return dañoMaximo;
    }

    public void setDañoMaximo(int dañoMaximo) {
        this.dañoMaximo = dañoMaximo;
    }
}
