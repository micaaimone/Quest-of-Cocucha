package JUEGO.Jugador;

import java.util.Scanner;

public class Administrador {
    private int id;
    private static int idGlobal  = 0;
    private String nombre;
    private String password;

    public Administrador(String nombre) {
        this.id = idGlobal;
        this.nombre = nombre;
        this.password = crearPassword();
        idGlobal++;
    }

    public String crearPassword() {
        System.out.println("crea una contraseña: \n");
        Scanner sc = new Scanner(System.in);

        password = sc.nextLine();

        System.out.println("tu contraseña es "+ password+". Recuerdala bien!\n");
        return password;
    }

    public boolean validarPassword(String password) {

        return false;
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


    }


}
