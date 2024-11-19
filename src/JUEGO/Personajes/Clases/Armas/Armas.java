package JUEGO.Personajes.Clases.Armas;

public enum Armas {

    //agregar daño? algo q les haga comprar el arma
    espadaCorta(100, "espada normal de asesino", "Asesino"),
    espadaGrande(100, "espada asesino pro - al comprar la mejora aumenta la resistencia maxima 10 puntos(sube esos puntos automaticamente tmbn en resistencia) y aumenta el poder de ataque por 15 pts ", "Asesino"),
    bastonCorto(100, "bastoncito mago", "Mago"),
    bastonLargo(100, "baston mago pro - al comprar la mejora aumenta la magia maxima 10 puntos(sube esos puntos automaticamente tmbn en magia) y aumenta el poder de ataque por 15 pts ", "Mago"),
    dagaFilosa(100, "daga filosa  guerrero - al comprar la mejora aumenta la resistencia maxima 10 puntos(sube esos puntos automaticamente tmbn en resistencia) y aumenta el poder de ataque por 15 pts ", "Guerrero"),
    cuchillo(100, "cuchillo guerrero", "Guerrero");


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

















