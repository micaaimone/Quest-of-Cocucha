package JUEGO.Personajes.Enemigos;

import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Enemigo extends Personaje {


    public Enemigo(int PH, int magia, int resistencia, int level, int poderAtaque, Armas arma) {
        super(PH, magia, resistencia, level, poderAtaque, arma);
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

        enemy.setPH(enemy.getPH()-getPoderAtaque());
    }


    @Override
    public void curarse() {

    }


}
