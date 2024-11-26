package JUEGO.Personajes;

import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;

import java.util.Scanner;

public class CrearPersonaje {
    public static Personaje Seleccionar(){

        Personaje p = null;
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("       🎮 * Seleccione un personaje * 🎮         ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("\n1- Guerrero");
        System.out.println("   ⚔️ Un experto en combate cuerpo a cuerpo. Su fuerza es inigualable, ideal para enfrentar enemigos de frente.");
        System.out.println("\n2- Mago");
        System.out.println("   🔮 Un maestro de las artes arcanas. Su poder mágico es capaz de destruir a los enemigos desde la distancia.");
        System.out.println("\n3- Asesino");
        System.out.println("   🖤 Sigiloso y letal. Especialista en eliminar a sus enemigos rápidamente y en las sombras, antes de que puedan reaccionar.");
        System.out.println("══════════════════════════════════════════════════");
        System.out.printf("Escriba el numero y comience su historia: ");
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
                System.out.println("\u001B[31m══════════════════════════════════════════════════");
                System.out.println("       ⚠️ * Error de Opción * ⚠️                   ");
                System.out.println("══════════════════════════════════════════════════");
                System.out.println("   ❌ No ingresó una opción correcta.");
                System.out.println("══════════════════════════════════════════════════");

                break;
        }

        return p;

    }
}
