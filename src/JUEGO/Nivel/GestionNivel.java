package JUEGO.Nivel;
import JUEGO.Armas.Armas;
import JUEGO.ControlPantalla;
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

    public int getPuntuacion() {
        return puntuacion;
    }


    public Queue<Nivel> crearTrayecto (){

        Queue <Nivel> niveles = new LinkedList<>();

        //----------------ENEMIGOS------------------------------------
        Enemigo enemigo1 = new Enemigo(60, 50, 20, 1, 15, Armas.cuchillo, "enemigo1");
        Enemigo enemigo2 = new Enemigo(80, 70, 20, 2, 25, Armas.bastonCorto, "enemigo2");
        Enemigo enemigo3 = new Enemigo(100, 70, 20, 3, 40, Armas.espadaCorta,"enemigo3");
        Enemigo enemigo4 = new Enemigo(120, 70, 20, 4, 50, Armas.dagaFilosa,"enemigo4");
        JefeFinal enemigo5 = new JefeFinal(130, 70, 20, 5, 60, Armas.espadaGrande,"jefe final");
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

        niveles.add(nivel5);

        return niveles;
    }

    public void mostrarNiveles(Queue<Nivel> niveles) {
        for (Nivel nivel : niveles) {
            System.out.println("Nivel " + nivel.getDificultad());
            for (Puerta puerta : nivel.getPuertas()) {
                System.out.println("    Puerta: " + puerta);
            }
        }
    }

    public void Trayecto () throws CorroborarException {
        Queue<Nivel> niveles = crearTrayecto();
        Puerta puerta = null;
        Boolean win = true;

        mostrarNiveles(niveles);

        while (!niveles.isEmpty() && win) {
            Nivel nivel = niveles.poll();
            if (niveles != null && !niveles.isEmpty()) {

                personaje.mostrarInfo();
                System.out.println("\nEstas en el nivel " + nivel.getDificultad());
                System.out.println("══════════════════════════════════════════════════════════");
                System.out.println("                 🌟 * PUERTAS MISTERIOSAS * 🌟");
                System.out.println("══════════════════════════════════════════════════════════");
                System.out.println("                ¡Solo un valiente se atreve!       ");
                System.out.println("    Tres caminos se presentan ante ti, aventurero:  ");
                System.out.println("                                                   ");
                System.out.println("    🏰 1️⃣ - **Puerta del Desafio**: ¿Estás listo para la batalla?");
                System.out.println("    🛡️ 2️⃣ - **Puerta del Mercado**: ¿Que deseas comprar?");
                System.out.println("    🕵️ 3️⃣ - **Puerta del Misterio**: ¿Qué secretos ocultos guardará?");
                System.out.println("                                                         ");
                System.out.println("            Elige con sabiduría... tu destino te aguarda.");
                System.out.println("══════════════════════════════════════════════════════════");

                Scanner scanner = new Scanner(System.in);
                int eleccion = scanner.nextInt();
                switch (eleccion){
                    case 1:
                        ControlPantalla.limpiarPantalla();
                        System.out.println("\u001B[36m**\n" +
                                "⚔  ¡Hora de luchar!!  ⚔\n" +
                                "\n\u001B[0m");

                        // accedemos a las puertas de enemigo y hacemos la batalla
                        for (Puerta puertaEnemigo : nivel.getPuertas()) {
                            if (puertaEnemigo instanceof PuertaEnemigo) { // Verifica si es una PuertaEnemigo
                                PuertaEnemigo puertaEnem = (PuertaEnemigo) puertaEnemigo; // Cast a PuertaEnemigo
                                System.out.println("Lucharas con el enemigo que tiene el arma " + puertaEnem.getEnemigo().getArma());
                                System.out.println("Con un poder de ataque de: " + puertaEnem.getEnemigo().getPoderAtaque());
                                if (puertaEnem.combatir(personaje)) {
                                    ControlPantalla.limpiarPantalla();
                                    System.out.println("\u001B[33m" +
                                            "🎉🎉🎉 ¡Has vencido al enemigo! 🎉🎉🎉\n" +
                                            "💥 Una gran victoria, valiente guerrero 💥\n" +
                                            "✨ ¡Sigue adelante, la aventura no termina aquí! ✨\n" +
                                            "\u001B[0m"
                                    );
                                    puntuacion += 100;
                                    personaje.setMonedas(personaje.getMonedas() + 100);
                                    personaje.setLevel(personaje.getLevel() + 1);
                                } else {
                                    System.out.println("\u001B[31m" +
                                            "💀═══════════════════════════════════════💀\n" +
                                            "       Has sido derrotado...             \n" +
                                            "   ¡Vuelve a intentarlo, guerrero valiente!  \n" +
                                            "💀═══════════════════════════════════════💀\n" +
                                            "\u001B[0m"
                                    );
                                    win = false;
                                }
                                break; // Termina el ciclo después de la batalla
                            }
                        }
                        break;
                    case 2:
                        ControlPantalla.limpiarPantalla();
                        System.out.println("\u001B[35m" +
                                        "🛒══════════════════════════════════🛒\n" +
                                        "       ¡Bienvenido al mercado mágico!       \n" +
                                        "   ¡Prepárate para equiparte con lo mejor!  \n" +
                                        "🛒══════════════════════════════════🛒\n" +
                                        "\u001B[0m");

                        puerta = (PuertaTienda) nivel.getPuerta(eleccion -1);
                        puntuacion = puntuacion + ((PuertaTienda) puerta).compras(personaje);

                        break;
                    case 3:
                        ControlPantalla.limpiarPantalla();
                        System.out.println("\u001B[33m" +
                                "╔═══════════════════════════════════════════════╗\n" +
                                "║          💪 ¡POTENCIANDO TU FUERZA! 💪        ║\n" +
                                "║     Prepárate para desatar tu poder máximo!   ║\n" +
                                "╚═══════════════════════════════════════════════╝\n" +
                                "\u001B[0m"
                        );


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
                System.out.println(
                        "╔═══════════════════════════════════════════════════╗\n" +
                        "║           ✨ ¡HORA DE LA BATALLA FINAL! ✨       ║\n" +
                        "║       ¿Estás listo para enfrentarte al destino?   ║\n" +
                        "╚═══════════════════════════════════════════════════╝\n"
                );


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
                    System.out.println("\u001B[31m" +
                            "╔════════════════════════════════════════════════════════╗\n" +
                            "║               💀 GAME OVER 💀                          ║\n" +
                            "╠════════════════════════════════════════════════════════╣\n" +
                            "║  Te derrotó el jefe final...                           ║\n" +
                            "║  Pero no eres el primero que falla. ¡Sigue así! 💪     ║\n" +
                            "╚════════════════════════════════════════════════════════╝\n" +
                            "\u001B[0m");
                    win = false;
                }            }
        }
    }
}
