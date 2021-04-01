import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneSeatingSystem {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        AirplaneMenu menu = new AirplaneMenu();
        while(true){
            // made by gorp airlines
            // menu.printPlane();
            menu.getType(input);
            menu.getPeople(input);
            menu.getPreferences(input);
            menu.getResults();
            menu.clear();
        }
    }
}