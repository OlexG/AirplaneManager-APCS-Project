import java.util.ArrayList;
public class SeatRow {
	// represents a row of seats, true if a person is sitting there and false otherwise
	ArrayList<Boolean> row = new ArrayList<Boolean>();

	public SeatRow(int size){
		for (int x = 0; x < size; x++){
			row.add(Boolean.valueOf(true));
		}
	}


	public boolean getSeat(int location){
		// location is a number from 0 - 5
		if (row.size() == 4){
			// first class
			if (location > 3 || location < 0){
				return false;
			}
			return row.get(location);
		}
		else{
			// economy class
            if (location > 5 || location < 0){
				return false;
			}
            return row.get(location);
        }
	}

	public boolean numberOfSeatsAvailable(int number){
		// coutns the number of seats aviaible& returns if number ism ore than provided number 
		int a = 0;
		for (int x = 0; x < row.size(); x++){
			if (row.get(x) == true){
				a+=1; 
			}
		}
		return (a >= number);
	}

	public ArrayList<Integer> getSeats(){
		// returns the list of available positions
        ArrayList<Integer> availablePositions = new ArrayList<Integer>();
        for (int x = 0; x < row.size(); x++){
            if (getSeat(x)){
                availablePositions.add(x);
            }
        }
        return availablePositions;
	}

	public void setPerson(int location){
        //set location to true
        row.set(location, false);
	}


}

