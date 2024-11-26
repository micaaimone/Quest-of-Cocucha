package JUEGO.Nivel;
import JUEGO.Armas.Armas;
import JUEGO.Exceptions.CorroborarException;
import JUEGO.Personajes.*;
import JUEGO.Personajes.Enemigos.Enemigo;
import JUEGO.Personajes.Enemigos.JefeFinal;
import JUEGO.Tienda.Tienda;

import java.util.*;

public class GestionNivel {
    private Personaje personaje;
    private int puntuacion;


    public GestionNivel(Personaje personaje) {
        this.personaje = personaje;
        this.puntuacion = 0;
    }

    public LinkedList crearTrayecto (){

        Queue <Nivel> niveles = new LinkedList<>();

        //----------------ENEMIGOS------------------------------------
        Enemigo enemigo1 = new Enemigo(60, 50, 20, 1, 15, Armas.cuchillo);
        Enemigo enemigo2 = new Enemigo(80, 70, 20, 2, 25, Armas.bastonCorto);
        Enemigo enemigo3 = new Enemigo(100, 70, 20, 3, 40, Armas.espadaCorta);
        Enemigo enemigo4 = new Enemigo(120, 70, 20, 4, 50, Armas.dagaFilosa);
        JefeFinal enemigo5 = new JefeFinal(130, 70, 20, 5, 60, Armas.espadaGrande);
        //-------tienda--------------------------------------------
        Tienda tienda1 = new Tienda();
        //-------Puertas--------------------------------------------
        PuertaEnemigo puertaEnemigo1 = new PuertaEnemigo(enemigo1);
        PuertaEnemigo puertaEnemigo2 = new PuertaEnemigo(enemigo2);
        PuertaEnemigo puertaEnemigo3 = new PuertaEnemigo(enemigo3);
        PuertaEnemigo puertaEnemigo4 = new PuertaEnemigo(enemigo4);
        PuertaEnemigo puertaEnemigo5 = new PuertaEnemigo(enemigo5);
        //PUERTAS TIENDA
        PuertaTienda puertaTienda1 = new PuertaTienda(tienda1);

        //-------niveles--------------------------------------------
        Nivel nivel1 = new Nivel(1);
        nivel1.agregarPuerta(puertaEnemigo1);
        nivel1.agregarPuerta(puertaTienda1);

        niveles.add(nivel1);

        //--
        Nivel nivel2 = new Nivel(2);
        nivel2.agregarPuerta(puertaEnemigo2);
        nivel2.agregarPuerta(puertaTienda1);

        niveles.add(nivel2);

        //--
        Nivel nivel3 = new Nivel(3);
        nivel3.agregarPuerta(puertaEnemigo3);
        nivel3.agregarPuerta(puertaTienda1);

        niveles.add(nivel3);

        //--
        Nivel nivel4 = new Nivel(4);
        nivel4.agregarPuerta(puertaEnemigo4);
        nivel4.agregarPuerta(puertaTienda1);

        niveles.add(nivel4);

        //--
        Nivel nivel5 = new Nivel(5);
        nivel5.agregarPuerta(puertaEnemigo5);


        return (LinkedList) niveles;
    }

