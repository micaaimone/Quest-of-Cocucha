package JUEGO.Armas;

public enum Armas {

    //mejorar las descripciones
    espadaCorta("Espada corta",0, "espada normal de guerrero", "Guerrero"),
    espadaGrande("Espada grande",100, "espada guerrero pro - al comprar la mejora aumenta la resistencia maxima 10 puntos(sube esos puntos automaticamente tmbn en resistencia) y aumenta el poder de ataque por 15 pts ", "Guerrero"),
    bastonCorto("Baston corto",0, "bastoncito mago", "Mago"),
    bastonLargo("Baston largo",100, "baston mago pro - al comprar la mejora aumenta la magia maxima 10 puntos(sube esos puntos automaticamente tmbn en magia) y aumenta el poder de ataque por 15 pts ", "Mago"),
    cuchillo("Cuchillo",0, "cuchillo asesino", "Asesino"),
    dagaFilosa("Daga filosa",100, "daga filosa  asesino - al comprar la mejora aumenta la resistencia maxima 10 puntos(sube esos puntos automaticamente tmbn en resistencia) y aumenta el poder de ataque por 15 pts ", "Asesino");


    private final int precio;
    private final String descripcion;
    private final String tipoPersonaje;
    private final String nombre;

    Armas(String nombre, int precio, String descripcion, String tipoPersonaje) {
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public static Armas getArmaByName(String nombreArma) {
        for (Armas arma : Armas.values()) {
            if (arma.getNombre().equalsIgnoreCase(nombreArma)) {
                return arma;
            }
        }
        return null; // O lanzar una excepción si no se encuentra el arma
    }

}

















