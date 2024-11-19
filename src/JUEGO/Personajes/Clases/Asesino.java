package JUEGO.Personajes.Clases;

import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;
import JUEGO.Exceptions.*;

public class Asesino extends Personaje {

    public Asesino() {
        super(100, 80, 80, 0, 30, Armas.espadaCorta);
    }

    @Override
    public void atacar(Personaje enemy) throws CorroborarException {
        if (getResistencia() < getResistenciaMax()){
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


    //falta corroborar que tenga suficiente magia para curarse
    //falta corroborar que el ph no supere un max
    @Override
    public void curarse() throws CorroborarException {
        int nivel = getLevel();
        int costo = 20;
        boolean puedeCurarse = false;
        //primero corroborar que tenga suficiente magia

        if (getMagia()>=costo){
            System.out.println("El coste de aumentar PH y resistencia es de 15 de magia");
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
                curarAtributo("ph",10);
                curarAtributo("resistencia", 10);
            } else if (nivel > 2 && nivel <= 4){
                curarAtributo("ph",15);
                curarAtributo("resistencia", 15);
            } else if(nivel > 4 && nivel <=6){
                curarAtributo("ph",20);
                curarAtributo("resistencia", 20);
            } else if(nivel > 6 && nivel<= 8){
                curarAtributo("ph",25);
                curarAtributo("resistencia", 25);
            } else {
                curarAtributo("ph",30);
                curarAtributo("resistencia", 30);
            }
        }
    }

//    //Resistencia es algo que se puede hacer en todos los niveles lo hacemos un metodo
//
//    public void curarResistencia(int cantCurar) throws CorroborarException {
//        int diferenciaResistencia = 0;
//        if ((getResistencia()) < getResistenciaMax()){
//            diferenciaResistencia = getResistenciaMax() - getResistencia();
//            if (diferenciaResistencia >= 10){
//                setResistencia(getResistencia() + 10);
//            } else if (diferenciaResistencia < 10){
//                setResistencia(getResistencia() + diferenciaResistencia);
//            } else{
//                throw new CorroborarException("No es posible aumentar la resistencia ya esta al maximo\n");
//            }
//            System.out.println("Aumentaste la resistencia. \n" +
//                    "Resistencia actual: " + getResistencia());
//        }
//    }
//
//    //ya que curar PH es algo que se puede hacer en todos los niveles lo hacemos un metodo
//    public void curarPH(int cantCurar) throws CorroborarException {
//        int diferenciaPH = 0;
//
//        if ((getPH())<getPHMax()){
//            diferenciaPH = getPHMax() - getPH();
//            if (diferenciaPH >= cantCurar) {
//                setPH((getPH()) + cantCurar);
//            } else if (diferenciaPH < cantCurar){
//                setPH(getPH() + diferenciaPH);
//            } else{
//                throw new CorroborarException("No es posible aumentar el PH ya que ya esta al maximo\n");
//            }
//            System.out.println("Aumentaste el PH. \n" +
//                    "PH actual: " + getPH());
//        }
//    }


}

