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




}
