package JUEGO.Personajes.Clases;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Guerrero extends Personaje {
    public Guerrero() {
        super(100, 80, 80, 0, 30, Armas.cuchillo);
    }


    @Override
    public void atacar(Personaje enemy) throws CorroborarException {

    }

    @Override
    public void curarse() throws CorroborarException {

    }
}
