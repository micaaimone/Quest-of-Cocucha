package JUEGO.Nivel;

import JUEGO.Exceptions.EntradaInvalidaException;
import JUEGO.Personajes.Personaje;
import JUEGO.Tienda.*;

public class PuertaTienda extends Puerta{
    private Tienda tienda;

    public PuertaTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void compras (Personaje personaje){
        try {
            tienda.menuTienda(personaje);
        } catch (EntradaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
