package JUEGO.Nivel;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private List puertas;
    private int dificultad;

    public Nivel(List puertas, int dificultad) {
        this.puertas = puertas;
        this.dificultad = dificultad;
    }

    public Nivel() {
    }


    public void agregarPuerta(Puerta puerta) {
        this.puertas.add(puerta);

    }

    public void mostrarPuertas() {
        for(Puerta puerta : puertas){
            System.out.println(puerta);
        }
    }


}
