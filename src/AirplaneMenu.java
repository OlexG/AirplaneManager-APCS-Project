import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneMenu {
    
    //initializes the airplane, sets values to 0
	public ArrayList<String> preferences = new ArrayList<String>();
	public int numberOfPeople = 0;
	public Airplane plane = new Airplane(); // creates new airplane object
	public String type = "economy";

    public boolean validatePreferences(String[] preferences) {
        if (preferences.length > numberOfPeople){
            return false;
        }
        if (this.type.equals("economy")){
            for (int x = 0; x < preferences.length; x++){
                if (!preferences[x].equals("window") && !preferences[x].equals("aisle") && !preferences[x].equals("center")){
                    return false;
                }
            }
        }
        else{
            for (int x = 0; x < preferences.length; x++){
                if (!preferences[x].equals("window") && !preferences[x].equals("aisle")){
                    return false;
                }
            }
        }
        // check for duplicates now
        for (int x = 0; x < preferences.length; x++){
            for (int y = 0; y < preferences.length; y++) {
                if (x != y && preferences[x].equals(preferences[y])){
                    return false;
                };
            }
        }
        return true;
    }
    public void getPreferences(Scanner input){
        //aisle center window (max size 3 for input 1-3), numberOfPeople is the maximum number of preferences, make sure all the preferences are different
        //asks for input using in
        System.out.println("What is your seating preference - enter them separarted by space - you cannot have duplicate preferenes and no more then the number of people you are seating");
        System.out.println("Type \"window\", \"aisle\", and \"center\" if you are flying economy and for first class there is no center. Enter none for no preferences");
        /*
        Ben note to self:
        test for input past this point, "input.contains"?
        also Ben test that if type is buisness it doesnt let u pick center. okay :)
        */
        while(true){
            if (input.hasNext()){
                String line = input.nextLine();
                if (line.equals("none")){
                    return;
                }
                System.out.println(line);
                //split by space
                String[] splitted = line.split(" ");
                System.out.println(splitted.toString());
                if (validatePreferences(splitted)){
                    for (int x = 0; x < splitted.length; x++){
                        this.preferences.add(splitted[x]);
                    }
                    return;
                }
            }
            System.out.println("Invalid preferences");
        }  
    }
        //gets the amount of people in a group 
	public void getPeople(Scanner input){
        System.out.println("How people are traveling together? 1-2 for first class or 1-3 for economy");
		while (true){
            if (input.hasNextInt()){
                numberOfPeople = input.nextInt();
                if (type.equals("first")){
                    if (numberOfPeople >= 1 && numberOfPeople <= 2){
                        return;
                    }
                }
                else {
                    if (numberOfPeople >= 1 && numberOfPeople <= 3){
                        return;
                    }
                }
            }
            System.out.println("Please enter an integer in range!");
		}
    }
        //gets the type of seat 
	public void getType(Scanner input){
		System.out.println("Economy or first class? Enter \"economy\" or \"first\"");
		while (true){ 
			String givenType = input.next();
			if (!givenType.equals("economy") && !givenType.equals("first")){
				System.out.println("Please enter a valid string, economy or first");
			}
			else{
				type = givenType;
                break;
			}
		}
	}

        //intiliziazes and prints the plane
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
                    first[n1] = 'o';
                    n1++;
                }
                else {
                    first[n1] = 'x';
                    n1++;
                }
			}
        }
        for (int x = 0; x < 15; x++){
            for (int i = 0; i < 6; i++){
                if (economy_class[x].getSeat(i)){
                    economy[n2] = 'o';
                    n2++;
                }
                else{
                    economy[n2] = 'x';
                    n2++;
                }
        	}
    	}
        // plane string 
        String planeType =
        "                                                                                __\n"  +
        "                                                                               /  \\" + "\n" +
        "                                                                              /    \\" + "\n" +
        "                                                                             |      |\n" +
        "                                                                            | First  |\n" +
        "                                                                            |1 2  3 4|\n" +
        "                                                                           a|" + first[0] + " " + first[1] + "||" + first[2] + " " + first[3] + "|\n" +
        "                                                                           b|" + first[4] + " " + first[5] + "||" + first[6] + " " + first[7] + "|\n" +
        "                                                                           c|" + first[8] + " " + first[9] + "||" + first[10] + " " + first[11] + "|\n" +
        "                                                                           d|" + first[12] + " " + first[13] + "||" + first[14] + " " + first[15] + "|\n" +
        "                                                                           e|" + first[16] + " " + first[17] + "||" + first[18] + " " + first[19] + "|\n" +
        "                                                                            |  Econ  |\n" +
        "                                                                            |123  456|\n" +
        "                                                                           a|"+ economy[0] + economy[1] + economy[2] + "||" + economy[3] + economy[4] + economy[5] +"|\n" +
        "                                                                       __--b|"+ economy[6] + economy[7] + economy[8] + "||" + economy[9] + economy[10] + economy[11] +"|---__\n" +
        "                                                         ___------------   c|"+ economy[12] + economy[13] + economy[14] + "||" + economy[15] + economy[16] + economy[17] +"|   ------------___\n" +
        "                                            ___------------                d|"+ economy[18] + economy[19] + economy[20] + "||" + economy[21] + economy[22] + economy[23] +"|                  ------------___\n" +
        "                                _____------                                e|"+ economy[24] + economy[25] + economy[26] + "||" + economy[27] + economy[28] + economy[29] +"|                                  ------_____\n" +
        "                       ______---                                           f|"+ economy[30] + economy[31] + economy[32] + "||" + economy[33] + economy[34] + economy[35] +"|                                             ---______\n" +
        "               _______-                                                    g|"+ economy[36] + economy[37] + economy[38] + "||" + economy[39] + economy[40] + economy[41] +"|                                                     -_______\n" +
        "              /                                                            h|"+ economy[42] + economy[43] + economy[44] + "||" + economy[45] + economy[46] + economy[47] +"|                                                             \\" + "\n" +
        "           __=                                                             i|"+ economy[48] + economy[49] + economy[50] + "||" + economy[51] + economy[52] + economy[53] +"|                                                              =__\n" +
        "          /                 =======================================        i|"+ economy[54] + economy[55] + economy[56] + "||" + economy[57] + economy[58] + economy[59] +"|         =======================================                  \\" + "\n" +
        "         |            ==========                                   ====    j|"+ economy[60] + economy[61] + economy[62] + "||" + economy[63] + economy[64] + economy[65] +"|     ====                                   ==========             |\n" +
        "        /       =======                                                 ===k|"+ economy[66] + economy[67] + economy[68] + "||" + economy[69] + economy[70] + economy[71] +"|====                                                  =======       \\" + "\n" +
        "        /======                                                            l|"+ economy[72] + economy[73] + economy[74] + "||" + economy[75] + economy[76] + economy[77] +"|                                                               ======\\" + "\n" +
        "                                                                           m|"+ economy[78] + economy[79] + economy[80] + "||" + economy[81] + economy[82] + economy[83] +"|\n" +
        "                                                                           n|"+ economy[84] + economy[85] + economy[86] + "||" + economy[87] + economy[88] + economy[89] +"|\n" +
        "                                                                            |        |\n" +
        "                                                                            |---  ---|\n"  +
        "                                                                     ____---|  |  |  |---____\n" +
        "                                                          _____------       |---  ---|       ------_____\n" +
        "                                                         |                  |        |                  |\n" +
        "                                                        |                   |        |                   |\n" +
        "                                                      /     ________________|        |________________    \\" + "\n" +
        "                                                     |________|            \\________/           |________|";
            // prints plane
        System.out.println(planeType);
    }

    public void getResults(){
        System.out.println(
            this.preferences.toString()
        );
        this.plane.findSeats(this.numberOfPeople, this.type, this.preferences);
        this.printPlane();
    }

    public void clear(){
        this.preferences.clear();
    }
}