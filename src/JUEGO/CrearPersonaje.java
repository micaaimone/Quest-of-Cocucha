package JUEGO;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;
import JUEGO.Personajes.Personaje;

import java.util.Scanner;

public class CrearPersonaje {
    public Personaje Seleccionar(){

        Personaje p = null;
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione un personaje, elija el nro\n");
        System.out.println("\n1-Guerrero\n");
        //aca va la desc del guerrero
        System.out.println("\n2-Mago\n");
        //aca va la desc del mago
        System.out.println("\n3-Asesino\n");
        //aca va la desc del asesino
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1:
                Guerrero guerrero = new Guerrero();
                p = guerrero;
                break;
            case 2:
                Mago mago = new Mago();
                p = mago;
                break;
            case 3:
                Asesino asesino = new Asesino();
                p = asesino;
                break;
            default:
                System.out.println("No ingreso una opcion correcta");
                break;
        }

        return p;

    }
}
