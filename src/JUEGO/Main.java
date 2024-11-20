package JUEGO;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Exceptions.EntradaInvalidaException;


//DSPS borrar corroborar exception
public class Main {
    public static void main(String[] args) throws CorroborarException, EntradaInvalidaException {
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.menu();

    }
}

/*
un mapa qye va a tener la key como nombre del jugador y el valor la puntuacion total del pj

un set de enemigos

una list de posciones para la tienda
--------------------------------------
una clase generica que contendra el set de enemigos y reciba un T de personaje

excpciones :
-cuando no tenes vida
-no tenes magia/ resistencia
-monedas insuficientes
-....
-------------------------------------
hacer las operaciones basicas de cada sistema para poder manipular los datos
*Alta: dar de alta nuevos registros onda personajes o cosas asi
*Baja: dar de baja ...
*Modificar: modificar los registros
*Listado: listar los registros
-----------------------------------


*/
