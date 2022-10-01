package cinema;
import java.util.*;

public class Cinema {

	private static int netIncome = 0;
	private static int totalRows, seats, totalSeats;
	public static void main(String[] args) {
		// Variables

		Scanner scanner = new Scanner(System.in);

		// Prompt for row and seats in theatre
		System.out.println("Enter the number of rows:");
		totalRows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row:");
		seats = scanner.nextInt();
		totalSeats = seats * totalRows;

		// Creating Cinema Array based on input
		char[][] cinemaMap = new char[totalRows][seats];
		// Filling the array with 'S'
		for (int i = 0; i < totalRows; i++) {
			Arrays.fill(cinemaMap[i], 0, seats, 'S');
		}

		showMenu(cinemaMap);

	}

	private static void buyTicket(char[][] cinemaMap){
		// Prompting for seat selection
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a row number:");
		int rowSelection = scanner.nextInt();
		System.out.println("Enter a seat number in that row:");
		int seatSelection = scanner.nextInt();
		if ((rowSelection <= cinemaMap.length) && (seatSelection <= cinemaMap[0].length)) {
			// Displaying the ticket price
			if (cinemaMap[rowSelection - 1][seatSelection - 1] == 'B'){
				System.out.println("That ticket has already been purchased!");
				buyTicket(cinemaMap);
			}
			else {
				int ticketPrice = calculatePrice(rowSelection, totalRows, seats);
				System.out.println("Ticket price: $" + ticketPrice + "\n");
				netIncome += ticketPrice;
				// Marking the seat in the map
				cinemaMap[rowSelection - 1][seatSelection - 1] = 'B';
			}
		} else {
			System.out.println("Wrong input!");
		}
	}

	private static void showMenu(char[][] cinemaMap) {
		boolean choice = true;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("1. Show the seats");
			System.out.println("2. Buy a ticket");
			System.out.println("3. Statistics");
			System.out.println("0. Exit");
			int selectedOption = scanner.nextInt();
			switch (selectedOption) {
				case 1:
					generateMap(cinemaMap);
					break;
				case 2:
					buyTicket(cinemaMap);
					break;
				case 3:
					getStatistics(cinemaMap, netIncome, totalSeats);
					break;

				case 0:
					choice = false;
					break;

			}

		} while (choice);
	}

	private static void getStatistics(char[][] cinemaMap, int netIncome, int totalSeats) {
		// Calculate the number of purchased tickets by iterating over array
		int numTickets = 0;
		for (int i = 0; i < cinemaMap.length; i++){
			for (int j = 0; j < cinemaMap[i].length; j++){
				if (cinemaMap[i][j] == 'B'){
					++numTickets;
				}
			}
		}
		System.out.println("Number of purchased tickets: " + numTickets);

		// Calculate the percentage of tickets sold
		double percentSold = ((double) numTickets * 100) / (totalSeats);
		System.out.printf("Percentage: %.2f%%\n", percentSold);

		// Display current income
		System.out.println("Current Income: $" + netIncome);

		// Display total income
		int idealIncome;

		if (totalSeats <= 60) {
			idealIncome = 10 * totalSeats;
		}
		else {
			int half = cinemaMap.length / 2;
			idealIncome = half * cinemaMap[0].length * 10 + (cinemaMap.length - half) * cinemaMap[0].length * 8;
		}
		System.out.println("Total income: $" + idealIncome);
	}

	private static int calculatePrice(int rowSelection, int totalRows, int seats) {
		int totalSeats = totalRows * seats;

		if (totalSeats > 60 && rowSelection > (totalRows / 2)) {
			return 8;
		} else
			return 10;
	}

	// Used to print cinema Map
	private static void generateMap(char[][] cinemaMap) {
		// Displaying the Heading
		System.out.println("Cinema:");
		// Displaying the array
		System.out.print("  ");
		for (int i = 0; i < cinemaMap[0].length; i++) {
			System.out.print(i + 1 + " ");
		}
		System.out.println();
		for (int row = 0; row < cinemaMap.length; row++) {
			System.out.print(row + 1 + " ");
			for (int j = 0; j < cinemaMap[row].length; j++) {
				System.out.print(cinemaMap[row][j] + " ");
			}
			System.out.println();

		}
	}
}