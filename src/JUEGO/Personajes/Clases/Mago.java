package JUEGO.Personajes.Clases;

import JUEGO.Exceptions.CorroborarException;
import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;

public final class Mago extends Personaje {
    public Mago() {
        super(100, 150, 50, 0, 30 , Armas.bastonCorto);
    }

    @Override
    public void atacar(Personaje enemy) throws CorroborarException {
        if (getMagia() >= 15){
            System.out.println("\n✨🔮 ¡Ataque Mágico! ¡La magia se desata! 🔮✨\n");
            System.out.println(
                            "         @\n" +
                            "        @@@\n" +
                            "         |\n" +
                            "        ( )\n" +
                            "         |\n" +
                            "        ( )\n" +
                            "         |\n" +
                            "         | \n" +
                            "         | \n" +
                            "         | \n"
            );
            setMagia(getMagia() - 15);

            enemy.setPH(enemy.getPH() - getPoderAtaque());
        }else{
            throw new CorroborarException("No tiene suficinete magia\n");
        }
    }

    //a esta opcion es necesario poner el limite de vida pero no se me ocurre
    @Override
    public void curarse() throws CorroborarException {
        int nivel = getLevel();

        int costo = 0;
        boolean puedeCurarse = false;
        //primero corroborar que tenga suficiente magia

        if ( nivel <= 3) {
            costo = 20;
        } else if (nivel > 3 && nivel <= 6) {
            costo = 30;
        } else {
            costo = 40;
        }

        if (getMagia()>=costo){
            System.out.println("El coste de aumentar PH y resistencia es de 15 de magia");
            setMagia(getMagia() - costo);
            System.out.println("Magia actual: " + getMagia());
            puedeCurarse = true;
        } else {
            throw new CorroborarException("La cantidad de magia no es suficiente");
        }

        if (puedeCurarse) {

            System.out.println("Elegiste curacion");
            //segun el nivel es el tipo de curacion que puede recibir
            if (nivel >= 0 && nivel <= 3) {
                curarAtributo("ph",25);
                setMagia(getMagia() - 20);
            } else if (nivel > 3 && nivel <= 6) {
                curarAtributo("ph",50);
                setMagia(getMagia() - 30);
            } else {
                curarAtributo("ph",75);
                setMagia(getMagia() - 40);
            }

        }
    }
}
