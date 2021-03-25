import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneMenu {

	public ArrayList<String> preferences = new ArrayList<String>();
	public int numberOfPeople = 0;
	public Airplane plane = new Airplane();
	public String type = "economy";

    public void getPreferences(Scanner input){
        //aisle center window (max size 3 for input 1-3), numberOfPeople is the maximum number of preferences, make sure all the preferences are different
        //asks for input using in
        System.out.println("What is your seating preference - enter them separarted by space - you cannot have duplicate preferenes and no more then the number of people you are seating");
        System.out.println("Type \"window\", \"aisle\", and \"middle\" if you are flying economy");
        /*
        Ben note to self:
        test for input past this point, "input.contains"?
        */
    }
    

	public void getPeople(Scanner input){
        System.out.println("How people are traveling together? 1-2 for first class or 1-3 for economy");
		while (!input.hasNextInt()){
			System.out.println("Please enter an integer!");
		}
		numberOfPeople = input.nextInt();
    }
	
	public void getType(Scanner input){
		System.out.println("Economy or first class? Enter \"economy\" or first");
		while (true){
			String givenType = input.next();
			if (givenType != "economy" && givenType != "first"){
				System.out.println("Please enter a valid string, economy or first");
			}
			else{
				type = givenType;
                break;
			}
		}
	}


    public void printPlane(){
        SeatRow[] first_class = plane.getFirstClass();
        SeatRow[] economy_class = plane.getEconomyClass();

        char[] first = new char [21]; 
        char[] economy = new char [91]; 
        
        int n1 = 0;
        int n2 = 0;

        for (int x = 0; x < 5; x++){
            for (int i = 0; i < 4; i++){
                if (first_class[x].getSeat(i)){
                    first[n1] = 'x';
                    n1++;
                }
                else {
                    first[n1] = 'o';
                    n1++;
                }
			}
        }
        for (int x = 0; x < 15; x++){
            for (int i = 0; i < 6; i++){
                if (economy_class[x].getSeat(i)){
                    economy[n2] = 'x';
                    n2++;
                }
                else{
                    economy[n2] = 'o';
                    n2++;
                }
        	}
    	}
        String planeType =
        "                                                                                __\n"  +
        "                                                                               /  \\" + "\n" +
        "                                                                              /    \\" + "\n" +
        "                                                                             |      |\n " +
        "                                                                            | First |\n" +
        "                                                                            |1 2  3 4|\n" +
        "                                                                           a|" + first[0] + " " + first[1] + "||" + first[2] + " " + first[3] + "|\n" +
        "                                                                           b|" + first[4] + " " + first[5] + "||" + first[6] + " " + first[7] + "|\n" +
        "                                                                           c|" + first[8] + " " + first[9] + "||" + first[10] + " " + first[11] + "|\n" +
        "                                                                           d|" + first[12] + " " + first[13] + "||" + first[14] + " " + first[15] + "|\n" +
        "                                                                           e|" + first[16] + " " + first[17] + "||" + first[18] + " " + first[19] + "|\n" +
        "                                                                            |  Econ  |\n" +
        "                                                                            |123  456|\n" +
        "                                                                           a|"+economy[] + economy[] + economy[] + "||ooo|\n" +
        "                                                                       __--b|"+ooo||ooo|---__\n" +
        "                                                         ___------------   c|"+ooo||ooo|   ------------___\n" +
        "                                            ___------------                d|"+ooo||ooo|                  ------------___\n" +
        "                                _____------                                e|"+ooo||ooo|                                  ------_____\n" +
        "                       ______---                                           f|"+ooo||ooo|                                             ---______\n" +
        "               _______-                                                    g|"+ooo||ooo|                                                     -_______\n" +
        "              /                                                            h|"+ooo||ooo|                                                             \\" + "\n" +
        "           __=                                                             i|"+ooo||ooo|                                                              =__\n" +
        "          /                 =======================================        i|"+ooo||ooo|         =======================================                  \\" + "\n" +
        "         |            ==========                                   ====    j|"+ooo||ooo|     ====                                   ==========             |\n" +
        "        /       =======                                                 ===k|"+ooo||ooo|====                                                  =======       \\" + "\n" +
        "        /======                                                            l|"+ooo||ooo|                                                               ======\\" + "\n" +
        "                                                                           m|"+ooo||ooo|\n" +
        "                                                                           n|"+ooo||ooo|\n" +
        "                                                                            |        |\n" +
        "                                                                            |---  ---|\n"  +
        "                                                                     ____---|  |  |  |---____\n" +
        "                                                          _____------       |---  ---|       ------_____\n" +
        "                                                         |                  |        |                  |\n" +
        "                                                        |                   |        |                   |\n" +
        "                                                      /    ________________|        |________________    \\" + "\n" +
        "                                                     |________|            \\________/           |________|";

        System.out.println(planeType);
    
    }
}


