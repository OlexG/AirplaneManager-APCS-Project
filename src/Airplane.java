import java.util.ArrayList;
public class Airplane {
	SeatRow[] first_class = new SeatRow[5];
	SeatRow[] economy_class = new SeatRow[15];
	public Airplane(){
		for (int x = 0; x < 15; x++){
			economy_class[x] = new SeatRow(6);
		}
		for (int x = 0; x < 5; x++){
			first_class[x] = new SeatRow(4);
		}
	}

	public String findSeats(int amountOfPeople, String type, ArrayList<String> preferences){
		if (type == "economy"){
			if (amountOfPeople > 3){
				return "Too many people!";
			}

			for (int x = 0; x < 15; x++){
				SeatRow cur = economy_class[x];
				// check left side
				int amountAvailable = 0;
				for (int y = 0; y < 3; y++){
					if (cur.getSeat(y)){
						amountAvailable += 1;
					}
				}
				if (amountAvailable >= amountOfPeople){
					//we got enough seats
					if (checkPreferencesEconomy("left", preferences, cur)){
						// all preferences fullfilled, lets give them the seats
						ArrayList<Integer> seats = getSeatsEconomy("left", preferences, cur, amountOfPeople);
						String answer = "Economy class seats\n";
						for (int seat:seats){
							answer += "Seat at row " + (x + 1) + " and collumn " + (seat + 1) + "\n";
							cur.setPerson(x);
						}
						return answer;
					}
				}
				// check right side
				amountAvailable = 0;
				for (int y = 3; y < 6; y++){
					if (cur.getSeat(y)){
						amountAvailable += 1;
					}
				}
				if (amountAvailable >= amountOfPeople){
					//we got enough seats
					if (checkPreferencesEconomy("right", preferences, cur)){
						// all preferences fullfilled, lets give them the seats
						ArrayList<Integer> seats = getSeatsEconomy("right", preferences, cur, amountOfPeople);
						String answer = "Economy class seats\n";
						for (int seat:seats){
							answer += "Seat at row " + (x + 1) + " and collumn " + (seat + 1) + "\n";
							cur.setPerson(x);
						}
						return answer;
					}
				}
			}
			return "Your preferences cannot be fulfilled";
		}
		else{
			if (amountOfPeople > 4){
				return "Too many people!";
			}
			for (int x = 0; x < 5; x++){
				SeatRow cur = first_class[x];
				// check left side
				int amountAvailable = 0;
				for (int y = 0; y < 2; y++){
					if (cur.getSeat(y)){
						amountAvailable += 1;
					}
				}
				if (amountAvailable >= amountOfPeople){
					//we got enough seats
					if (checkPreferencesFirst("left", preferences, cur)){
						// all preferences fullfilled, lets give them the seats
						ArrayList<Integer> seats = getSeatsFirst("left", preferences, cur, amountOfPeople);
						String answer = "First class seats\n";
						for (int seat:seats){
							answer += "Seat at row " + (x + 1) + " and collumn " + (seat + 1) + "\n";
							cur.setPerson(x);
						}
						return answer;
					}
				}
				// check right side
				amountAvailable = 0;
				for (int y = 2; y < 4; y++){
					if (cur.getSeat(y)){
						amountAvailable += 1;
					}
				}
				if (amountAvailable >= amountOfPeople){
					//we got enough seats
					if (checkPreferencesFirst("right", preferences, cur)){
						// all preferences fullfilled, lets give them the seats
						ArrayList<Integer> seats = getSeatsFirst("right", preferences, cur, amountOfPeople);
						String answer = "First class seats\n";
						for (int seat:seats){
							answer += "Seat at row " + (x + 1) + " and collumn " + (seat + 1) + "\n";
							cur.setPerson(x);
						}
						return answer;
					}
				}
			}
			return "Your preferences cannot be fulfilled. Either reduce number of people or change your preferences.";
		}
	}

