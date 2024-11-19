package JUEGO.Personajes.Clases;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Personaje;

public class Guerrero extends Personaje {

    public Guerrero() {super(180, 100, 1, 120, 0);
    }


    @Override
    public void atacar(Personaje enemy) {
            System.out.println("⚔️ ¡El personaje ataca con una espada poderosa! ⚔️");
            System.out.println(
                            "         //           ---⚡⚡⚡---\n" +
                            "        ||||          ¡Corte feroz!\n" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "    ===<====>===      ---⚡⚡⚡---\n" +
                            "        ||||          \n" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "         ||"
            );
            System.out.println("\n🔥 El enemigo recibe un impacto devastador. 🔥");

        setMagia(getResistencia()- 20);

        enemy.setPH(enemy.getPH() - 30);
    }

    @Override
    public void curarse() throws CorroborarException {
    }
}
