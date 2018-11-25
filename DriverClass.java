import java.util.*;

public class DriverClass {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		ParkingLot lot;
		Car car;
		Bus bus;
		Motorcycle motorcycle;
		
		int numberOfSpots = 0;
		int spotsPerRow = 0;
		int numberOfLevels = 0;
		boolean testPass = true; // to help with the while loop
		String userInput;
		
		//total number of levels
		System.out.println("How many levels are there?");
		while (testPass) {
			try {
				numberOfLevels = Integer.parseInt(input.next());
				testPass = false;
			} catch(NumberFormatException e){
				System.out.println("not a valid number, try again");
			}
		}
		
		//total number of spots per row
		System.out.println("How many spots per row are there?");
		testPass = true; 
		while (testPass) {
			try {
				spotsPerRow = Integer.parseInt(input.next());
				testPass = false;
			} catch(NumberFormatException e){
				System.out.println("not a valid number, try again");
			}
		}
		
		//Total number of spots in a level
		System.out.println("How many spots are there per level?");
		testPass = true; 
		while (testPass) {
			try {
				numberOfSpots = Integer.parseInt(input.next());
				testPass = false;
			} catch(NumberFormatException e){
				System.out.println("not a valid number, try again");
			}
		}
		
		//Creating the lot using the constructor 
		lot = new ParkingLot(numberOfSpots, spotsPerRow, numberOfLevels);
		
		System.out.println(lot);
		
		//While loop that will continue till there are no more spots or until the user tells the program to end
		while (lot.getTotalSpots() != 0) {
			System.out.println("Type \"park\" to park a vehicle, \"remove\" to remove a vehicle or type \"end\" to end the program");
			userInput = input.next();
			if(userInput.equals("park")) {
				System.out.println("What would you like to park, a bus, a car, or a motorcycle?");
				userInput = input.next();
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.Park(bus);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.Park(car);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.Park(motorcycle);
				}
				else {
					System.out.println("Looks like that is not a vehicle to park, try again");
				}
			}
			else if (userInput.equals("remove")) {
				System.out.println("What type of vehicle would you like to remove, a bus, a car, or a motorcycle");
				userInput = input.next();
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.Remove(bus);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.Remove(car);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.Remove(motorcycle);
				}
				else {
					System.out.println("Looks like that is not a vehicle to remove, try again");
				}
			}
			else if (userInput.equals("end")) {
				System.out.println("\n\nEnding the program");
				break;
			}
			else {
				System.out.println("That's not an option, lets try again");
			}
			//Print the lot
			System.out.println("\nThis is the new lot");
			System.out.println(lot);
		}
		
	}
}
