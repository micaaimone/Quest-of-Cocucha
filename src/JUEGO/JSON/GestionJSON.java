package JUEGO.JSON;

import JUEGO.Jugador.GestionJugador;
import JUEGO.Jugador.Jugador;
import JUEGO.Personajes.Personaje;
import org.json.*;

import java.util.Map;

import JUEGO.Jugador.GestionJugador;
import JUEGO.Jugador.Jugador;
import JUEGO.Personajes.Personaje;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import JUEGO.Jugador.GestionJugador;
import JUEGO.Jugador.Jugador;
import JUEGO.Personajes.Personaje;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class GestionJSON {
    //vamos a serializar jugador y personajes
    public static void jugadoraArchivo(GestionJugador v) {
        JSONutility.grabar(serializacion(v.getPuntuacionJugador()), "jugadores.json");
    }

    //recibe el mapa y lo carga en un jsonarray
    public static JSONArray serializacion(Map<Integer, Jugador> mapJugadores) {
        JSONObject objJugador = null;
        JSONArray jsonJugadores = null;
        try {
            //creo al array que contendria a cada uno de los jugadores
            jsonJugadores = new JSONArray();
            for (Map.Entry<Integer, Jugador> map : mapJugadores.entrySet()) {
                //aca mando a serializar a cada uno de los objetos del mapa (osea el jugador)
                objJugador = serializacionJugador(map.getValue());
                jsonJugadores.put(objJugador);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return jsonJugadores;
    }

    //recibe al jugador y lo manda como objeto
    public static JSONObject serializacionJugador(Jugador j) {
        JSONObject objJugador = null;
        try {
            objJugador = new JSONObject();
            objJugador = (j.serializar());
        }
     catch (Exception e) {
            e.printStackTrace();
        }
        return objJugador;
    }

    //leer
    public static GestionJugador jsonAObjec(){
        GestionJugador j = new GestionJugador();
        try {
            JSONTokener tokener = JSONutility.leer("jugadores.json");


            JSONArray jugadores = new JSONArray(tokener);

            for (int i = 0; i < jugadores.length(); i++) {
                Jugador jugador = Jugador.deserializar(jugadores.getJSONObject(i));
                j.agregarJugador(jugador);
            }

        }catch (JSONException e) {
            e.printStackTrace();
        }
        return j;
    }
}
