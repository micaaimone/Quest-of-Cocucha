package JUEGO;

import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;

import java.util.Scanner;

public class CrearPersonaje {
    public void Seleccionar(){
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione un personaje, elija el nro\n");
        System.out.println("\n1-Guerrero\n");
        //aca va la desc del guerrero
        System.out.println("\n2-Mago\n");
        //aca va la desc del mago
        System.out.println("\nAsesino\n");
        //aca va la desc del asesino
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1:
                Guerrero guerrero = new Guerrero();
                break;
            case 2:
                Mago mago = new Mago();
                break;
            case 3:
                Asesino asesino = new Asesino();
                break;
            default:
                System.out.println("No ingreso una opcion correcta");
                break;
        }


    }
}
