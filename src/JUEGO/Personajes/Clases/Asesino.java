package JUEGO.Personajes.Clases;

import JUEGO.Armas.Armas;
import JUEGO.Personajes.Personaje;
import JUEGO.Exceptions.*;

public final class Asesino extends Personaje {

    public Asesino() {
        super(100, 80, 80, 0, 30, Armas.cuchillo);
    }

    @Override
    public void atacar(Personaje enemy) throws CorroborarException {
        if (getResistencia() >= 15){
            System.out.println("\n🖤🗡️ ¡El asesino se acerca y clava su daga! 🗡️🖤\n");

            System.out.println(
                            "        ^\n" +
                            "       |||\n" +
                            "       |||\n" +
                            "       |||\n" +
                            "      [|||]\n" +
                            "      [|||]\n" +
                            "      [|||]\n" +
                            "   (=========)\n" +
                            "    +       /\n" +
                            "     +     /\n" +
                            "      +   /\n" +
                            "       + /\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |"   +
                            "        *    "
            );

            //aca llamamos al ataque
            setResistencia(getResistencia()- 10);
            enemy.setPH(enemy.getPH() - getPoderAtaque());
            //corroborar que el enemigo muera, lanzar un msj dependiendo de eso. (iria en enemigo?)

            System.out.println("Ataque realizado. Resistencia actual: " + getResistencia() + ", PH enemigo: " + enemy.getPH());

        } else {
            throw new CorroborarException("No tienes suficiente resistencia para realizar este ataque \n");
        }
    }


    @Override
    public void curarse() throws CorroborarException {
        int nivel = getLevel();
        int costo = 20;
        boolean puedeCurarse = false;
        //primero corroborar que tenga suficiente magia

        if (getMagia()>=costo){
            System.out.println("El coste de aumentar PH y resistencia es de 20 de magia");
            setMagia(getMagia() - costo);
            System.out.println("Magia actual: " + getMagia());
            puedeCurarse = true;
        } else {
            throw new CorroborarException("La cantidad de magia no es suficiente");
        }

        if (puedeCurarse){
            System.out.println("Elegiste curacion");
            //segun el nivel es el tipo de curacion que puede recibir
            //al ser personaje asesino, recupera tanto vida como resistencia

            //crear excepcion para corrobar que no sea negativo el nro

            if (nivel <= 2){
                curarAtributo("ph",30);
                curarAtributo("resistencia", 10);
            } else if (nivel > 2 && nivel <= 4){
                curarAtributo("ph",35);
                curarAtributo("resistencia", 15);
            } else if(nivel > 4 && nivel <=6){
                curarAtributo("ph",40);
                curarAtributo("resistencia", 20);
            } else if(nivel > 6 && nivel<= 8){
                curarAtributo("ph",45);
                curarAtributo("resistencia", 25);
            } else {
                curarAtributo("ph",50);
                curarAtributo("resistencia", 30);
            }
        }
    }


}

