package JUEGO.Personajes.Enemigos;

import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Enemigo extends Personaje {

    private Armas arma;

    public Enemigo(int PH, int fuerza, int magia, int resistencia, int level) {
        super(PH, fuerza, magia, resistencia, level , Armas.cuchillo );
    }

    @Override
    public void atacar(Personaje enemy) {
        System.out.println("🔪 ¡El enemigo ataca con una daga afilada! 🔪");
        System.out.println(
                        "      //\\n" +
                        "     /  /\\n" +
                        "     -  /\n" +
                        "      ||\n" +
                        "      ||\n" +
                        "      ||\n" +
                        "      ||\n" +
                        "     ==== \n" +
                        "    ||||||\n" +
                        "    ||||||\n" +
                        "      ||");
        setResistencia(getResistencia() - 20 );
        enemy.setPH(getPH()-10);
    }

    @Override
    public void curarse() {

    }


}
