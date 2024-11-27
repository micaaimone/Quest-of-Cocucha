package JUEGO.Personajes;

import JUEGO.ControlPantalla;
import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Enemigos.Enemigo;

import java.util.Scanner;

public class Duelo {
    private static int decision;
    private static int turnos;

    public static Boolean combate(Personaje enemigo, Personaje personaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println("⚔️💥 ¡El combate comienza! 💥⚔️");

        while (enemigo.getPH() > 0 && personaje.getPH()> 0) {

            int decision = validarEntradaParaCombate();

            if (personaje.getPH() <= 0) {
                personaje.muerte();
                ControlPantalla.pausaConEnter();
                break;
            }

            switch (decision){

                case 1:
                    try {
                        personaje.atacar(enemigo);
                        if (enemigo.getPH() <= 0) break;
                    }catch (CorroborarException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 2:
                        try {
                            personaje.curarse();
                        }catch (CorroborarException e){
                            System.out.println(e.getMessage());
                        }
                    break;
                    default:
                        break;
            }

            try {
                enemigo.atacar(personaje);
                System.out.println("Haz recibido un ataque del enemigo de: " + enemigo.getPoderAtaque());
                personaje.mostrarInfo();
            } catch (CorroborarException e) {
                System.out.println(e.getMessage());
            }
            turnos++;
        }
        if (personaje.getPH()<= 0) {
            return false;
        }else {
            return true;
        }
    }


    public static int validarEntradaParaCombate() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("¿Cuál es tu próximo movimiento?");
            System.out.println("1. 🗡️ Atacar");
            System.out.println("2. 💊 Curarse");
            System.out.println("\nSelecciona tu acción (1 o 2):");
            try {
                opcion = scanner.nextInt();
                if (opcion == 1 || opcion == 2) { // valida que sea 1 o 2
                    return opcion;
                } else {
                    System.out.println("Opción no válida. Solo puede ingresar 1 o 2.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Solo puede ingresar números.");
                scanner.nextLine();
            }
        }
    }
}
