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
            System.out.println("🧪 Nombre de la poción: " + p);
            System.out.println("💰 Precio: " + p.getPrecio() + " monedas");

        }
    }

    public void mostrarArmas() {
        for (Armas a : Armas.values()) {
            System.out.printf("\n");
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║         🌟 * Información * 🌟                      ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║ 📜 Nombre: " + a.getNombre() + "                   ║");
            System.out.println("║ 💰 Precio: " + a.getPrecio() + " monedas de oro    ║");
            System.out.println("║ 🪶 Descripción: " + a.getDescripcion()+           "║");
            System.out.println("╚════════════════════════════════════════════════════╝");
            System.out.printf("\n");
        }
    }

    //poner un if que corrobore que el arma actual del personaje no sea igual al arma q vamos a mostrar
    public boolean mostrarArma(Armas a, Personaje p) {
        boolean yaTieneMejora = false;
        if (p.getNombreArma().equals(a.getNombre())){
            System.out.println("Ya tienes la mejora de arma\n");
            yaTieneMejora = true;
        } else {
            System.out.printf("\n");
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                 🌟 * Información del Arma * 🌟                                ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 📜 Nombre del arma: " + String.format("%-30s", a.getNombre()) +             " ║");
            System.out.println("║ 💰 Precio: " + String.format("%-27s", a.getPrecio() + " monedas de oro") +  " ║");
            System.out.println("║ 🪶 Descripción: " + String.format("%-23s", a.getDescripcion()) +            " ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
            System.out.printf("\n");
        }
        return yaTieneMejora;
    }


    //hacer una excepcion que permita nomas que se ingresen nros validos (1,2,3)
    public int menuTienda(Personaje p) throws EntradaInvalidaException {
        int puntuacion = 0;
        Scanner scanner = new Scanner(System.in);

        //mandamos a que se seleccione la opcion
        int eleccion = seleccionarOpcion();

        do{
            if (eleccion == 1) {
                //metodo especifico para comprar pocion
                puntuacion = puntuacion + comprarPocion(p, scanner);
                eleccion = seleccionarOpcion();
            } else if (eleccion == 2) {
                //para poder mostrar unicamente la mejora de arma de cada personaje armamos
                // un metodo especifico que devuelva una lista de los mismos
                List<Armas> listaArmas = new ArrayList<>();
                if (p instanceof Asesino) {
                    puntuacion = puntuacion + mejoraDeArma(p, scanner);
                } else if (p instanceof Mago) {
                    puntuacion = puntuacion + mejoraDeArma(p, scanner);
                } else if (p instanceof Guerrero) {
                    puntuacion = puntuacion + mejoraDeArma(p, scanner);
                }
                eleccion = seleccionarOpcion();
            } else if (eleccion == 3) {
                System.out.printf("\n");
                System.out.println("══════════════════════════════════════════════════");
                System.out.println("      🌟 * Gracias por visitar la tienda * 🌟      ");
                System.out.println("        🏰 Vuelve pronto, héroe. 🏰              ");
                System.out.println("══════════════════════════════════════════════════");
                System.out.printf("\n");
            } else {
                // Validación extra (aunque seleccionarOpcion debería manejarlo)
                System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (eleccion != 3);

        return puntuacion;

    }

    public int seleccionarOpcion() {
        Scanner scanner = new Scanner(System.in);
        int eleccion;
        do {
            System.out.printf("\n");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("           🏰 ¡Bienvenido a la tienda, héroe! 🏰");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("¿Qué desea comprar? Ingrese el número:\n");
            System.out.println("1️⃣ - Pociones");
            System.out.println("2️⃣ - Mejorar tu arma");
            System.out.println("3️⃣ - Salir de la tienda");
            System.out.println("══════════════════════════════════════════════════");
            System.out.printf("\n");
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

    public int comprarPocion(Personaje p, Scanner scanner){
        int puntuacion = 0;
        System.out.printf("\n");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("          🌟 ¿Qué poción desea comprar? 🌟        ");
        System.out.println("         Ingrese el nombre de la poción:          ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.printf("\n");
        mostrarPociones();

        String pocionElegida;
        pocionElegida = scanner.nextLine().toUpperCase();

        try {
            Pocion pocion = Pocion.valueOf(pocionElegida);
            System.out.printf("\n");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("   🎉 ¡Éxito! Has seleccionado la poción:   ");
            System.out.println("                " + pocion + "                  ");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.printf("\n");

            //manda a subir el atributo
            p.curarAtributo(pocionElegida, 20);
            puntuacion = puntuacion + 50;
        } catch (IllegalArgumentException e) {
            System.out.println("\u001B[31m══════════════════════════════════════════════════");
            System.out.println("\u001B[31m⚠️   ¡ALERTA! Entrada inválida   ⚠️");
            System.out.println("\u001B[31m══════════════════════════════════════════════════");
            System.out.println("\u001B[31m   ❌ Por favor, elige un atributo válido. ❌");
            System.out.println("\u001B[0m══════════════════════════════════════════════════");

        } catch (CorroborarException ex) {
            System.out.printf("\n");
            System.out.println("\u001B[31m══════════════════════════════════════════════════");
            System.out.println("\u001B[31m⚠️  ¡Error! Atributo al máximo  ⚠️");
            System.out.println("\u001B[31m══════════════════════════════════════════════════");
            System.out.println("\u001B[31m    ❌ No puedes mejorar más este atributo. ❌");
            System.out.println("\u001B[0m══════════════════════════════════════════════════");
            System.out.printf("\n");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return puntuacion;
    }


    public int mejoraDeArma(Personaje p, Scanner scanner) throws EntradaInvalidaException {
        int puntuacion = 0;
        List<Armas> listaArmas = obtenerArmasDelPersonaje(p);
        boolean yaTieneArmaMejorada = false;

        System.out.println("Detalle de tu arma actual como " + p.getClass());
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("        🗡️ * Detalle de tu arma actual * 🗡️        ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("   🔰 Clase del portador: " + p.getClass());
        System.out.println("   ⚔️ Una herramienta forjada para la batalla.");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println(p.getArma());

        System.out.println("Detalle de la mejora de su arma \n");

        yaTieneArmaMejorada = mostrarArma(listaArmas.get(listaArmas.size()-1), p);

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("         💰 * Estado de tus riquezas * 💰         ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("   🪙 Cantidad de monedas: " + p.getMonedas());
        System.out.println("══════════════════════════════════════════════════");


        // Bucle para validar la entrada del usuario
        boolean entradaValida = false; // Bandera para controlar el bucle
        boolean mejorArma = false;    // Almacena el valor booleano final
        String mejorarArma = "";

        if (!yaTieneArmaMejorada){
            do {
                try {
                    System.out.println("══════════════════════════════════════════════════");
                    System.out.println("       🔧 * Menú de Mejora de Armas * 🔧         ");
                    System.out.println("══════════════════════════════════════════════════");
                    System.out.println("   ⚔️ ¿Desea mejorar su arma? (si/no):");
                    System.out.println("══════════════════════════════════════════════════");

                    mejorarArma = scanner.nextLine();

                    // Intentar validar el booleano
                    mejorArma = validarBooleano(mejorarArma);
                    entradaValida = true; // Si no hay excepción la entrada es válida
                } catch (EntradaInvalidaException e) {
                    System.out.println(e.getMessage()); // Mostrar el mensaje de error
                }
            } while (!entradaValida); // Repetir mientras no se haya validado la entrada
        }


        if (mejorarArma.equals("no"))
        {
            entradaValida = false;
        }

        //corroboro que mejora de arma == "true" y que el personaje tenga la cantidad de monedas necesarias
        if (entradaValida && p.getMonedas()>= listaArmas.getLast().getPrecio()){
            p.setArma(listaArmas.getLast());
            p.setMonedas(p.getMonedas()-listaArmas.getLast().getPrecio());
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("       🔄 * Cambio de Arma Principal * 🔄        ");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("   🗡️ ¡Has cambiado tu arma principal!");
            System.out.println("   💰 Cantidad de monedas actuales: " + p.getMonedas());
            System.out.println("══════════════════════════════════════════════════");
            puntuacion = puntuacion + 100;

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
            System.out.println("\u001B[31m══════════════════════════════════════════════════");
            System.out.println("       ⚠️ * Advertencia de Monedas * ⚠️         ");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("\u001B[0m   ❌ No tienes suficientes monedas.");
            System.out.println("   💀 Consejo: Recoge más monedas matando enemigos");
            System.out.println("             y pasando de niveles.");
            System.out.println("══════════════════════════════════════════════════");

        } else if (!entradaValida){
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("          🌟 ¡Gracias por tu visita! 🌟           ");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("   😊 Vuelve pronto, siempre eres bienvenido.");
            System.out.println("══════════════════════════════════════════════════");

        }

        return puntuacion;
    }

}

