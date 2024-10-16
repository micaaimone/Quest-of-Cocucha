package Personajes;

import java.util.Objects;

public abstract class Personaje implements Movimientos {
    private int PH;
    private int fuerza;
    private int magia;
    private int resistencia;
    private int level;

    public Personaje(int PH, int fuerza, int magia, int resistencia, int level) {
        this.PH = PH;
        this.fuerza = fuerza;
        this.magia = magia;
        this.resistencia = resistencia;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPH() {
        return PH;
    }

    public void setPH(int PH) {
        this.PH = PH;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return level == personaje.level;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(level);
    }

    @Override
    public void atacar() {

    }

    @Override
    public void curarse() {

    }

    @Override
    public void subirNivel() {

    }
}
