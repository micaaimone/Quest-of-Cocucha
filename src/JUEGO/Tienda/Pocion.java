package JUEGO.Tienda;

public enum Pocion {
    PH(30),
    MAGIA(30),
    RESISTENCIA(30);

    private final int precio;

    Pocion(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
