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
            System.out.println("¿Cuál es tu próximo movimiento?");
            System.out.println("1. 🗡️ Atacar");
            System.out.println("2. 💊 Curarse");
            System.out.println("\nSelecciona tu acción (1 o 2):");


            try {
                decision = sc.nextInt();
                sc.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("\u001B[31m❌ Error: ingrese solo números ❌\u001B[0m");
            }

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

        if (enemigo.getPH() <= 0) {
            return true;
        } else {
            return false;
        }

    }
}
