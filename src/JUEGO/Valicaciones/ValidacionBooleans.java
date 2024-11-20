package JUEGO.Valicaciones;

import JUEGO.Exceptions.EntradaInvalidaException;

public class ValidacionBooleans {
    public static boolean validarBooleano(String scanner) throws EntradaInvalidaException {
        boolean valido;
        if (scanner.equalsIgnoreCase("si")) {
            valido = true;

        } else if (scanner.equalsIgnoreCase("no")) {
            valido = false;
        } else {
            throw new EntradaInvalidaException("La entrada '" + scanner + "' no es válida. Solo se permite 'si' o 'no'. \n");
        }
        return valido;
    }
}
