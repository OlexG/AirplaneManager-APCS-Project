import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneMenu {

    Scanner input = new Scanner(System.in);
    public ArrayList<String> getPreferences(Scanner in){
        //aisle center window (max size 3 for input 1-3)
        //asks for input using in
        System.out.println("What is your seating preference");
    }

    public void printPlane(){
        
        
        String planeType =
        "                                                                                __\n"  +
        "                                                                               /  \\" + "\n" +
        "                                                                              /    \\" + "\n" +
        "                                                                             |      |\n " +
        "                                                                            |  First |\n" +
        "                                                                            |1 2  3 4|\n" +
        "                                                                           a|o o||o o|\n" +
        "                                                                           b|o o||o o|\n" +
        "                                                                           c|o o||o o|\n" +
        "                                                                           d|o o||o o|\n" +
        "                                                                            |  Econ  |\n" +
        "                                                                            |123  456|\n" +
        "                                                                           a|ooo||ooo|\n" +
        "                                                                       __--b|ooo||ooo|---__\n" +
        "                                                         ___------------   c|ooo||ooo|   ------------___\n" +
        "                                            ___------------                d|ooo||ooo|                  ------------___\n" +
        "                                _____------                                e|ooo||ooo|                                  ------_____\n" +
        "                       ______---                                           f|ooo||ooo|                                             ---______\n" +
        "               _______-                                                    g|ooo||ooo|                                                     -_______\n" +
        "              /                                                            h|ooo||ooo|                                                             \\" + "\n" +
        "           __=                                                             i|ooo||ooo|                                                              =__\n" +
        "          /                 =======================================        i|ooo||ooo|         =======================================                  \\" + "\n" +
        "         |            ==========                                   ====    j|ooo||ooo|     ====                                   ==========             |\n" +
        "        /       =======                                                 ===k|ooo||ooo|====                                                  =======       \\" + "\n" +
        "        /======                                                            l|ooo||ooo|                                                               ======\\" + "\n" +
        "                                                                           m|ooo||ooo|\n" +
        "                                                                           n|ooo||ooo|\n" +
        "                                                                            |        |\n" +
        "                                                                            |---  ---|\n"  +
        "                                                                     ____---|  |  |  |---____\n" +
        "                                                          _____------       |---  ---|       ------_____\n" +
        "                                                        |                  |        |                  |\n" +
        "                                                        |                   |        |                   |\n" +
        "                                                      /    ________________|        |________________    \\" + "\n" +
        "                                                     |________|            \\________/           |________|";

        System.out.println(planeType);
    
    }
}


