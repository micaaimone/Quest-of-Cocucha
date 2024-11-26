package JUEGO;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class ControlPantalla {

    // Metodo para limpiar pantalla
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.flush();
    }

    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name");//Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Metodo para pausar unos segundos
    public static void pausa() throws InterruptedException {
        System.out.println("Esperando 3 segundos...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("¡Continuamos!");
    }

    // Metodo para pausar hasta que se presione Enter
    public static void pausaConEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
    }


}