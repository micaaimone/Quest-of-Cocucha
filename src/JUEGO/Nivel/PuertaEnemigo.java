package JUEGO.Nivel;

import JUEGO.Personajes.Enemigos.Enemigo;

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


}
