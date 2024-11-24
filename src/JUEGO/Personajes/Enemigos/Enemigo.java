package JUEGO.Personajes.Enemigos;

import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Enemigo extends Personaje {

    private Armas arma;

    public Enemigo(int PH, int fuerza, int magia, int resistencia, int level) {
        super(PH, fuerza, magia, resistencia, level , Armas.cuchillo );
    }

    public Enemigo() {
    }

    public Enemigo() {
    }

    public Enemigo() {
    }

    @Override
    public void atacar(Personaje enemy) {
        System.out.println("\n🔪 ¡El enemigo ataca con una daga afilada! 🔪\n");
        System.out.println(
                        "      /\\n" +
                        "     /  \\\n" +
                        "     \\ /\n" +
                        "      ||\n" +
                        "      ||\n" +
                        "      ||\n" +
                        "      ||\n" +
                        "    <====> \n" +
                        "     ||||\n" +
                        "     ||||\n" +
                        "      ||");

        enemy.setPH(getPH()-10);
    }


    @Override
    public void curarse() {

    }


}
