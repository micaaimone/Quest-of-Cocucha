package JUEGO.Personajes.Clases;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;

public class Guerrero extends Personaje {

    public Guerrero() {super(180, 100, 1, 120, 0, Armas.espadaGrande);
    }


    @Override
    public void atacar(Personaje enemy) throws CorroborarException {
        if (getResistencia() < getResistenciaMax()) {
            System.out.println("\n⚔️ ¡El personaje ataca con una espada poderosa! ⚔️\n");
            System.out.println(
                            "         * \n                       " +
                            "         ||\n          ---⚡⚡⚡---\n" +
                            "        ||||          ¡Corte feroz!\n" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "        ||||              ---⚡⚡⚡---\n" +
                            "        ||||\n          \n" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "   <===<====>===>" +
                            "        ||||\n" +
                            "        ||||\n" +
                            "        ||||\n   " +
                            "         || \n   "
            );
            System.out.println("\n🔥 El enemigo recibe un impacto devastador. 🔥");
            setMagia(getResistencia()- 20);

            enemy.setPH(enemy.getPH() - 30);
        }else{
        throw new CorroborarException("No tiene suficinete resistencia\n");}
    }

    @Override
    public void curarse() {
    }
}
