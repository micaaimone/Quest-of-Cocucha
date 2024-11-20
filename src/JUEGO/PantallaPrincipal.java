package JUEGO;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Exceptions.EntradaInvalidaException;
import JUEGO.Personajes.Personaje;
import JUEGO.Tienda.Tienda;

import java.util.Scanner;

//DSPS borrar corroborar excepcion
public class PantallaPrincipal {
    public void menu() throws CorroborarException, EntradaInvalidaException {

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
                Personaje p = crearPersonaje.Seleccionar();

                //probando creo q deberiamos de hacer q seleccionar devuelva el personaje
                //y ese personaje mandarlo a GestionNiverl.crearNivel con el personaje como parametro
                //mientras hago esto para probar

//                System.out.println("Mostrar info del personaje-----\n");
//                p.mostrarInfo();
//                System.out.println("seteo un atributo un poco mas para poder verificar q funcione bn curar");
//                p.setResistenciaMax(p.getResistenciaMax() + 10);
//                p.curarAtributo("resistencia", 15);
                Tienda tienda = new Tienda();

                p.setMonedas(p.getMonedas() + 100);
                p.setResistencia(p.getResistencia() - 5);
                p.mostrarInfo();
                tienda.menuTienda(p);
                //tengo q seguir probando, algo andaba mal en validacion
                //tmbn ver precios d armas, poner ordenadas cual ya tiene, capaz agregar algun atributo para eso
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
