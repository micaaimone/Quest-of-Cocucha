package JUEGO;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class ControlPantalla {

    //metodo para limpiar pantalla
    public static class LimpiarPantalla {
        public static void main(String[] args) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Pantalla limpia!");
        }
    }

    //metodo para pausar unos segundos
    public static class Pausa {
        public static void main(String[] args) throws InterruptedException {
            System.out.println("Esperando 3 segundos...");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("¡Continuamos!");
        }
    }

    //metodo para pausar hasta enter
    public class PausaConEnter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        }
    }
}
