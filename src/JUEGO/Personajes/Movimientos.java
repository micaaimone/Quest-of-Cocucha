package JUEGO.Personajes;

import JUEGO.Exceptions.CorroborarException;

public interface Movimientos {
    public void atacar(Personaje enemy) throws CorroborarException;
    public void curarse() throws CorroborarException;
    public void subirNivel() throws CorroborarException;
    public void muerte();
}
