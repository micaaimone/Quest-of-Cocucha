package JUEGO.Personajes;

import JUEGO.Exceptions.CorroborarException;

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
    private int poderAtaque;


    public Personaje(int PH, int fuerza, int magia, int resistencia, int level, int poderAtaque) {
        this.PH = PH;
        this.fuerza = fuerza;
        this.magia = magia;
        this.resistencia = resistencia;
        this.level = level;
        this.PHMax = PH;
        this.fuerzaMax = fuerza;
        this.magiaMax = magia;
        this.resistenciaMax = resistencia;
        this.poderAtaque = poderAtaque;
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

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(int poderAtaque) {
        this.poderAtaque = poderAtaque;
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

    //corroborar parte de subir nivel
    public void subirNivel() {
        int nivel = getLevel() + 1;
        System.out.println("Subiste al nivel "+ nivel+ "\n todos tus stats subieron en 20 puntos\n");
        setPH(getPH() + 20);
        setFuerza(getFuerza() + 20);
        setMagia(getMagia() + 20);
        setResistencia(getResistencia()+ 20);
    }

    //ya que los personajes tanto asesino como mago pueden curarse hacemos el metodo public en la clase padre
    public void curarAtributo(String atributo, int cantidad) throws CorroborarException {
        int actual = 0, maximo = 0, curacionReal = 0;

        if (atributo.equalsIgnoreCase("ph")) {
            actual = getPH();
            maximo = getPHMax();

            curacionReal = corroborarCuracion(actual, maximo, cantidad);
            if (curacionReal > 0){
                setPH(actual + curacionReal);
            } else {
                throw new CorroborarException("El " + atributo + " ya está al máximo.");
            }

        } else if (atributo.equalsIgnoreCase("resistencia")) {
            actual = getResistencia();
            maximo = getResistenciaMax();

            curacionReal = corroborarCuracion(actual, maximo, cantidad);
            if (curacionReal > 0){
                setResistencia(actual + curacionReal);
            } else {
                throw new CorroborarException("El " + atributo + " ya está al máximo.");
            }
        } else if (atributo.equalsIgnoreCase("magia")) {
            actual = getMagia();
            maximo = getMagiaMax();
            curacionReal = corroborarCuracion(actual, maximo, cantidad);
            if (curacionReal > 0){
                setMagia(actual + curacionReal);
            } else {
                throw new CorroborarException("El " + atributo + " ya está al máximo.");
            }
        } else {
            throw new IllegalArgumentException("Atributo no válido: " + atributo);
        }


        System.out.println(atributo + " aumentado en " + curacionReal + ". " + atributo + " actual: " + (actual + curacionReal));
    }

    public int corroborarCuracion(int actual, int maximo, int cantidad) throws CorroborarException {
        int curacion = 0;

        if (actual<maximo){
            curacion = Math.min(cantidad, maximo - actual);
        } else
        {
            curacion = 0;
        }
        return curacion;
    }

}
