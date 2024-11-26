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
        if (puerta == null) {
            throw new IllegalArgumentException("La puerta no puede ser nula.");
        } else {
            this.puertas.add(puerta);
        }
    }

    public List<Puerta> getPuertas() {
        return puertas;
    }

    public void setPuertas(List<Puerta> puertas) {
        this.puertas = puertas;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}
