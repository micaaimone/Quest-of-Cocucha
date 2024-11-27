package JUEGO.Jugador;

import JUEGO.Armas.Armas;
import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;
import JUEGO.Personajes.Personaje;

import java.util.Scanner;

public class Administrador {
    private String nombre;
    private String password;
    private Personaje personaje;

    public Administrador(String nombre) {
        this.nombre = nombre;
        this.password = crearPassword();
    }

    public String crearPassword() {
        System.out.println("crea una contraseña: \n");
        Scanner sc = new Scanner(System.in);

        password = sc.nextLine();

        System.out.println("tu contraseña es "+ password+". Recuerdala bien!\n");
        return password;
    }

    public boolean validarPassword(String password) {

        return password.equals(this.password);
    }

    public void administrar(){
        System.out.println("Bienvenido a zona administradora");
        Boolean validar = false;

        while(!validar) {
            System.out.println("comprobemos que eres un administrador! \n Ingrese la contraseña: ");
            Scanner sc = new Scanner(System.in);
            String password = sc.nextLine();
            validar = validarPassword(password);
            if(!validar) {
                System.out.println("Contraseña incorrecta, volve a intentarlo");
            }
        }
        System.out.println("Bienvenido admin!");

        System.out.println("Vamos a modificar nuestros stats (trampa)");

        modificarPersonaje(personaje);

    }

    public void modificarPersonaje(Personaje personaje) {


//            mi idea aca es que se pregunte que personaje queres cambiar
//            ese personaje entra o por teclado o por nro (mostrar antes cuales son las opciones) y de ahi
//            preguntar el atributo q lo hice ahi abajo

        Scanner scanner = new Scanner(System.in);

            // Preguntar qué atributo desea modificar
            System.out.println("Seleccione el atributo que desea modificar:");
            System.out.println("1. PH");
            System.out.println("2. Magia");
            System.out.println("3. Resistencia");
            System.out.println("4. Level");
            System.out.println("5. PHMax");
            System.out.println("6. MagiaMax");
            System.out.println("7. ResistenciaMax");
            System.out.println("8. Poder de Ataque");
            System.out.println("9. Arma");
            System.out.println("10. Monedas");
            int opcion = scanner.nextInt();

            // Modificar el atributo según la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo valor de PH:");
                    int nuevoPH = scanner.nextInt();
                    modificarPH(personaje, nuevoPH);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo valor de Magia:");
                    int nuevaMagia = scanner.nextInt();
                    modificarMagia(personaje, nuevaMagia);
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo valor de Resistencia:");
                    int nuevaResistencia = scanner.nextInt();
                    modificarResistencia(personaje, nuevaResistencia);
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo nivel:");
                    int nuevoLevel = scanner.nextInt();
                    modificarLevel(personaje, nuevoLevel);
                    break;
                case 5:
                    System.out.println("Ingrese el nuevo valor de PHMax:");
                    int nuevoPHMax = scanner.nextInt();
                    modificarPHMax(personaje, nuevoPHMax);
                    break;
                case 6:
                    System.out.println("Ingrese el nuevo valor de MagiaMax:");
                    int nuevaMagiaMax = scanner.nextInt();
                    modificarMagiaMax(personaje, nuevaMagiaMax);
                    break;
                case 7:
                    System.out.println("Ingrese el nuevo valor de ResistenciaMax:");
                    int nuevaResistenciaMax = scanner.nextInt();
                    modificarResistenciaMax(personaje, nuevaResistenciaMax);
                    break;
                case 8:
                    System.out.println("Ingrese el nuevo valor de Poder de Ataque:");
                    int nuevoPoderAtaque = scanner.nextInt();
                    modificarPoderAtaque(personaje, nuevoPoderAtaque);
                    break;
                case 9:
                    System.out.println("Ingrese el nuevo arma (tipo de Armas):");
                    String nuevoArma = scanner.next(); // Suponiendo que Armas es una clase con un constructor por nombre
                    modificarArma(personaje, Armas.getArmaByName(nuevoArma)); // Crear una nueva arma
                    break;
                case 10:
                    System.out.println("Ingrese el nuevo valor de Monedas:");
                    int nuevasMonedas = scanner.nextInt();
                    modificarMonedas(personaje, nuevasMonedas);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

    }

    // Al ser un administrador puede modificar los atributos de los diferentes personajes

    public void modificarPH(Personaje personaje, int nuevoPH) {
        personaje.setPH(nuevoPH);
    }

    public void modificarPHMax(Personaje personaje, int nuevoPHMax) {
        personaje.setPHMax(nuevoPHMax);
    }
    public void modificarMagia(Personaje personaje, int nuevaMagia) {
        personaje.setMagia(nuevaMagia);
    }

    public void modificarMagiaMax(Personaje personaje, int nuevaMagiaMax) {
        personaje.setMagiaMax(nuevaMagiaMax);
    }

    public void modificarResistencia(Personaje personaje, int nuevaResistencia) {
        personaje.setResistencia(nuevaResistencia);
    }

    public void modificarResistenciaMax(Personaje personaje, int nuevaResistenciaMax) {
        personaje.setResistenciaMax(nuevaResistenciaMax);
    }

    public void modificarLevel(Personaje personaje, int nuevoLevel) {
        personaje.setLevel(nuevoLevel);
    }

    public void modificarPoderAtaque(Personaje personaje, int nuevoPoderAtaque) {
        personaje.setPoderAtaque(nuevoPoderAtaque);
    }

    public void modificarArma(Personaje personaje, Armas nuevaArma) {
        personaje.setArma(nuevaArma);
    }

    public void modificarMonedas(Personaje personaje, int nuevasMonedas) {
        personaje.setMonedas(nuevasMonedas);
    }


}
