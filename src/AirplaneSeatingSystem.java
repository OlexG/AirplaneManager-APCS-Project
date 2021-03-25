import java.util.ArrayList;
import java.util.Scanner;
public class AirplaneSeatingSystem {
    public static void main(String args[]){
        ArrayList<String> preferences = new ArrayList<>();
        preferences.add("window");
        preferences.add("aisle");
        AirplaneMenu menu = new AirplaneMenu();
        Airplane airplane = new Airplane();
        String result = airplane.findSeats(2, "economy", preferences);
        System.out.println(result);
        result = airplane.findSeats(2, "economy", preferences);
        System.out.println(result);
        menu.printPlane();
    }

}




