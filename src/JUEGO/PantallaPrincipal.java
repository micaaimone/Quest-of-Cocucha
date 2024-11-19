package JUEGO;

import java.util.Scanner;

public class PantallaPrincipal {
    public void menu(){

        System.out.println("\nQuest of Cocucha\n");

        //estos serian botones, si apreto boton jugar llevaria a pantalla principal
        //si apreto pantalla puntuacion, muestra las puntuaciones mas altas
        //si apreto salir, se sale del juego
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija una opcion \n ");
        System.out.println("\n1-Jugar\n");
        System.out.println("\n2-Puntuacion\n");
        System.out.println("\n3-Salir\n");
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1:
                CrearPersonaje crearPersonaje = new CrearPersonaje();
                break;
            case 2:
                //llevaria a mostrar punt
                break;
            case 3:
                //sale
                break;
            default:
                System.out.println("No ingresaste una opcion correcta \n");
                break;
        }

    }
}
