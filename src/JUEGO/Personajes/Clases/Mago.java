package JUEGO.Personajes.Clases;

import JUEGO.Personajes.Personaje;

public class Mago extends Personaje {
    public Mago() {
        super(100, 10, 150, 50, 0);
    }

    @Override
    public void atacar(Personaje enemy) {
        System.out.println("lanzando ataque de magia");
        setMagia(getMagia()- 20);

        enemy.setPH(enemy.getPH() - 30);
    }

    //a esta opcion es necesario poner el limite de vida pero no se me ocurre
    @Override
    public void curarse() {
        int nivel = getLevel();
        int vida = getPH();
        System.out.println("Elegiste curacion");
        //segun el nivel es el tipo de curacion que puede recibir
        if (nivel >= 0 && nivel <= 3){
            vida = vida + 25;
            setMagia(getMagia()- 20);
        }
        else if(nivel > 3 && nivel <= 6){
            vida = vida + 50;
            setMagia(getMagia()- 30);
        }
        else{
            vida = vida + 75;
            setMagia(getMagia()- 40);
        }

        setPH(vida);
    }
}
