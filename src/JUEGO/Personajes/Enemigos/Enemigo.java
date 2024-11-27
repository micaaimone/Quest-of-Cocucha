package JUEGO.Personajes.Enemigos;

import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;

public final class Enemigo extends Personaje {
    private String nombre;


    public Enemigo(int PH, int magia, int resistencia, int level, int poderAtaque, Armas arma, String nombre) {
        super(PH, magia, resistencia, level, poderAtaque, arma);
        this.nombre = nombre;
    }

    public Enemigo() {
    }

    @Override
    public void atacar(Personaje enemy) {
        System.out.println("Soy el enemigo " + getNombre());
        //System.out.println("\n🔪 ¡El enemigo ataca con " + enemy.getArma() + "! 🔪\n");

        enemy.setPH(enemy.getPH()-getPoderAtaque());
    }


    @Override
    public void curarse() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
