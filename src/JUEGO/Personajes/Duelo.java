package JUEGO.Personajes;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Enemigos.Enemigo;

import java.util.Scanner;

public class Duelo {
    private static int decision;
    private static int turnos;

    public static Boolean combate(Enemigo enemigo, Personaje personaje) {
        Scanner sc = new Scanner(System.in);
        while (enemigo.getPH()<= 0 || personaje.getPH()<= 0) {
            System.out.println("Cual es tu proximo movimiento?");
            System.out.println("1. Atacar \n 2. Curarse");

            try {
                decision = sc.nextInt();
                sc.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Error: ingrese solo numeros");
            }


            switch (decision){

                case 1:
                    try {
                        personaje.atacar(enemigo);
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

            enemigo.atacar(personaje);
            turnos++;
        }
        if (enemigo.getPH()<= 0){
            return true;
        }else{
            return false;
        }
    }
}
