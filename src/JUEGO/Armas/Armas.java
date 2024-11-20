package JUEGO.Armas;

public enum Armas {

    //mejorar las descripciones
    espadaCorta(0, "espada normal de guerrero", "Guerrero"),
    espadaGrande(100, "espada guerrero pro - al comprar la mejora aumenta la resistencia maxima 10 puntos(sube esos puntos automaticamente tmbn en resistencia) y aumenta el poder de ataque por 15 pts ", "Guerrero"),
    bastonCorto(0, "bastoncito mago", "Mago"),
    bastonLargo(100, "baston mago pro - al comprar la mejora aumenta la magia maxima 10 puntos(sube esos puntos automaticamente tmbn en magia) y aumenta el poder de ataque por 15 pts ", "Mago"),
    cuchillo(0, "cuchillo asesino", "Asesino"),
    dagaFilosa(100, "daga filosa  asesino - al comprar la mejora aumenta la resistencia maxima 10 puntos(sube esos puntos automaticamente tmbn en resistencia) y aumenta el poder de ataque por 15 pts ", "Asesino");


    private final int precio;
    private final String descripcion;
    private final String tipoPersonaje;

    Armas(int precio, String descripcion, String tipoPersonaje) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoPersonaje = tipoPersonaje;
    }

    public int getPrecio() {
        return precio;
    }


    public String getDescripcion(){
        return descripcion;
    }

    public String getTipoPersonaje() {
        return tipoPersonaje;
    }
}

















