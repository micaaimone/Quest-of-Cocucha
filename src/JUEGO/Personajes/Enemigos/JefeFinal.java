package JUEGO.Personajes.Enemigos;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class JefeFinal extends Personaje {
    private String nombre;

    public JefeFinal(int PH, int magia, int resistencia, int level, int poderAtaque, Armas arma, String nombre) {
        super(PH, magia, resistencia, level, poderAtaque, arma);
        this.nombre = nombre;
    }

    public JefeFinal() {
    }

    @Override
    public void atacar(Personaje enemy) throws CorroborarException {
        System.out.println("\n🔨💥 ¡Martillazo! ¡Un golpe contundente! 💥🔨\n");
        System.out.println(
                "   _______  \n" +
                " /|   *   | \n" +
                "/_|_______| \n" +
                "     ||     \n" +
                "     ||    \n" +
                "     ||    \n" +
                "     ||    \n "  +
                "     $$     \n ");
        enemy.setPH(enemy.getPH()-getPoderAtaque());
    }

    @Override
    public void curarse() throws CorroborarException {

    }
}
