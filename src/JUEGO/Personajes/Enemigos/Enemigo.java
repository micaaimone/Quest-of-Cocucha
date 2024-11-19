package JUEGO.Personajes.Enemigos;

import JUEGO.Personajes.Personaje;

public class Enemigo extends Personaje {


    public Enemigo(int PH, int fuerza, int magia, int resistencia, int level) {
        super(PH, fuerza, magia, resistencia, level);
    }

    public Enemigo() {
    }

    @Override
    public void atacar(Personaje enemy) {

    }

    @Override
    public void curarse() {

    }


}
