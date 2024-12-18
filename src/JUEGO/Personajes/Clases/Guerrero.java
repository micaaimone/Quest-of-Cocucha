package JUEGO.Personajes.Clases;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;

public final class Guerrero extends Personaje {

    public Guerrero() {super(200, 10, 120, 0, 30, Armas.espadaCorta);
    }


    @Override
    public void atacar(Personaje enemy) throws CorroborarException {
        if (getResistencia() >= 20) {
            System.out.println("\n⚔️ ¡El personaje ataca con una espada poderosa! ⚔️\n");
            System.out.println(
                            "         *                         \n" +
                            "         ||            ---⚡⚡⚡---   \n" +
                            "        ||||          ¡Corte feroz!\n" +
                            "        ||||                       \n" +
                            "        ||||                       \n" +
                            "        ||||              ---⚡⚡⚡---\n" +
                            "        ||||                       \n" +
                            "        ||||                       \n" +
                            "        ||||                       \n" +
                            "   <===<====>===>                  \n" +
                            "        ||||                       \n" +
                            "        ||||                       \n" +
                            "        ||||                       \n" +
                            "         ||                        \n"
            );
            System.out.println("\n🔥 El enemigo recibe un impacto devastador. 🔥");
            setResistencia(getResistencia()- 20);

            enemy.setPH(enemy.getPH()-getPoderAtaque());
        }else{
        throw new CorroborarException("No tiene suficinete resistencia\n");}
    }

    @Override
    public void curarse() {
        System.out.println("Eres un guerrero, no puedes curarte\n");
    }
}