    public void Trayecto () throws CorroborarException {
        Queue<Nivel> niveles = crearTrayecto();
        Puerta puerta = null;
        Boolean win = true;

        while (!niveles.isEmpty() && win) {
            Nivel nivel = niveles.poll();
            if (niveles != null && !niveles.isEmpty()) {


                System.out.println("Elija una de las 3 puertas (1, 2 o 3):");
                Scanner scanner = new Scanner(System.in);
                int eleccion = scanner.nextInt();
                switch (eleccion){
                    case 1:
                        System.out.println("Hora de luchar!!\n");
                        puerta = (PuertaEnemigo) nivel.getPuerta(eleccion -1);
                        if (((PuertaEnemigo) puerta).combatir(personaje)){
                            System.out.println("has vencido al enemigo!\n");
                        }else {
                            System.out.println("has sido derrotado, vuelva a intentarlo!\n");
                            win = false;
                        }
                        break;
                    case 2:
                        System.out.println("Vamos de compras\n");

                        puerta = (PuertaTienda) nivel.getPuerta(eleccion -1);
                        puntuacion = puntuacion + ((PuertaTienda) puerta).compras(personaje);

                        break;
                    case 3:
                        System.out.println("vamos a aumentar tu fuerza!\n");

                        try {
                            personaje.subirNivel();
                        } catch (CorroborarException e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    default:
                        System.out.println("ingrese una de las 3 puertas\n");
                        break;
                }
            } else{
                System.out.println("hora de la batalla final\n");

                puerta = (PuertaEnemigo) nivel.getPuerta(0);
                if (((PuertaEnemigo) puerta).combatir(personaje)){
                    System.out.println("Felicidades, has completado el ultimo nivel\n aqui tienes tu merecida cocucha de vidrio\n" +
                            " .::..::. ::. ::...:: .::..::. :: .::..::. ::. ::...:::=++=##*++++-.::..::. ::. ::...:: .:: .::..:: \n" +
                            ":: .::..::. ::...:: .:: .:: .::. :: .::..::. ::..:-=***+#####*==-:---==:..::. ::..:::..:: .:: .::. :\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..:::***+++*#***++*****+--*-:..::..::...::..::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..:+****:..*#*-:::::-+**=..::..::..:::..::..::..::..:\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..::.-*+*:..:##*==-==---+=-::..::..::...:...::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..:+**+..:=#*++-:::::-===:.::..::..::...:...::..::..:\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..=****-::=#*+==-:::::-+=-.::..::..::...::..::..::..:\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..::*****#*****+++=-::::-+==:..::..::...::..::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..+****+=**######****++++=.::..::..:::..::..::..::..:\n" +
                            " .::..::. ::. ::...:: .::..::. :: .::..::. ::. :::*###*+==++++----+*###-::. ::. ::...:: .:: .::..:: \n" +
                            ":: .::..::. ::...:: .:: .:: .::. :: .::..::. ::..:-**+.:..:**=--:::==+=:..::. ::..:::..:: .:: .::. :\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..::..=*-....=*++=======*-.::..::..::...::..::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..::*++-..-#*+=-::---=*=-..::..::..:::..::..::..::..:\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..::.:#++=.:=#*==-:----=*=-::..::..::...:...::..::..::.\n" +
                            "::..::..::...:...:...:...::..::..::..::..::...:...-*++-.:+*+==-::::-=+==..::...:...:...:...::..::..:\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..:*+++::-+*===:::::-=++=..::..::..:::..::..::..::..:\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..::-*++=:--*+===-::::-=++=-:..::..::...::..::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..::..+*++=.-=*++=--::.:-=+*=-.::..::..:::..::..::..::..:\n" +
                            " .::..::. ::. ::...:: .::..::. :: .::..::. ::. :=**++-.=+*++==-::.:-=++==:. ::. ::...:: .:: .::..:: \n" +
                            ":: .::..::. ::...:: .:: .:: .::. :: .::..::. ::.+*+++:-=+*+===-:...:==++=:::. ::..:::..:: .:: .::. :\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..=*+++=:+=+*++=--:...::=+*==..::..::...::..::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..::..::..:-**+++==++**+=----....:-=*==-:..::..:::..::..::..::..:\n" +
                            "..::...:...:...:...:...::..::..::..::...:...::##+===+==-=+=+++===::--:=++=+:::...:...:...::..::..::.\n" +
                            "::..::..::...:...:...:...:...::..::...:..::..+%#%%%%=+#%%%%%%%%%%#%%#*#+-=-+:..:...:...:...:...::..:\n" +
                            "::..::..::..::...::..::..::..::..::.-=-..::.=%@%%%%%-**@%%%%%%%@%%%#@%%%**++-.::..:::..::..::..::..:\n" +
                            "..::..::..::..::...::..::..::..-+*****++++++%%@@@%%###%%#%%%@#%@%%@%%%%%%#+=+-..::...::..::..::..::.\n" +
                            "::..::..::..::...::..::..::.-+*****++++++=*#%%@@@%@***%@@@%%@##@-%@%%%%%%%*==+::..:::..::..::..::..:\n" +
                            " .::..::. ::. ::...:: .::.+****++======+++=#%%@@%@#+*%%@@@%%%#%@%%@%%%%%%%#+==+.::...:: .:: .::..:: \n" +
                            ":: .::..::. ::...:: .::..****+==+++++=++++=*%%@@@%**##%%@%%%#*#@%%%%%%%#%%%*==+=..:::..:: .:: .::. :\n" +
                            "..::..::..::..::...::..:++++==+=-------=+++=%%@@@*+*#%@@@@%%**#%%%%@@%%##%%*+==+::...::..::..::..::.\n" +
                            "::..::..::..::...::..:::++===---==++++++-=+=#%@@@**#*%%%%@@%**#@-#%@%%%**%%%*+==+.:::..::..::..::..:\n" +
                            ".......................:++==-=++++++++++**==#%@@#*##%%*%%@@%**#%%%%%%%%#*#%%#++++=...............:..\n" +
                            "..::...:...:...:...:...:++=--*++++++==+=-===#%@@+**=-::::-*%%#*%%%%%%%%%**%%#*++++:..:...::..:...::.\n" +
                            "::  ::..::. ::...:: .::.++==#*=+++=:::----==#%@@-:+#%#%%%%%@@%@@@@%#*++#%*#%%**++++-: .:: .::..::. :\n" +
                            "..::..::..::..::...::..:++=+#+-=::::::::--=+%%%%%=%%#%%%%%@@@@@@@@@@@@@@%#%*##**+++-.::..::..::..::.\n" +
                            "::..::..::..::...::..::.:++=*---:::::::--==#%#*%%%%%%%%%%@@@@@@@@@%#%#*%%#%@%%##**++:..::..::..::..:\n" +
                            " .::. ::. ::. ::...::+###*++=---:::-----==###*%%%%%%%%#%##%%##*+@*%*%*#*%%#%#%%%%%**=:: .:: .::..:: \n" +
                            ":: .::..::. ::..:=*********++=--------==+*#%%@%%%+##+####%#%*@%%*##%#**%%%%%*%%##*%%*..:: .::..::. :\n" +
                            "..::..::..::.-*##***+++****##++=======+###%%#%#*+%#%%###%%%*@@=-#%%%%%%%%%%%#*%*##*#*-:..::..::..::.\n" +
                            "::..::..::..*###*++******###%%##***#%@#%#%#*%%#=%#%%*:%#*%**#%-%#*%#%%#*%%#%*##+%%%##=.::..::..::..:\n" +
                            "::...:..:::***++++****++++++*%%%%%%#@%##@=%#%*%-@#%*%:#%#%%#@##*#*#%*#%##*+*%*#%%%###*::...::..::..:\n" +
                            "..::..::..-**+++++++*****++++=*#%%#%@*%#%%@%#%%*=#%%%##%@@@@@#%+%@%#%*#%*#%%#%%+*##*#+-..::..::..::.\n" +
                            "::  ::..::+*+++++*******++++****+*#%@+%#@*+%%%###*#%+=**#**@@%*%#*#@%+%%#%=#%%##%*****+:: .::..::. :\n" +
                            "..::..::..=#+++***##**+++====-=+++*%@##%%%%%##%%%%%%%%%@@@@@@@@@@@@@@%%%%%=%##@+**#+#**..::..::..::.\n" +
                            "::..::..::-**++*#**++=====----=-===*%%%%%%%%%%%%**%%+#%*###@+#%%#@%*#*%@@%%%%%###+*#**+-:..::..::..:\n" +
                            " .::. ::..:=***#*+=--------======-==%%%%%#%**##%=#%%=#+##=+%+*#%%@#*%+%#%%#=*#%%%%#****-.:: .::..:: \n" +
                            ":: .::..::..:***==-:---==========+==+%#%%%%**#%@-%%%=%*+#*%#***%#%#%#*@##%#####*%+#****+: .::..::. :\n" +
                            "..::..::..::..++=-=-===++=+====-====+*%%%%##%%%%%%##%%%%%@%%%%%%%@@%%@%%%%#*###*%***#+#+:::..::..::.\n" +
                            "::..::..::..::=*====++++====++=+=--=++#%%%%%%#=-#++-%#%+*%=#@*%@%@*#%@%#%%@@%%%*%#*+*##*:..::..::..:\n" +
                            "::..::..::...::*+==+++===+==+++++++--=+#%#%#+#+*==--##%+%%##%*%@@%*%%#%*@+%%*%#%%%#*#***:..::..::..:\n" +
                            "..::..::..::..:-*+=++===++++++++++++=-=+%#%**+:*-=*+*#%#%#%%%#%#%%%#%%@#@*#%%##%%###*+++:::..::..::.\n" +
                            "::  ::..::..-+###*======++++++++++++++-=*%%#+.::::-*##%%##%%%%#@@@@%%%%%%%%%#%%*@+#*#+++:..::..::. :\n" +
                            "..::..:-+####****#+===-++++++++++++++==-=%%%**%%%%%%##%%%@%%%*-+%%@%%%%%###%%%%%%*##*++*---..::..::.\n" +
                            ":: .::.*##*****+++#*==-++++++++==-===---=*%%+-:::-#**@@@@@%%%##*%%%@@@@@@@@%%%%%%#**+++*++===+=-:..:\n" +
                            " .::..+#****++*****#+===*++++==+=-:::----=%%+-...:@***%@@@@%%##*#@@%@@@@@%%%%%%%%+**++=*+------=+=:.\n" +
                            "::..-##************##+===*+=--::::::-----+%%*=...-=#+%@@@@@%%##*#%@@@@@@@@%%%%%@@%#***+*=-:----=+==:\n" +
                            "..:-***++********+++%#+=-==--:::::------=#%%*+....=+++%%@@@%%##*#%#+@@@@@%%%%%%@%%##**++--::---==+=-\n" +
                            "::.**+++****+++++****%%++=----------====#%@%#=....:++#%@@@@%%##***@@@@@@@%%%%%%@%%#**+++--::----=+==\n" +
                            ":::#+++****++++**#**+#%%*+===----=====+%%%@@#=....:-+*#%@@@%%##*%@@@@@@@@%%%%%%%%%#*+=+#--------=++=\n" +
                            "..:+#++**++++*##**++==#%%#*+++++++++#%@%%%%@%=:...:=+*%%@@%%%##*#%@@@@@@@%%%%%%%%%#*+=+#=-------+++:\n" +
                            "::..*#****+**##*++===--*%########%@@@@@%#%@@%=-:::-=+%@%@@%%%##*#%@@@@@@@%%%%%%%%#**+=+**------=++=:\n" +
                            "..::.-#***+****+===----=*########%%@@@@%##%@%==--=++#%@@@@%%%####@@@@@@@%%%%%%@%%#*+++++**=--=+++=:.\n" +
                            ":: .::-*#*****+=-----====-=+***###%@@@@%##@@@++-=+++#%@%@@@%%###%%@@@@@@@%%%%%@%%#*+++++++****+=:..:\n" +
                            " .::..=+*##***+=-:-====--=++++=----=@@@@##@@%*+==++*%%@%@@%%%*#+%%%%@@@@%%%%%%@%##*+=+++++***-:..:: \n" +
                            "::..-++++*#***+---==+=-=+=++++++*+=--#@@%#%@%#+++++*#%@%@@%%%**##%%%@@@@%%%%%%%%%**+=++++++-:..::..:\n" +
                            "..:=+++++++%#**======--++=+++++++++++-*@###%#*++++##%%@%@@@@%**#%%%%@@@@@%%%%@%%%**++*++*+:..::..::.\n" +
                            ":=*++++++++*%##+=-=+=-=====++++++===---*%#%@%%+=*##%%%@%%@@%%+##%%@@@@@@%%%%%%%%##*++++*=..::..::..:\n" +
                            "-+=====+==+=*###*====-=+====++====-----+%*%@@%**+#%%%%%@%@@%%*##%%@@@@@@%%%%@%%%##*++*+::..::..::..:\n" +
                            "-++==========%%##*=====*+=====-=:::----*%*%@@%*#**#%%%@%@@@%%*##%@@%%@@@%%%%@%%%##*=+-:..::..::..::.\n" +
                            "-**++========+%%###++===*++==+-::::::--*@#%%@%*#**#%%@+*@@%%%*##%@@%%@@@%%%%@%%%##+=-..:: .::..::. :\n" +
                            ".=***++=======*%#%##*+===**==--:::-----#%#%@@%*#=*#%%%%@%@@%%*##%@@%%@@@%%%%@%%#%*++:::..::..::..::.\n" +
                            ":-*#*+++========##%###*+=:------------=%@%%@@%*#+##%%@#@%%%%%+##%@%%%@@@%%%%@%%%#*++:..:: .::..::. :\n" +
                            "..-**++*+========+######++=---------==*@@%@@@@***##%%%@@@@%%%*#%%@%%%@@@%%%%@%%%##+=::: .:: .::..:: \n" +
                            "::.+*****+==++++*+*######*==========+#@@@%@@@@*#+##%%%@@@%%%%*#%%=%%%@@@%%%@@%%%#*+=:..::..::..::..:\n" +
                            "..:=#+*###*+**+***#=######******###%@@@@@@@@@@**+##%%%@@@@%%#*#%%%%%%@@@%%%@@@%%#*+=.:...::..::..::.\n" +
                            "::..*#*++#%%#*+##*=*%###********++*%@@@@@%@@@@*+**##%@@@@@%##*#%%%%%%@@@%%%%@%%#*++*:..:...::..::..:\n" +
                            "::..:##*****###*#*+*%####*******+++@@@@%@%@@@@*+**%%%@@%@%%##*#%%%%%%@@%%#%@@@%#+++*:..::..::..::..:\n" +
                            " .::..*#%##*++*###**#%%##*******++*@@@@%@%%@%%+++###%%@@@%%##*##%%%%@@@%%%#%@%%#+=+*::: .:: .::..:: \n" +
                            ":: .::.-+++*#%%%%%#***###**##****+#@@@@*##%@%%+=++*#%%%%@%%##**#%%@@@@@%%%*%%@%#*++*-..:: .::..::. :\n" +
                            "..::..:::*####%%%%#%%#+++***##****%@@@%%%%%@%%+-=-+#%%@@@%%#***#%%@@@@@%%#*%%%%#+++++::..::..::..::.\n" +
                            ":: .::..::=***######*#%%#*++++****@@@@%%%%%@%#=-:::##%%@@%%#*+*#%%@%@%%%##*#%%%#+++++..:: .::..::. :\n" +
                            "..::..::..:-+++++++++##%##%%#++++#@@@@%%%%%%%+....+%%%%@@%%#***#%%%%@####*+*%%%#*++++=:..::..::..::.\n" +
                            "::..::..::..:==+++**###*####%%#**@@@@@%*%@%%%-....#%*%%%%%%#*+*%%%%%%%++#*++%%%%*++=++:::..::..::..:\n" +
                            "..::..::..::..:+++*********####*%@@@@%*##%%%*:...+%*##%@%%%**+*%%%%%%@%%#**=#%%%#+++++:..::..::..::.\n" +
                            "::...:..::...:.:++++++++**##****%@@@@#*#%%%%=...-**+##@%@%#**+##%%%%%#%%#**=+%%%#*+++++:...::..::..:\n" +
                            "::..::..::..::..:=+++*******+***@@@@%++*#%%#:....-=+#%%%%%%**++#%%%%@%%*#**++%%%%*+++++-:..::..::..:\n" +
                            " .::..::. ::. ::..-+++++++++*#*%@@@%%==*##%*:....-=*%*%%%%%**+=%#%%@@@%%%#+++#%#=++++++-.:: .::..:: \n" +
                            ":: .::..::. ::...::.=++***####*%@@%%#-++*#%=.....-=*#%%@%%#**+=-=%%%@@%%%*+*+*%%+=++++++: .::..::. :\n" +
                            "..::..::..::..::...::.=***+====%@@%%+==**#%:....:-=*%%%%%%#*++--:#%%@@@=##**++%%#+++++++:::..::..::.\n" +
                            ":: .::..::. ::...:::.:#*---===*%@@%%#+*##%#:....:==*%%#%###**=-..+%%@@@%%*#*++%%%++++++*:..::..::. :\n" +
                            "..::..::..::..::..=..=#*=--===#%@@%%#%%%%%+.....:==+#%%%*%**+=-..+%%@@@*+#***+#%*#+++++*-::..::..::.\n" +
                            "::..::..::..::...-...+#**-==-=%%@@%%%#%%%%+.:::::=+#+=+#%%%##+=*#####%%+*%**++##*#+++++*-..::..::..:\n" +
                            "..::..::..::...:...:.=#**====+%%@@%%**####-.+=:---+#+*##%%%%*+###****####*******#*+=+=++=::..::..::.\n" +
                            "..::...:...:...:...:...:=*===+#%@%%##**#*#==-:::::-*=-###%%%%%%%*+***+********++++++++++=::..::..::.\n" +
                            "::..::..::..::...::..::..::.-=%######*#*#====**###%###**#####%%%##**************++=====+=..::..::..:\n" +
                            " .::..::. ::. ::...:: .::..::.#######*###%%%%%%%%%%%%%%%%%%%%@%%%%%%%%%####*****%%#*+==+=:: .::..:: \n" +
                            ":: .::..::. ::...:: .:: .::..:+#####%#%%%%%%%%%%%%%%%%%%%%%%%@%%%%%%%%%%%%%%%%%##**#%#*+=..::..::. :\n" +
                            "..::..::..::..::...::..::..::..#%%%%%%%%%%%%%%@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%%%%%###=::..::..::.\n" +
                            ":: .::..::. ::...:: .:: .::..::.+%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%%%%%%#:..::..::. :\n" +
                            "..::..::..::..::...::..::..::..::.*%%%%%@@%%%%%%%%%%%%%%%%%%%%%%%%%%%#####%%%%%#%%%%%%%:.::..::..::.\n" +
                            "::..::..::..::...::..::..::..::..::..*#%%%@%%#%%%%%%%%%%%%#%%%%######%%%%%%%%%##%%%%#:.::..::..::..:\n" +
                            "..::...:...:...:...:...::..:...::..::..:::-+*#%%%%##%%%%%%%%%%%%%%%%%%%%%######*+-:..:...::..:...::.\n" +
                            "..::..::..::..::...::..::..::..::..::..::..::..::::--==+*##%%%%%%###****+-::::..::...:...::..::..::.");
                }else {
                    System.out.println("Te derroto el jefe final, pero no eres el primero que falla! sigue asi!\n");
                    win = false;
                }            }
        }
    }
}
