package JUEGO.Personajes.Clases.Armas;

public enum Armas {

    //agregar daño? algo q les haga comprar el arma
    espadaCorta(100, "espada normal de asesino", "Asesino"),
    espadaGrande(100, "espada asesino pro", "Asesino"),
    bastonCorto(100, "bastoncito mago", "Mago"),
    bastonLargo(100, "baston mago pro", "Mago"),
    ballesta(100, "ballesta guerrero", "Guerrero"),
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

















