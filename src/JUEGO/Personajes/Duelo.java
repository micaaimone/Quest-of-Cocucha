package JUEGO.Personajes;

import JUEGO.Personajes.Enemigos.Enemigo;

import java.util.Scanner;

public class Duelo {
    private int decision;
    private int turnos;

    public void combate(Enemigo enemigo, Personaje personaje) {
        Scanner sc = new Scanner(System.in);
        while (enemigo.getPH()<= 0 || personaje.getPH()<= 0) {
            System.out.println("Cual es tu proximo movimiento?");
            System.out.println("1. Atacar \n 2. Curarse");

            decision = sc.nextInt();

            switch (decision){
                case 1:
                    personaje.atacar(enemigo);
                    break;

                    case 2:
                        personaje.curarse();
                    break;
                    default:
                        break;
            }
            turnos++;
        }
    }
}
