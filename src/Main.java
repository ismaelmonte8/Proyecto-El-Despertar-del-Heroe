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
    
    int vida = 100;
    int pociones = 3;
    int puntos = 0;

    limpiarPantalla();

    System.out.println("================================");
    System.out.println("   BIENVENIDO, " + nombre);
    System.out.println("================================");
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
