package JUEGO.Personajes;

import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrearPersonaje {
    public static Personaje Seleccionar() {

        Personaje p = null;
        int opcion;
        boolean vali = true;
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

        int eleccion = 0;
        while (vali) {
            try {
                System.out.print("Por favor, ingresa un número (1, 2, 3): ");
                eleccion = scanner.nextInt();

                if (eleccion >= 1 && eleccion <= 3) {
                    vali = false; // Salir del bucle si el número es válido
                } else {
                    System.out.println("❌ Solo se pueden ingresar números entre 1 y 3. Vuelve a intentarlo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada no válida. Por favor, ingresa un número.");
                scanner.nextLine(); // Limpia el buffer
            }
        }

        switch (eleccion) {
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
        }
        return p;
    }
}
