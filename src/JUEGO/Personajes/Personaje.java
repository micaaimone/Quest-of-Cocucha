package JUEGO.Personajes;

import JUEGO.Personajes.Clases.Armas.Armas;

import java.util.Objects;

public abstract class Personaje implements Movimientos {
    private int PH;
    private int fuerza;
    private int magia;
    private int resistencia;
    private int level;
    private int PHMax;
    private int fuerzaMax;
    private int magiaMax;
    private int resistenciaMax;
    private Armas arma;



    public Personaje(int PH, int fuerza, int magia, int resistencia, int level , Armas arma) {
        this.PH = PH;
        this.fuerza = fuerza;
        this.magia = magia;
        this.resistencia = resistencia;
        this.level = level;
        this.PHMax = PH;
        this.fuerzaMax = fuerza;
        this.magiaMax = magia;
        this.resistenciaMax = resistencia;
        this.arma = arma;


    }



    public Personaje() {
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

    public int getPHMax() {
        return PHMax;
    }

    public void setPHMax(int PHMax) {
        this.PHMax = PHMax;
    }

    public int getFuerzaMax() {
        return fuerzaMax;
    }

    public void setFuerzaMax(int fuerzaMax) {
        this.fuerzaMax = fuerzaMax;
    }

    public int getMagiaMax() {
        return magiaMax;
    }

    public void setMagiaMax(int magiaMax) {
        this.magiaMax = magiaMax;
    }

    public int getResistenciaMax() {
        return resistenciaMax;
    }

    public void setResistenciaMax(int resistenciaMax) {
        this.resistenciaMax = resistenciaMax;
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
    public void muerte() {

    }

    public void subirNivel() {
        int nivel = getLevel() + 1;
        System.out.println("Subiste al nivel "+ nivel+ "\n todos tus stats subieron en 20 puntos\n");
        setPH(getPH() + 20);
        setFuerza(getFuerza() + 20);
        setMagia(getMagia() + 20);
        setResistencia(getResistencia()+ 20);

    }
}
