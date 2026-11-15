package src;

import java.util.Scanner;

public class Main {

    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void iniciarPartida(Scanner sc) {

        String nombre;

        do {
            System.out.print("Introduce tu nombre: ");
            nombre = sc.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
            }

        } while (nombre.isEmpty());
        int opcionPersonaje;
        Personaje personaje = null;

        do {
            System.out.println("\n===== ELIGE TU PERSONAJE =====");
            System.out.println("1. Mago");
            System.out.println("2. Heroe");
            System.out.println("3. Arquero");

            opcionPersonaje = leerOpcion(sc);

            if (opcionPersonaje < 1 || opcionPersonaje > 3) {
                System.out.println("Personaje no valido.");
            }

        } while (opcionPersonaje < 1 || opcionPersonaje > 3);

        if (opcionPersonaje == 1) {
            personaje = new Personaje("Mago", "Baston magico", 75, 15, 25);
        }

        if (opcionPersonaje == 2) {
            personaje = new Personaje("Heroe", "Espada", 100, 10, 20);
        }

        if (opcionPersonaje == 3) {
            personaje = new Personaje("Arquero", "Arco", 85, 12, 22);
        }
        int vida = personaje.getVida();
        int pociones = 3;
        int puntos = 0;

        limpiarPantalla();

        System.out.println("================================");
        System.out.println("   BIENVENIDO, " + nombre);
        System.out.println("================================");
        System.out.println("Personaje: " + personaje.getNombre());
        System.out.println("Arma: " + personaje.getArma());
        System.out.println("Vida: " + vida);
        System.out.println("Daño: " + personaje.getDañoMinimo() + " - " + personaje.getDañoMaximo());
    }

    public static void pausa(Scanner sc) {
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();

    }

    public static void mostrarAyuda(Scanner sc) {

        limpiarPantalla();
        System.out.println("\n========== AYUDA ==========");
        System.out.println("Bienvenido a El Despertar del Heroe.");
        System.out.println("Tu objetivo es superar tres encuentros.");
        System.out.println("Tendras que derrotar a los enemigos utilizando tus ataques y pociones.");

        System.out.println("Conseguiras puntos por cada enemigo derrotado y podras entrar en el ranking.");
        System.out.println("===========================");
        pausa(sc);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);
            ejecutarOpcion(sc, opcion);

        } while (opcion != 4);

        sc.close();
    }

    public static void mostrarMenu() {

        System.out.println("\n================================");
        System.out.println("     EL DESPERTAR DEL HEROE");
        System.out.println("================================");
        System.out.println("1. Nueva partida");
        System.out.println("2. Consultar ranking");
        System.out.println("3. Ayuda");
        System.out.println("4. Salir");

    }

    public static int leerOpcion(Scanner sc) {

        System.out.print("\nSelecciona una opcion: ");

        if (sc.hasNextInt()) {
            int opcion = sc.nextInt();
            sc.nextLine();
            return opcion;
        } else {
            System.out.println("Debes introducir un numero.");
            sc.nextLine();
            return 0;
        }
    }

    public static void ejecutarOpcion(Scanner sc, int opcion) {

        switch (opcion) {

            case 1:
                iniciarPartida(sc);
                break;

            case 2:
                System.out.println("Ranking seleccionado.");
                break;

            case 3:
                System.out.println("ENTRANDO EN AYUDA");
                mostrarAyuda(sc);
                System.out.println("SALIENDO DE AYUDA");
                limpiarPantalla();

                break;

            case 4:
                System.out.println("Gracias por jugar. Hasta pronto.");
                break;

            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }
}
