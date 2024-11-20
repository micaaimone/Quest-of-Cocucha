package JUEGO.Nivel;

import JUEGO.Personajes.Duelo;
import JUEGO.Personajes.Enemigos.*;
import JUEGO.Personajes.Personaje;

import java.util.ArrayList;
import java.util.List;

import static JUEGO.Personajes.Duelo.combate;


//por cada nivel hay 3 puertas, una en la que se enfrenta a un enemigo
//otra donde aumentas un atributo en particular
//otra q hay 3 opciones (1 q pase directamente al siguiente nivel,
// 2  q aumente el level del personaje, aumentando un poco d cada atributo por consecuencia
// 3 crear una moneda y en la puerta poner un vendedor

//vamos a crear 3 clases de puerta (enemigos, tienda, y subir nivel)

public class PuertaEnemigo extends Puerta{
    private Enemigo enemigo;

    public PuertaEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public boolean combatir(Personaje hero){
        System.out.println("Vas a combatir con el enemigo\n");
        boolean win = combate(enemigo, hero);
        return win;

    }

}
