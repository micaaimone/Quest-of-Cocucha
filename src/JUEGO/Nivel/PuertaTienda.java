package JUEGO.Nivel;

import JUEGO.Exceptions.EntradaInvalidaException;
import JUEGO.Personajes.Personaje;
import JUEGO.Tienda.*;

public class PuertaTienda extends Puerta{
    private Tienda tienda;

    public PuertaTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public int compras (Personaje personaje){
        int puntuacion = 0;
        try {
            puntuacion = puntuacion + tienda.menuTienda(personaje);
        } catch (EntradaInvalidaException e) {
            System.out.println(e.getMessage());
        }
        return puntuacion;
    }
}
