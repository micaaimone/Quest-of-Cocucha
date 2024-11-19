package JUEGO.Personajes.Clases;

import JUEGO.Personajes.Clases.Armas.Armas;
import JUEGO.Personajes.Personaje;
import JUEGO.Exceptions.*;

public class Asesino extends Personaje {

    public Asesino() {
        super(100, 80, 80, 80, 0 , Armas.cuchillo);
    }

    @Override
    public void atacar(Personaje enemy) {
        System.out.println("lanzando ataque de fuerza");
        setMagia(getResistencia()- 10);

        enemy.setPH(enemy.getPH() - 30);
    }


    //falta corroborar que tenga suficiente magia para curarse
    //falta corroborar que el ph no supere un max
    @Override
    public void curarse() throws CorroborarException {
        int nivel = getLevel();
        int costo = 20;
        boolean puedeCurarse = false;
        int diferenciaPH = 0;
        int diferenciaResistencia = 0;
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
            switch (nivel){
                case 1:
                    if ((getPH())<getPHMax()){
                        diferenciaPH = getPHMax() - getPH();
                        if (diferenciaPH >= 10) {
                            setPH((getPH()) + 10);
                        } else if (diferenciaPH < 10){
                            setPH(getPH() + diferenciaPH);
                        } else{
                            throw new CorroborarException("No es posible aumentar el PH ya que ya esta al maximo\n");
                        }
                        System.out.println("Aumentaste el PH. \n" +
                                "PH actual: " + getPH());
                    }

                    if ((getResistencia()) < getResistenciaMax()){
                        diferenciaResistencia = getResistenciaMax() - getResistencia();
                        if (diferenciaResistencia >= 10){
                            setResistencia(getResistencia() + 10);
                        } else if (diferenciaPH < 10){
                            setResistencia(getResistencia() + diferenciaPH);
                        } else{
                            throw new CorroborarException("No es posible aumentar la resistencia ya esta al maximo\n");
                        }
                        System.out.println("Aumentaste la resistencia. \n" +
                                "Resistencia actual: " + getResistencia());
                    }


                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;

            }
        }

    }
}

