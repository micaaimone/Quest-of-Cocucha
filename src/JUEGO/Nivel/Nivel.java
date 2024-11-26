package JUEGO.Nivel;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private List <Puerta> puertas;
    private int dificultad;

    public Nivel(int dificultad) {
        this.puertas = new ArrayList<>();
        this.dificultad = dificultad;
    }

    public Nivel() {
    }

    public Puerta getPuerta(int index) {
        return puertas.get(index);
    }

    public void agregarPuerta(Puerta puerta) {
        this.puertas.add(puerta);
    }

//    public void mostrarPuertas() {
//        for(Puerta puerta : puertas){
//            System.out.println(puerta);
//        }
//    }



}
