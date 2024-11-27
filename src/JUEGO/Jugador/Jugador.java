package JUEGO.Jugador;

import JUEGO.Personajes.Clases.Asesino;
import JUEGO.Personajes.Clases.Guerrero;
import JUEGO.Personajes.Clases.Mago;
import JUEGO.Personajes.CrearPersonaje;
import JUEGO.Personajes.Personaje;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public void setId(int id) {
        this.id = id;
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

    // serializar ..................

    public JSONObject serializar(){
        JSONObject jugador = new JSONObject();
        jugador.put("Id", id);
        jugador.put("Nombre", Nombre);
        jugador.put("Jugador", personaje.serializar());
        jugador.put("Puntuacion", Puntuacion);
        return jugador;
    }

    public static Jugador deserializar(JSONObject jugador){
        Jugador personaje = new Jugador();

        int id = jugador.getInt("Id");
        String Nombre = jugador.getString("Nombre");
        JSONObject personajeJson = jugador.getJSONObject("Jugador");
        int puntuacion = jugador.getInt("Puntuacion");
        Personaje personaje1 = Personaje.deserializar(personajeJson);

        personaje.setId(id);
        personaje.setNombre(Nombre);
        personaje.setPuntuacion(puntuacion);
        personaje.setPersonaje(personaje1);

        return personaje;
    }
}

