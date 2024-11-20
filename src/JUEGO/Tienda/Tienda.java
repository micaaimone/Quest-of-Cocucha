package JUEGO.Tienda;
import JUEGO.Exceptions.EntradaInvalidaException;
import JUEGO.Exceptions.CorroborarException;
import JUEGO.Armas.Armas;
import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;
import JUEGO.Personajes.Personaje;
import JUEGO.Valicaciones.ValidacionBooleans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static JUEGO.Valicaciones.ValidacionBooleans.validarBooleano;

public class Tienda {

    private int precio;
    private Pocion pocion;
    private Armas armas;

    public void mostrarPociones() {
        for (Pocion p : Pocion.values()) {
            System.out.println(" Nombre de la pocion: " + p +
                    "\nPrecio: " + p.getPrecio());
        }
    }

    public void mostrarArmas() {
        for (Armas a : Armas.values()) {
            System.out.println("Nombre: " + a.name());
            System.out.println("\nPrecio: " + a.getPrecio());
            System.out.println("\nDescripción: " + a.getDescripcion());
            System.out.println("----------------------");
        }
    }

    public void mostrarArma(Armas a) {

        System.out.println(" Nombre del arma: " + a +
                "\n Descripcion: " + a.getDescripcion() +
                "\n Precio: " + a.getPrecio());
    }

    public void menuTienda(Personaje p) throws EntradaInvalidaException {
        Scanner scanner = new Scanner(System.in);

        //mandamos a que se seleccione la opcion
        int eleccion = seleccionarOpcion();

        do{
            if (eleccion == 1) {

                System.out.println("\n-----Comprar pocion-----\n");
                //metodo especifico para comprar pocion
                comprarPocion(p, scanner);
                System.out.println("\n-----Saliendo de comprar pocion-----\n");

                //aca iria limpiar pantalla


                eleccion = seleccionarOpcion();

            } else if (eleccion == 2) {

                System.out.println("\n-----Mejorar arma-----\n");
                //para poder mostrar unicamente la mejora de arma de cada personaje armamos
                // un metodo especifico que devuelva una lista de los mismos
                List<Armas> listaArmas = new ArrayList<>();
                if (p instanceof Asesino) {
                    mejoraDeArma(p, scanner);
                } else if (p instanceof Mago) {
                    mejoraDeArma(p, scanner);
                } else if (p instanceof Guerrero) {
                    mejoraDeArma(p, scanner);
                }
                System.out.println("\n-----Saliendo de mejorar arma-----\n");

                //aca iria limpiar pantalla


                eleccion = seleccionarOpcion();
            } else if (eleccion == 3) {
                System.out.println("Gracias por visitar la tienda, vuelve pronto!\n");
            } else {
                // Validación extra (aunque seleccionarOpcion debería manejarlo)
                System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (eleccion != 3);


    }

    public int seleccionarOpcion() {
        Scanner scanner = new Scanner(System.in);
        int eleccion;
        do {
            System.out.println("¿Qué desea comprar? Ingrese el número:\n");
            System.out.println("1- Pociones\n");
            System.out.println("2- Mejorar tu arma\n");
            System.out.println("3- Salir de la tienda \n");
            eleccion = scanner.nextInt();
            scanner.nextLine();
        } while (eleccion != 1 && eleccion != 2 && eleccion != 3);
        return eleccion;
    }


    public List<Armas> obtenerArmasDelPersonaje(Personaje p) {
        List<Armas> listaArmas = new ArrayList<>();
        String tipoPersonaje = p.getClass().getSimpleName();

        for (Armas arma : Armas.values()) {
            if (arma.getTipoPersonaje().equalsIgnoreCase(tipoPersonaje)) {
                listaArmas.add(arma);
            }
        }
        return listaArmas;
    }

    public void comprarPocion(Personaje p, Scanner scanner){
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
        } catch (CorroborarException ex) {
            System.out.println("Atributo al max\n");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void mejoraDeArma(Personaje p, Scanner scanner) throws EntradaInvalidaException {
        List<Armas> listaArmas = obtenerArmasDelPersonaje(p);

        System.out.println("Detalle de tu arma actual como asesino\n");
        System.out.println(p.getArma());

        System.out.println("Detalle de la mejora de su arma \n");
        mostrarArma(listaArmas.get(listaArmas.size()-1));

        System.out.println("Cantidad de monedas: " + p.getMonedas());

        // Bucle para validar la entrada del usuario
        boolean entradaValida = false; // Bandera para controlar el bucle
        boolean mejorArma = false;    // Almacena el valor booleano final
        String mejorarArma = "";

        do {
            try {
                System.out.println("¿Desea mejorar su arma? (si/no):");
                mejorarArma = scanner.nextLine();

                // Intentar validar el booleano
                mejorArma = validarBooleano(mejorarArma);
                entradaValida = true; // Si no hay excepción la entrada es válida
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage()); // Mostrar el mensaje de error
            }
        } while (!entradaValida); // Repetir mientras no se haya validado la entrada

        if (mejorarArma.equals("no"))
        {
            entradaValida = false;
        }

        //corroboro que mejora de arma == "true" y que el personaje tenga la cantidad de monedas necesarias
        if (entradaValida && p.getMonedas()>= listaArmas.getLast().getPrecio()){
            p.setArma(listaArmas.getLast());
            p.setMonedas(p.getMonedas()-listaArmas.getLast().getPrecio());
            System.out.println("Has cambiado tu arma principal \n");
            System.out.println("Cantidad de monedas actuales: " + p.getMonedas());

            // Mejora de atributos según el tipo de personaje
            p.setPoderAtaque(p.getPoderAtaque() + 15); // Mejora común para todos
            if (p instanceof Mago) {
                p.setMagiaMax(p.getMagiaMax() + 10);
                p.setMagia(p.getMagia() + 10);
            } else { // Para Asesino o Guerrero
                p.setResistenciaMax(p.getResistenciaMax() + 10);
                p.setResistencia(p.getResistencia() + 10);
            }
            p.mostrarInfo();
        } else if (entradaValida && p.getMonedas()< listaArmas.getLast().getPrecio()){
            System.out.println("No tienes suficientes monedas, recoge mas monedas matando enemigos y pasando de niveles \n");
        } else if (!entradaValida){
            System.out.println("Vuelve pronto...\n");
        }
    }

}

