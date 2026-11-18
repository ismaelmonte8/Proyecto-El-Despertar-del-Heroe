package src;

public class Ranking {
    private String[] nombres = new String[10];
    private int[] puntos = new int[10];
    private int cantidad = 0;

    public void añadirJugador(String nombre, int puntuacion) {

        if (cantidad == 10 && puntuacion <= puntos[9]) {
            System.out.println("No has conseguido entrar en el ranking.");
            return;
        }

        int posicion = 0;

        while (posicion < cantidad && puntuacion <= puntos[posicion]) {
            posicion++;
        }

        if (cantidad < 10) {
            cantidad++;
        }

        for (int i = cantidad - 1; i > posicion; i--) {
            nombres[i] = nombres[i - 1];
            puntos[i] = puntos[i - 1];
        }

        nombres[posicion] = nombre;
        puntos[posicion] = puntuacion;

        System.out.println("Jugador añadido al ranking.");
    }

    public void mostrarRanking() {

        System.out.println("\n============================");
        System.out.println("       RANKING DE HEROES");
        System.out.println("============================");

        if (cantidad == 0) {
            System.out.println("Todavia no hay jugadores en el ranking.");
        } else {

            for (int i = 0; i < cantidad; i++) {
                System.out.println((i + 1) + ". " + nombres[i] + " - " + puntos[i] + " puntos");
            }
        }

        System.out.println("============================");
    }
}
