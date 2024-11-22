package JUEGO.Jugador;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GestionJugador {
    //el map se va a guardar por id jugador como key y el jugador como
    private Map<Integer, Jugador> PuntuacionJugador;

    public GestionJugador() {
        PuntuacionJugador = new TreeMap<>();
    }

    public void agregarJugador(Jugador j){
        PuntuacionJugador.put(j.getId(),j);
    }

    public void eliminarJugador(Jugador j){
        PuntuacionJugador.remove(j.getId());
    }

    public void mostrarPuntuaciones(){
        for(int i = 0; i<4; i++){
            
        }
    }
}
