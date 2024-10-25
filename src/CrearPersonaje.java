import Personajes.Asesino;
import Personajes.Guerrero;
import Personajes.Mago;

import java.util.Scanner;

public class CrearPersonaje {
    public void Seleccionar(){
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione un personaje\n");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1:
                System.out.println("\nGuerrero\n");
                //aca va la desc
                Guerrero guerrero = new Guerrero();
                break;
            case 2:
                System.out.println("\nMago\n");
                //aca va la desc
                Mago mago = new Mago();
                break;
            case 3:
                System.out.println("\nAsesino\n");
                //aca va la desc
                Asesino asesino = new Asesino();
                break;
            default:
                System.out.println("No ingreso una opcion correcta");
                break;
        }


    }
}
