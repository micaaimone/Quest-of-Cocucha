package JUEGO.Personajes;

import JUEGO.Exceptions.CorroborarException;

public interface Movimientos {
    public void atacar(Personaje enemy);
    public void curarse() throws CorroborarException;
    public void subirNivel();
    public void muerte();
}