	public boolean checkPreferencesEconomy(String side, ArrayList<String> preferences, SeatRow cur){
		ArrayList<Integer> availableSeats = cur.getSeats();
		if (side == "left"){
			for (String preference:preferences){
				if (preference == "aisle"){
					if (!availableSeats.contains(2)){
						return false;
					}
				}
				else if (preference == "center"){
					if (!availableSeats.contains(1)){
						return false;
					}
				}
				else if (preference == "window"){
					if (!availableSeats.contains(0)){
						return false;
					}
				}
			}
		}
		else{
			for (String preference:preferences){
				if (preference == "aisle"){
					if (!availableSeats.contains(3)){
						return false;
					}
				}
				else if (preference == "center"){
					if (!availableSeats.contains(4)){
						return false;
					}
				}
				else if (preference == "window"){
					if (!availableSeats.contains(5)){
						return false;
					}
				}
			}
		}
		return true;
	}

	public ArrayList<Integer> getSeatsEconomy(String side, ArrayList<String> preferences, SeatRow cur, int amountOfPeople){
		ArrayList<Integer> seats = new ArrayList<Integer>();

		if (side == "left"){
			for (String preference:preferences){
				if (preference == "aisle"){
					seats.add(2);
					amountOfPeople -= 1;
				}
				else if (preference == "center"){
					seats.add(1);
					amountOfPeople -= 1;
				}
				else if (preference == "window"){
					seats.add(0);
					amountOfPeople -= 1;
				}
			}
			// fill in the non preference seats

			for (int x = 0; x < 3; x++){
				if (amountOfPeople == 0){
					return seats;
				}
				if (!seats.contains(x) && cur.getSeat(x)){
					seats.add(x);
					amountOfPeople -= 1;
				}
			}
		}
		else{
			for (String preference:preferences){
				if (preference == "aisle"){
					seats.add(3);
					amountOfPeople -= 1;
				}
				else if (preference == "center"){
					seats.add(4);
					amountOfPeople -= 1;
				}
				else if (preference == "window"){
					seats.add(5);
					amountOfPeople -= 1;
				}
			}
			// fill in the non preference seats

			for (int x = 3; x < 6; x++){
				if (amountOfPeople == 0){
					return seats;
				}
				if (!seats.contains(x) && cur.getSeat(x)){
					seats.add(x);
					amountOfPeople -= 1;
				}
			}
		}
		return seats;
	}

	public boolean checkPreferencesFirst(String side, ArrayList<String> preferences, SeatRow cur){
		ArrayList<Integer> availableSeats = cur.getSeats();
		if (side == "left"){
			for (String preference:preferences){
				if (preference == "aisle"){
					if (!availableSeats.contains(1)){
						return false;
					}
				}
				else if (preference == "window"){
					if (!availableSeats.contains(0)){
						return false;
					}
				}
			}
		}
		else{
			for (String preference:preferences){
				if (preference == "aisle"){
					if (!availableSeats.contains(2)){
						return false;
					}
				}
				else if (preference == "window"){
					if (!availableSeats.contains(3)){
						return false;
					}
				}
			}
		}
		return true;
	}

	public ArrayList<Integer> getSeatsFirst(String side, ArrayList<String> preferences, SeatRow cur, int amountOfPeople){
		ArrayList<Integer> seats = new ArrayList<Integer>();

		if (side == "left"){
			for (String preference:preferences){
				if (preference == "aisle"){
					seats.add(1);
					amountOfPeople -= 1;
				}
				else if (preference == "window"){
					seats.add(0);
					amountOfPeople -= 1;
				}
			}
			// fill in the non preference seats

			for (int x = 0; x < 2; x++){
				if (amountOfPeople == 0){
					return seats;
				}
				if (!seats.contains(x) && cur.getSeat(x)){
					seats.add(x);
					amountOfPeople -= 1;
				}
			}
		}
		else{
			for (String preference:preferences){
				if (preference == "aisle"){
					seats.add(2);
					amountOfPeople -= 1;
				}
				else if (preference == "window"){
					seats.add(3);
					amountOfPeople -= 1;
				}
			}
			// fill in the non preference seats

			for (int x = 2; x < 4; x++){
				if (amountOfPeople == 0){
					return seats;
				}
				if (!seats.contains(x) && cur.getSeat(x)){
					seats.add(x);
					amountOfPeople -= 1;
				}
			}
		}
		return seats;
	}
}
