package JUEGO.Nivel;

import JUEGO.Personajes.Personaje;

public class Puerta  {
    //por cada nivel hay 3 puertas, una en la que se enfrenta a un enemigo
    //otra donde aumentas un atributo en particular
    //otra q hay 3 opciones (1 q pase directamente al siguiente nivel,
    // 2  q aumente el level del personaje, aumentando un poco d cada atributo por consecuencia
    // 3 crear una moneda y en la puerta poner un vendedor
    private Personaje enemigo;
    private int aumentar;
    private int eleccion;

    //constructor para crear un enemigo
    public Puerta(Personaje enemigo) {
        this.enemigo = enemigo;
    }

    //constructor para aumentar un atributo
    public Puerta(int aumentar) {
        this.aumentar = aumentar;
    }



}
