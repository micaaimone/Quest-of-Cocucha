package JUEGO;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Exceptions.EntradaInvalidaException;
import JUEGO.JSON.GestionJSON;
import JUEGO.Jugador.GestionJugador;
import JUEGO.Jugador.Jugador;
import JUEGO.Nivel.GestionNivel;
import JUEGO.Personajes.CrearPersonaje;
import JUEGO.Personajes.Personaje;
import JUEGO.Tienda.Tienda;

import java.util.InputMismatchException;
import java.util.Scanner;

//DSPS borrar corroborar excepcion
public class PantallaPrincipal {
    public void menu() throws EntradaInvalidaException {
        int opcion = 0;
        GestionJugador jugadores = new GestionJugador(); // mapa de jugadores para mostrar puntuacion
        while (opcion != 3) {

            System.out.printf(" " +
                    ".--..--..--..--..--..--..--..--..--..--..--..--..--..--..--. \n" +
                    "/ .. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\\n" +
                    "\\ \\/\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ \\/ /\n" +
                    " \\/ /`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\\/ / \n" +
                    " / /\\                                                    / /\\ \n" +
                    "/ /\\ \\       ___                  _      ___   __       / /\\ \\\n" +
                    "\\ \\/ /      / _ \\ _   _  ___  ___| |_   / _ \\ / _|      \\ \\/ /\n" +
                    " \\/ /      | | | | | | |/ _ \\/ __| __| | | | | |_        \\/ / \n" +
                    " / /\\      | |_| | |_| |  __/\\__ \\ |_  | |_| |  _|       / /\\ \n" +
                    "/ /\\ \\      \\__\\_\\\\__,_|\\___||___/\\__| _\\___/|_|        / /\\ \\\n" +
                    "\\ \\/ /      / ___|___   ___ _   _  ___| |__   __ _      \\ \\/ /\n" +
                    " \\/ /      | |   / _ \\ / __| | | |/ __| '_ \\ / _` |      \\/ / \n" +
                    " / /\\      | |__| (_) | (__| |_| | (__| | | | (_| |      / /\\ \n" +
                    "/ /\\ \\      \\____\\___/ \\___|\\__,_|\\___|_| |_|\\__,_|     / /\\ \\\n" +
                    "\\ \\/ /                                                  \\ \\/ /\n" +
                    " \\/ /                                                    \\/ / \n" +
                    " / /\\.--..--..--..--..--..--..--..--..--..--..--..--..--./ /\\ \n" +
                    "/ /\\ \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\/\\ \\\n" +
                    "\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `' /\n" +
                    " `--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--' ");

            //estos serian botones, si apreto boton jugar llevaria a pantalla principal
            //si apreto pantalla puntuacion, muestra las puntuaciones mas altas
            //si apreto salir, se sale del juego

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nElija una opcion \n ");
            System.out.println("1-Jugar\n");
            System.out.println("2-Puntuacion\n");
            System.out.println("3-Salir\n");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        // llamamos a funcion para crear el jugador

                        //hacer try catch hasta new jugador, sino salta error si se ingresa un nro incorrecto o letra
                        System.out.println("Ingrese su nombre\n");
                        String nombreJugador = scanner.nextLine();
                        Jugador jugador = new Jugador(nombreJugador);
                        ControlPantalla.limpiarPantalla();
                        System.out.println("Bienvenido " + nombreJugador);
                        System.out.println("Haz elegido el personaje: " + jugador.getPersonaje().getClass().getSimpleName());

                    // llevamos el jugador a recorrer el juego

                    GestionNivel juego = new GestionNivel(jugador.getPersonaje());
                    try {
                        juego.Trayecto();
                    } catch (CorroborarException e) {
                        System.out.println(e.getMessage());

                    }
                    jugador.setPuntuacion(juego.getPuntuacion());

                    jugadores.agregarJugador(jugador);

                        break;
                    case 2:
                        //llevaria a mostrar punt
                        System.out.println("estas son las 5 puntuaciones mas altas");
                        break;
                    case 3:
                        //sale
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("No ingresaste una opcion correcta \n");
                        break;
                }
            } catch (InputMismatchException ex){
                scanner.nextLine();
                System.out.println("Solo se pueden ingresar numeros(1,2,3). Vuelve a intentarlo");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // JSON ----------------
        //GestionJSON.jugadoraArchivo(jugadores);



    }
}
