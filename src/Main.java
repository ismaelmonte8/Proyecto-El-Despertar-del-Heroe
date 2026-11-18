package src;

import java.util.Scanner;

public class Main {

    int vida = 100;

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

            limpiarPantalla();
            System.out.println("\n===== ELIGE TU PERSONAJE =====");
            System.out.println("1. Mago");
            System.out.println("2. Heroe");
            System.out.println("3. Arquero");

            opcionPersonaje = leerOpcion(sc);

            if (opcionPersonaje < 1 || opcionPersonaje > 3) {
                System.out.println("Personaje no valido.");
            }

        } while (opcionPersonaje < 1 || opcionPersonaje > 3);

        Enemigo enemigo1 = new Enemigo("Goblin", 45, 10, 15);
        Enemigo enemigo2 = new Enemigo("Orco", 70, 15, 20);
        Enemigo enemigo3 = new Enemigo("Dragon Oscuro", 100, 15, 25);

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

        System.out.println("Tienes " + pociones + " pociones de vida.");
        System.out.println("1. Comenzar partida");
        System.out.println("2. Salir");

        int opcionContinuar = 0;
        opcionContinuar = leerOpcion(sc);

        while (opcionContinuar == 1) {

            if (opcionContinuar == 1) {
                limpiarPantalla();
                System.out.println("Comenzando partida...");

                EmpezarPartidaLore1(sc);
                if (opcionPersonaje == 1) {
                    System.out.println("Has elegido al Mago, un maestro de la magia con gran poder ofensivo.");
                } else if (opcionPersonaje == 2) {
                    System.out.println("Has elegido al Heroe, un valiente guerrero con gran resistencia.");
                } else if (opcionPersonaje == 3) {
                    System.out.println("Has elegido al Arquero, un experto en ataques a distancia y precisión.");
                }
                EmpezarPartidaLore2(sc);
                pausa(sc);

                InfoCombate(sc, personaje, enemigo1);

                while (enemigo1.getVida() > 0 && personaje.getVida() > 0) {
                    limpiarPantalla();
                    System.out.println("\n============================");
                    System.out.println("           COMBATE");
                    System.out.println("============================");
                    System.out.println("Tu vida: " + personaje.getVida());
                    System.out.println("Vida del enemigo: " + enemigo1.getVida());

                    System.out.println("\nQue deseas hacer?");
                    System.out.println("1. Atacar");
                    System.out.println("2. Usar pocion de vida");
                    System.out.println("3. Consultar inventario");
                    System.out.println("4. Huir");

                    int opcionCombate = leerOpcion(sc);

                    switch (opcionCombate) {

                        case 1:
                            Atacar(sc, personaje, enemigo1);

                            limpiarPantalla();
                            if (enemigo1.getVida() > 0) {
                                AtacarEnemigo(personaje, enemigo1);
                                pausa(sc);
                            }

                            break;

                        case 2:
                            int pocionesAntes = pociones;

                            pociones = usarPocion(sc, personaje, pociones);

                            if (pociones < pocionesAntes && enemigo1.getVida() > 0) {
                                limpiarPantalla();
                                AtacarEnemigo(personaje, enemigo1);
                                pausa(sc);
                            }

                            break;

                        case 3:
                            limpiarPantalla();
                            System.out.println("===========================");
                            System.out.println(" Bienvenido al inventario.");
                            System.out.println("===========================");
                            System.out.println();
                            System.out.println("Nombre: " + personaje.getNombre());
                            System.out.println("Arma: " + personaje.getArma());
                            System.out.println("Te quedan " + pociones + " pociones de vida.");
                            pausa(sc);
                            break;

                        case 4:
                            System.out.println("Has decidido abandonar.");
                            return;

                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }
                }

                if (personaje.getVida() <= 0) {
                    mostrarDerrota(sc, enemigo1, puntos);
                    return;
                } else {
                    puntos = 20;
                    limpiarPantalla();
                    System.out.println("¡ENHORABUENA! Has derrotado al " + enemigo1.getNombre());
                    System.out.println("Has ganado 20 puntos.");
                    System.out.println("Puntos totales: " + puntos);
                }
                pausa(sc);
                limpiarPantalla();
                System.out.println("Ahora te enfrentaras a un enemigo mas fuerte: " + enemigo2.getNombre() + ".");
                pausa(sc);
                limpiarPantalla();
                InfoCombate(sc, personaje, enemigo2);

                while (enemigo2.getVida() > 0 && personaje.getVida() > 0) {
                    limpiarPantalla();
                    System.out.println("\n============================");
                    System.out.println("           COMBATE");
                    System.out.println("============================");
                    System.out.println("Tu vida: " + personaje.getVida());
                    System.out.println("Vida del enemigo: " + enemigo2.getVida());

                    System.out.println("\nQue deseas hacer?");
                    System.out.println("1. Atacar");
                    System.out.println("2. Usar pocion de vida");
                    System.out.println("3. Consultar inventario");
                    System.out.println("4. Huir");

                    int opcionCombate = leerOpcion(sc);

                    switch (opcionCombate) {

                        case 1:
                            Atacar(sc, personaje, enemigo2);

                            limpiarPantalla();
                            if (enemigo2.getVida() > 0) {
                                AtacarEnemigo(personaje, enemigo2);
                                pausa(sc);
                            }

                            break;

                        case 2:
                            int pocionesAntes = pociones;

                            pociones = usarPocion(sc, personaje, pociones);

                            if (pociones < pocionesAntes && enemigo2.getVida() > 0) {
                                limpiarPantalla();
                                AtacarEnemigo(personaje, enemigo2);
                                pausa(sc);
                            }

                            break;

                        case 3:
                            limpiarPantalla();
                            System.out.println("===========================");
                            System.out.println(" Bienvenido al inventario.");
                            System.out.println("===========================");
                            System.out.println();
                            System.out.println("Nombre: " + personaje.getNombre());
                            System.out.println("Arma: " + personaje.getArma());
                            System.out.println("Te quedan " + pociones + " pociones de vida.");
                            pausa(sc);
                            break;

                        case 4:
                            System.out.println("Has decidido abandonar.");
                            return;

                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }
                }

                if (personaje.getVida() <= 0) {
                    mostrarDerrota(sc, enemigo2, puntos);
                    return;
                } else {
                    puntos = 50;
                    limpiarPantalla();
                    System.out.println("¡ENHORABUENA! Has derrotado al " + enemigo2.getNombre());
                    System.out.println("Has ganado 30 puntos.");
                    System.out.println("Puntos totales: " + puntos);
                }
                pausa(sc);
                limpiarPantalla();
                System.out.println("Ahora te enfrentaras a un enemigo mas fuerte: " + enemigo3.getNombre() + ".");
                pausa(sc);
                limpiarPantalla();
                InfoCombate(sc, personaje, enemigo3);

                while (enemigo3.getVida() > 0 && personaje.getVida() > 0) {
                    limpiarPantalla();
                    System.out.println("\n============================");
                    System.out.println("           COMBATE");
                    System.out.println("============================");
                    System.out.println("Tu vida: " + personaje.getVida());
                    System.out.println("Vida del enemigo: " + enemigo3.getVida());

                    System.out.println("\nQue deseas hacer?");
                    System.out.println("1. Atacar");
                    System.out.println("2. Usar pocion de vida");
                    System.out.println("3. Consultar inventario");
                    System.out.println("4. Huir");

                    int opcionCombate = leerOpcion(sc);

                    switch (opcionCombate) {

                        case 1:
                            Atacar(sc, personaje, enemigo3);

                            limpiarPantalla();
                            if (enemigo3.getVida() > 0) {
                                AtacarEnemigo(personaje, enemigo3);
                                pausa(sc);
                            }

                            break;

                        case 2:
                            int pocionesAntes = pociones;

                            pociones = usarPocion(sc, personaje, pociones);

                            if (pociones < pocionesAntes && enemigo3.getVida() > 0) {
                                limpiarPantalla();
                                AtacarEnemigo(personaje, enemigo3);
                                pausa(sc);
                            }

                            break;

                        case 3:
                            limpiarPantalla();
                            System.out.println("===========================");
                            System.out.println(" Bienvenido al inventario.");
                            System.out.println("===========================");
                            System.out.println();
                            System.out.println("Nombre: " + personaje.getNombre());
                            System.out.println("Arma: " + personaje.getArma());
                            System.out.println("Te quedan " + pociones + " pociones de vida.");
                            pausa(sc);
                            break;

                        case 4:
                            System.out.println("Has decidido abandonar.");
                            return;

                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }
                }

                pausa(sc);
                if (personaje.getVida() <= 0) {
                    mostrarDerrota(sc, enemigo3, puntos);
                    return;
                } else {
                    puntos = 100;
                    limpiarPantalla();
                    System.out.println("¡ENHORABUENA! Has derrotado al " + enemigo3.getNombre());
                    System.out.println("Has ganado 50 puntos.");
                    System.out.println("Puntos totales: " + puntos);
                    pausa(sc);
                    limpiarPantalla();
                    System.out.println();
                    System.out.println("============================");
                    System.out.println("       VICTORIA FINAL");
                    System.out.println("============================");
                    System.out.println("Has salvado el reino de Eldoria.");
                    System.out.println("¡Enhorabuena por completar la aventura!");

                    pausa(sc);
                }

            } else {

                System.out.println("Opción no válida. Por favor, selecciona 1 o 2.");
                opcionContinuar = sc.nextInt();
            }

            opcionContinuar++;
        }

    }

    public static void pausa(Scanner sc) {
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();

    }

    public static void EmpezarPartidaLore1(Scanner sc) {

        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();
        limpiarPantalla();
        System.out.println("========================================");
        System.out.println("        EL DESPERTAR DEL HEROE");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Hace muchos años, el reino de Eldoria vivia en paz,");
        System.out.println("hasta que una misteriosa oscuridad comenzo a extenderse");
        System.out.println("por sus tierras.");
        System.out.println("Criaturas malignas aparecieron, los pueblos fueron");
        System.out.println("abandonados y nadie consiguio detener la amenaza.");
        System.out.println();
        System.out.println("Una antigua profecia cuenta que un guerrero elegido");
        System.out.println("sera capaz de devolver la paz al reino.");
        System.out.println("Sin embargo, antes debera superar tres peligrosos");
        System.out.println("encuentros y demostrar su verdadero valor.");
        System.out.println("Podias elegir entre tres personajes: Mago, Heroe o Arquero.");
        System.out.println();
    }

    public static void EmpezarPartidaLore2(Scanner sc) {
        System.out.println();
        System.out.println("Tu aventura comienza ahora...");
        System.out.println();
        System.out.println("Tres enemigos. Una ultima oportunidad.");
        System.out.println("El destino de Eldoria esta en tus manos.");
        System.out.println();
        System.out.println("Consigue 100 puntos y alzate con tu victoria!");
        System.out.println("========================================");

    }

    public static void InfoCombate(Scanner sc, Personaje personaje, Enemigo enemigo) {
        limpiarPantalla();
        System.out.println("\n============================");
        System.out.println("           COMBATE");
        System.out.println("============================");
        System.out.println("Un " + enemigo.getNombre() + " aparece en tu camino.");
        System.out.println("Vida del enemigo: " + enemigo.getVida());
        System.out.println("Tu vida: " + personaje.getVida());

        pausa(sc);
    }

    public static void Atacar(Scanner sc, Personaje personaje, Enemigo enemigo) {

        int probabilidad = (int) (Math.random() * 100) + 1;

        if (probabilidad <= 30) {
            limpiarPantalla();
            System.out.println("Has fallado tu ataque.");
            pausa(sc);
        } else {

            int daño = (int) (Math.random() * (personaje.getDañoMaximo() - personaje.getDañoMinimo() + 1))
                    + personaje.getDañoMinimo();

            int vidaRestante = enemigo.getVida() - daño;

            if (vidaRestante < 0) {
                vidaRestante = 0;
            }

            enemigo.setVida(vidaRestante);
            limpiarPantalla();
            System.out.println("\nHas atacado con tu " + personaje.getArma());
            System.out.println("Has causado " + daño + " puntos de daño.");
            System.out.println("Vida restante de " + enemigo.getNombre() + ": " + enemigo.getVida());

            pausa(sc);

        }
    }

    public static void AtacarEnemigo(Personaje personaje, Enemigo enemigo) {

        int probabilidad = (int) (Math.random() * 100) + 1;

        if (probabilidad <= 30) {
            System.out.println("El " + enemigo.getNombre() + " ha fallado su ataque.");
        } else {

            int daño = (int) (Math.random() * (enemigo.getDañoMaximo() - enemigo.getDañoMinimo() + 1))
                    + enemigo.getDañoMinimo();

            int vidaRestante = personaje.getVida() - daño;

            if (vidaRestante < 0) {
                vidaRestante = 0;
            }

            personaje.setVida(vidaRestante);

            System.out.println("El " + enemigo.getNombre() + " te ha atacado.");
            System.out.println("Has recibido " + daño + " puntos de daño.");
            System.out.println("Tu vida restante: " + personaje.getVida());
        }
    }

    public static int usarPocion(Scanner sc, Personaje personaje, int pociones) {
        limpiarPantalla();
        if (pociones <= 0) {
            System.out.println("No te quedan pociones.");
        } else {

            int vidaMaxima = 100;

            if (personaje.getNombre().equals("Mago")) {
                vidaMaxima = 75;
            }

            if (personaje.getNombre().equals("Arquero")) {
                vidaMaxima = 85;
            }

            if (personaje.getVida() >= vidaMaxima) {
                System.out.println("Ya tienes la vida al maximo.");
            } else {

                int nuevaVida = personaje.getVida() + 25;

                if (nuevaVida > vidaMaxima) {
                    nuevaVida = vidaMaxima;
                }

                personaje.setVida(nuevaVida);
                pociones--;

                System.out.println("Has utilizado una pocion de vida.");
                System.out.println("Tu vida ahora es: " + personaje.getVida());
                System.out.println("Pociones restantes: " + pociones);
            }
        }

        pausa(sc);
        return pociones;
    }

    public static void mostrarDerrota(Scanner sc, Enemigo enemigo, int puntos) {

        limpiarPantalla();

        int opcionDerrota;

        do {
            limpiarPantalla();

            System.out.println("============================");
            System.out.println("           DERROTA");
            System.out.println("============================");
            System.out.println("Has sido derrotado por " + enemigo.getNombre());
            System.out.println("Puntos obtenidos: " + puntos);
            System.out.println();
            System.out.println("1. Volver al menu principal");

            opcionDerrota = leerOpcion(sc);

            if (opcionDerrota != 1) {
                System.out.println("Opcion no valida. Introduce 1.");
                pausa(sc);
            }

        } while (opcionDerrota != 1);
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
        Ranking ranking = new Ranking();

        ranking.añadirJugador("Carlos", 300);
        ranking.añadirJugador("Lucia", 280);
        ranking.añadirJugador("Pedro", 250);
        ranking.añadirJugador("Marcos", 220);
        ranking.añadirJugador("Ana", 200);
        ranking.añadirJugador("David", 180);
        ranking.añadirJugador("Marta", 150);
        ranking.añadirJugador("Pablo", 120);
        ranking.añadirJugador("Sergio", 100);
        ranking.añadirJugador("Juan", 80);

        ranking.añadirJugador("Luis", 190);
        ranking.añadirJugador("Alberto", 50);

        ranking.mostrarRanking();

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);
            ejecutarOpcion(sc, opcion, ranking);

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

    public static void ejecutarOpcion(Scanner sc, int opcion, Ranking ranking) {

        switch (opcion) {

            case 1:
                iniciarPartida(sc);
                break;

            case 2:
                limpiarPantalla();
                ranking.mostrarRanking();
                pausa(sc);
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
