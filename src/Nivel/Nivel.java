package Nivel;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private List puerta;
    private int dificultad;

    public Nivel() {
        this.puerta = new ArrayList<>();
    }

    public void eleccionPuerta(int eleccion){
        System.out.println("Que puerta deseas elegir \n"
        +"1-");
    }


}
