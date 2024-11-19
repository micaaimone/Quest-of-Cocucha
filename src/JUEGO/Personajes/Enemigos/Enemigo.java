package JUEGO.Personajes.Enemigos;

import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Enemigo extends Personaje {


    public Enemigo(int PH, int fuerza, int magia, int resistencia, int level) {
        super(PH, fuerza, magia, resistencia, level );
    }

    @Override
    public void atacar(Personaje enemy) {

    }

    @Override
    public void curarse() {

    }


}
