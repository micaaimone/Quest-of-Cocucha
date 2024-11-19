package JUEGO.Tienda;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;
import JUEGO.Personajes.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    private int precio;
    private Pocion pocion;
    private Armas armas;


    public void mostrarPociones(){
        for (Pocion p: Pocion.values()){
            System.out.println(" Nombre de la pocion: " + p +
                                "Precio: " + p.getPrecio());
        }
    }

    public void mostrarArmas(){
        for (Armas a: Armas.values()){
            System.out.println("Nombre: " + a.name());
            System.out.println("Precio: " + a.getPrecio());
            System.out.println("Descripción: " + a.getDescripcion());
            System.out.println("----------------------");
        }
    }

    public void mostrarArmas(List<Armas> armas){
        for (Armas a: Armas.values()){
            System.out.println(" Nombre del arma: " + a +
                    "\n Descripcion: " + a.getDescripcion() +
                    "\n Precio: " + a.getPrecio());
        }
    }

    public void menuTienda(Personaje p){
        Scanner scanner = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("¿Que desea comprar? Ingrese el numero \n"
                            + "1- pociones \n");
        mostrarPociones();
        System.out.println("2- armas \n");
        mostrarArmas();

        while (true) {
            try {
                eleccion = scanner.nextInt();
                if (eleccion == 1 || eleccion == 2) {
                    break; // Si la opción es válida (1 o 2), salir del bucle
                } else {
                    System.out.println("Error: ingrese solo los números 1 o 2.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese solo numeros\n");
            } finally {
                scanner.nextLine();
            }
        }

        if (eleccion == 1){
            System.out.println("¿Que pocion desea comprar? Ingrese el nombre\n");
            mostrarPociones();

            String pocionElegida;
            pocionElegida = scanner.nextLine().toUpperCase();

            try {
                Pocion pocion = Pocion.valueOf(pocionElegida);
                System.out.println("Has seleccionado: " + pocion);

                //manda a subir el atributo
                p.curarAtributo(pocionElegida, 20);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Por favor, elige un atributo válido.\n");
            } catch (CorroborarException ex){
                System.out.println("Atributo al max\n");
            } catch (Exception exception){
                exception.printStackTrace();
            }
        } else if (eleccion == 2){
            System.out.println("¿Que arma desea comprar?\n");

            System.out.println("Tus opciones son: \n");
            //para poder mostrar unicamente las armas disponibles de cada personaje armamos
            // un metodo especifico que devuelva una lista de los mismos
            List<Armas> listaArmas = new ArrayList<>();
            if (p instanceof Asesino){
                listaArmas = obtenerArmasDelPersonaje(p);
                System.out.println("Detalle de las armas disponibles para el Asesino\n");
                mostrarArmas(listaArmas);
            } else if (p instanceof Mago){
                listaArmas = obtenerArmasDelPersonaje(p);
                System.out.println("Detalle de las armas disponibles para el Mago\n");
                mostrarArmas(listaArmas);
            } else if (p instanceof Guerrero){
                listaArmas = obtenerArmasDelPersonaje(p);
                System.out.println("Detalle de las armas disponibles para el Guerrero\n");
                mostrarArmas(listaArmas);
            }

        }

    }

    public List<Armas> obtenerArmasDelPersonaje(Personaje p){
        List<Armas> listaArmas = new ArrayList<>();
        String tipoPersonaje = p.getClass().getSimpleName();

        for (Armas arma : Armas.values()) {
            if (arma.getTipoPersonaje().equalsIgnoreCase(tipoPersonaje)) {
                listaArmas.add(arma);
            }
        }
        return listaArmas;
    }

}
