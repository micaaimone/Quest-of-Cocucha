package JUEGO.Jugador;

import JUEGO.JSON.GestionJSON;
import JUEGO.Personajes.Personaje;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class GestionJugador {
    //el map se va a guardar por id jugador como key y el jugador como
    private Map<Integer, Jugador> PuntuacionJugador;

    public GestionJugador() {
        PuntuacionJugador = new TreeMap<>();
    }

    public Map<Integer, Jugador> getPuntuacionJugador() {
        return PuntuacionJugador;
    }

    public void setPuntuacionJugador(Map<Integer, Jugador> puntuacionJugador) {
        PuntuacionJugador = puntuacionJugador;
    }

    public void agregarJugador(Jugador j) {
        int id = j.getId();
        while (PuntuacionJugador.containsKey(id)) {
            // Si el ID ya existe, incrementamos y actualizamos el ID del jugador
            id++;
            j.setId(id);
        }

        PuntuacionJugador.put(id, j);
    }

    public void eliminarJugador(Jugador j){
        PuntuacionJugador.remove(j.getId());
    }

    public void mostrarJugadores() {
        // Crear una lista con los valores del mapa (los jugadores)
        ArrayList<Jugador> jugadores = new ArrayList<>(PuntuacionJugador.values());

        // Ordenar la lista según la puntuación de los jugadores (de menor a mayor)
        jugadores.sort(Comparator.comparingInt(Jugador::getPuntuacion));

        // Recorrer y mostrar los jugadores ordenados
        for (Jugador jugador : jugadores) {
            int id = jugador.getId();
            String nombre = jugador.getNombre();
            Personaje personaje = jugador.getPersonaje();
            int puntuacion = jugador.getPuntuacion();

            System.out.println("Id = " + id +
                    "\nNombre = " + nombre +
                    "\nPersonaje = " + personaje.getClass().getSimpleName() +
                    "\nPuntuacion = " + puntuacion + "\n");
        }
    }

    public void limitar (){
        for (int i = 0; i < Math.min(5, PuntuacionJugador.size()); i++) { // Limitar a los primeros 5
        Jugador jugador = PuntuacionJugador.get(i);

        int id = jugador.getId();
        String nombre = jugador.getNombre();
        Personaje personaje = jugador.getPersonaje();
        int puntuacion = jugador.getPuntuacion();

        System.out.println("Posición: " + (i + 1) +
                "\nId = " + id +
                "\nNombre = " + nombre +
                "\nPersonaje = " + (personaje != null ? personaje : "Sin personaje") +
                "\nPuntuacion = " + puntuacion + "\n");
    }
    }

    //agrega al puntuacion jugador los elementos cargados en el json
    public void agregarPjJson() {
        // Leer el objeto GestionJugador desde el JSON
        GestionJugador gj = GestionJSON.jsonAObjec();

        if (gj == null || gj.getPuntuacionJugador() == null) {
            System.out.println("Error: No se pudo leer el JSON o está vacío.");
            return;
        }

        // Recorrer los jugadores obtenidos del JSON y agregarlos
        for (Map.Entry<Integer, Jugador> entry : gj.getPuntuacionJugador().entrySet()) {
            agregarJugador(entry.getValue());
        }

        System.out.println("Se han agregado los jugadores desde el JSON.");
    }
}
