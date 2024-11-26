package JUEGO.Personajes;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Armas.Armas;

import java.util.Objects;

public abstract class Personaje implements Movimientos {
    private int PH;
    private int magia;
    private int resistencia;
    private int level;
    private int PHMax;
    private int magiaMax;
    private int resistenciaMax;
    private int poderAtaque;
    private Armas arma;
    private int monedas;


    public Personaje(int PH, int magia, int resistencia, int level, int poderAtaque, Armas arma) {
        this.PH = PH;
        this.magia = magia;
        this.resistencia = resistencia;
        this.level = level;
        this.PHMax = PH;
        this.magiaMax = magia;
        this.resistenciaMax = resistencia;
        this.poderAtaque = poderAtaque;
        this.arma = arma;
        this.monedas = 50;
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

    public String  getArma() {
        return "Nombre: " + arma.name()+
                "\nDescripción: " + arma.getDescripcion() +
                "\n----------------------";

    }

    public String getNombreArma(){
        return arma.getNombre();
    }

    public void setArma(Armas arma) {
        this.arma = arma;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
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
    
    public void subirNivel() throws CorroborarException {
        int nivel = getLevel() + 1;
        int sumarAtributo = 0;
        setLevel(getLevel()+1);
        System.out.println();System.out.println(
                "🎮✨ ¡Felicidades! Has subido al nivel " + nivel + " ✨🎮"+
                        "       *      *      *\n" +
                        "     *   *  *   *  *   *\n" +
                        "    *     **     **     *\n" +
                        "   *************************\n" +
                        "  *         Nivel Up!       *\n" +
                        "   *************************\n" +
                        "    *     **     **     *\n" +
                        "     *   *  *   *  *  *\n" +
                        "       *      *      *\n" +
                        "💪 Ahora eres más fuerte que nunca. ¡A seguir avanzando! 💪"
        );
        System.out.println("⚡ Todos tus stats subieron en 20 puntos. ¡Estás más fuerte que nunca! ⚡");

        sumarAtributo = corroborarAtributo(getPH(), getPHMax(), 20);
        if (sumarAtributo > 0 ){
            setPH(getPH() + sumarAtributo);
        } else {
            throw new CorroborarException("\u001B[31m⚠️ ¡Error! El PH ya está al máximo. ⚠️\u001B[0m");

        }

        sumarAtributo = corroborarAtributo(getMagia(), getMagiaMax(), 20);
        if (sumarAtributo > 0 ){
            setMagia(getMagia() + sumarAtributo);
        } else {
            throw new CorroborarException("\u001B[31m⚠️ ¡Error! La magia ya está al máximo. ⚠️\u001B[0m");

        }

        sumarAtributo = corroborarAtributo(getResistencia(), getResistenciaMax(), 20);
        if (sumarAtributo > 0 ){
            setResistencia(getResistencia() + sumarAtributo);
        } else {
            throw new CorroborarException("\u001B[31m⚠️ ¡Error! La resistencia ya está al máximo. ⚠️\u001B[0m");

        }
    }

    //ya que los personajes tanto asesino como mago pueden curarse hacemos el metodo public en la clase padre

    //----IMP cuando se llame a esta funcion hay que hacer una excepcion que corrobore que CANTIDAD no sea negativa. Solo puede ingresar nros positivos
    //cambiar el nombre del metodo y agregar que corrobore el atributo level
    public void curarAtributo(String atributo, int cantidad) throws CorroborarException {
        int actual = 0, maximo = 0, curacionReal = 0;

        if (atributo.equalsIgnoreCase("ph")) {
            actual = getPH();
            maximo = getPHMax();

            curacionReal = corroborarAtributo(actual, maximo, cantidad);
            if (curacionReal > 0){
                setPH(actual + curacionReal);
            } else {
                throw new CorroborarException("⚠️ ¡Advertencia! El " + atributo + " ya está al máximo. ⚠️");
            }

        } else if (atributo.equalsIgnoreCase("resistencia")) {
            actual = getResistencia();
            maximo = getResistenciaMax();

            curacionReal = corroborarAtributo(actual, maximo, cantidad);
            if (curacionReal > 0){
                setResistencia(actual + curacionReal);
            } else {
                throw new CorroborarException("⚠️ ¡Advertencia! El " + atributo + " ya está al máximo. ⚠️");
            }
        } else if (atributo.equalsIgnoreCase("magia")) {
            actual = getMagia();
            maximo = getMagiaMax();
            curacionReal = corroborarAtributo(actual, maximo, cantidad);
            if (curacionReal > 0){
                setMagia(actual + curacionReal);
            } else {
                throw new CorroborarException("⚠️ ¡Advertencia! El " + atributo + " ya está al máximo. ⚠️");
            }
        } else {
            throw new IllegalArgumentException("❌ Atributo no válido: " + atributo + " ❌");
        }

        System.out.println("✨ " + atributo + " ha aumentado en +" + curacionReal + "! ✨");
        System.out.println("🔋 " + atributo + " actual: " + (actual + curacionReal));

    }

    //mandar a validacion? como validacion atributo o algo asi????
    public int corroborarAtributo(int actual, int maximo, int cantidad) throws CorroborarException {
        int suma = 0;

        if (actual<maximo){
            suma = Math.min(cantidad, maximo - actual);
        } else
        {
            suma = 0;
        }
        return suma;
    }


    //imprimir info del personaje
    public void mostrarInfo() {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("             🎮 * Estado del Personaje * 🎮        ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("   🧍 Nivel: " + getLevel());
        System.out.println("   ❤️     PH:      " + crearBarra(getPH(), getPHMax(), "\u001B[31m█\u001B[0m", '-'));
        System.out.println("   ✨    Magia:    " + crearBarra(getMagia(), getMagiaMax(), "\u001B[34m█\u001B[0m", '-'));
        System.out.println("   🛡️ Resistencia: " + crearBarra(getResistencia(), getResistenciaMax(), "\u001B[32m█\u001B[0m", '-'));
        System.out.println("   ⚔️ Poder de ataque: " + getPoderAtaque());
        System.out.println("   🗡️ Arma equipada: " + getNombreArma());
        System.out.println("   💰 Monedas: " + getMonedas());
        System.out.println("══════════════════════════════════════════════════");

    }

    private static String crearBarra (int actual, int maximo, String lleno, char vacio){
        double porcentaje = (double) actual / maximo;
        int longitudBarra = 20; // Ajustar la longitud de la barra según sea necesario
        int cantidadLlena = (int) (porcentaje * longitudBarra);
        int cantidadVacia = longitudBarra - cantidadLlena;

        StringBuilder barra = new StringBuilder();
        barra.append(String.valueOf(lleno).repeat(cantidadLlena));
        barra.append(String.valueOf(vacio).repeat(cantidadVacia));
        return barra.toString();
    }

}
