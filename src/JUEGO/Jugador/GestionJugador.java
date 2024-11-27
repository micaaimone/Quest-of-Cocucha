package JUEGO.Jugador;

import JUEGO.JSON.GestionJSON;
import JUEGO.Personajes.Personaje;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    public void agregarJugador(Jugador j){
        PuntuacionJugador.put(j.getId(),j);
    }

    public void eliminarJugador(Jugador j){
        PuntuacionJugador.remove(j.getId());
    }

    public void mostrarJugadores(){
        agregarPjJson();
        limitar();

        for (Map.Entry<Integer, Jugador> entry : PuntuacionJugador.entrySet()) {
            int id = entry.getKey();
            String nombre = entry.getValue().getNombre();
            Personaje j = entry.getValue().getPersonaje();
            int score = entry.getValue().getPuntuacion();
            System.out.println("Id = "+ id + " \nNombre = " + nombre + "\n Personaje = " + j + "\n Puntuacion = "+ score +"\n");
        }
    }

    public void limitar (){


        for (int i = 5; i < PuntuacionJugador.size(); i++) {
            eliminarJugador(PuntuacionJugador.get(i));
        }

    }

    public void agregarPjJson (){
        GestionJugador gj = GestionJSON.jsonAObjec();

        for (Map.Entry<Integer, Jugador> entry : gj.getPuntuacionJugador().entrySet()) {
            agregarJugador(entry.getValue());
        }
    }
}
