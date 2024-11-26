package JUEGO.Jugador;

import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;
import JUEGO.Personajes.CrearPersonaje;
import JUEGO.Personajes.Personaje;

import java.util.Scanner;

public class Jugador {


    private String Nombre;
    private Personaje personaje;
    private int Puntuacion;
    private int id;
    private int idGlobal = 0;


    public Jugador(String nombre) {
        Nombre = nombre;
        this.personaje = CrearPersonaje.Seleccionar();
        Puntuacion = 0;
        this.id = idGlobal ++;
    }

    public Jugador() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public int getIdGlobal() {
        return idGlobal;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "Nombre='" + Nombre + '\'' +
                ", personaje=" + personaje +
                ", Puntuacion=" + Puntuacion +
                '}';
    }
}

