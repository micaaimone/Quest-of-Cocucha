package JUEGO.Valicaciones;

import JUEGO.Exceptions.EntradaInvalidaException;

public class ValidacionBooleans {
    public static boolean validarBooleano(String scanner) throws EntradaInvalidaException {
        if (scanner.equalsIgnoreCase("true")) {
            return true;
        } else if (scanner.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw new EntradaInvalidaException("La entrada '" + scanner + "' no es válida. Solo se permite 'true' o 'false'. \n");
        }
    }
}
