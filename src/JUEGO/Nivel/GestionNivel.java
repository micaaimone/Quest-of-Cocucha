package JUEGO.Nivel;
import JUEGO.Personajes.*;
import JUEGO.Personajes.Enemigos.Enemigo;
import JUEGO.Tienda.Tienda;

import java.util.TreeSet;

public class GestionNivel {
    private Personaje personaje;

    public GestionNivel(Personaje personaje) {
        this.personaje = personaje;
    }

    public void crearNivel (){
        //----------------ENEMIGOS------------------------------------
        Enemigo enemigo1 = new Enemigo();
        Enemigo enemigo2 = new Enemigo();
        Enemigo enemigo3 = new Enemigo();
        Enemigo enemigo4 = new Enemigo();
        Enemigo enemigo5 = new Enemigo();
        //-------tienda--------------------------------------------
        Tienda tienda1 = new Tienda();
        //-------Puertas--------------------------------------------
        PuertaEnemigo puertaEnemigo1 = new PuertaEnemigo(enemigo1);
        PuertaEnemigo puertaEnemigo2 = new PuertaEnemigo(enemigo2);
        PuertaEnemigo puertaEnemigo3 = new PuertaEnemigo(enemigo3);
        PuertaEnemigo puertaEnemigo4 = new PuertaEnemigo(enemigo4);
        PuertaEnemigo puertaEnemigo5 = new PuertaEnemigo(enemigo5);
        //PUERTAS TIENDA
        PuertaTienda puertaTienda1 = new PuertaTienda(tienda1);

        //-------niveles--------------------------------------------
        Nivel nivel1 = new Nivel(1);
        nivel1.agregarPuerta(puertaEnemigo1);
        nivel1.agregarPuerta(puertaTienda1);

        //--
        Nivel nivel2 = new Nivel(2);
        nivel2.agregarPuerta(puertaEnemigo2);
        nivel2.agregarPuerta(puertaTienda1);

        //--
        Nivel nivel3 = new Nivel(3);
        nivel3.agregarPuerta(puertaEnemigo3);
        nivel3.agregarPuerta(puertaTienda1);

        //--
        Nivel nivel4 = new Nivel(4);
        nivel4.agregarPuerta(puertaEnemigo4);
        nivel4.agregarPuerta(puertaTienda1);

        //--
        Nivel nivel5 = new Nivel(5);
        nivel5.agregarPuerta(puertaEnemigo5);



    }
}
