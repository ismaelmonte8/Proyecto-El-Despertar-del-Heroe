package src;
public class Personaje {

    private String nombre;
    private String arma;
    private int vida;
    private int dañoMinimo;
    private int dañoMaximo;

    // Constructor
    public Personaje(String nombre, String arma, int vida, int dañoMinimo, int dañoMaximo) {
        this.nombre = nombre;
        this.arma = arma;
        this.vida = vida;
        this.dañoMinimo = dañoMinimo;
        this.dañoMaximo = dañoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public int getVida() {
        int vida = this.vida;
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