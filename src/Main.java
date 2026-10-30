package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n================================");
            System.out.println("     EL DESPERTAR DEL HEROE");
            System.out.println("================================");
            System.out.println("1. Nueva partida");
            System.out.println("2. Consultar ranking");
            System.out.println("3. Ayuda");
            System.out.println("4. Salir");
            System.out.print("\nSelecciona una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Debes introducir un numero.");
                sc.nextLine();
                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    System.out.println("Nueva partida seleccionada.");
                    break;

                case 2:
                    System.out.println("Ranking seleccionado.");
                    break;

                case 3:
                    System.out.println("Ayuda seleccionada.");
                    break;

                case 4:
                    System.out.println("Gracias por jugar. Hasta pronto.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}

