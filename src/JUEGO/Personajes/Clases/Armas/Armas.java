package JUEGO.Personajes.Clases.Armas;

public enum Armas {

    //agregar descripciones para armas, diria q agregar + armas para cada personaje
    espadaCorta (100),
    espadaGrande(100),
    bastonCorto(100),
    bastonLargo(100),
    ballesta(100),
    cuchillo(100);

    private final int precio;


    Armas(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}

















