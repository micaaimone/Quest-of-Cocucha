package JUEGO.Personajes.Enemigos;

import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Enemigo extends Personaje {

    private Armas arma;


    public Enemigo() {
    }

    @Override
    public void atacar(Personaje enemy) {
        System.out.println("\n🔪 ¡El enemigo ataca con una daga afilada! 🔪\n");
        System.out.println(
                        "      //\\n" +
                        "     /  /\\n" +
                        "     /  /\n" +
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
