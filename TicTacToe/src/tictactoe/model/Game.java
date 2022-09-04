package tictactoe.model;

public class Game {
	
	// CELL is an enum type that has below values. any object of enumtype can have either the values listed below or null.
	// enum is made public to be able to access it outside of this package
	public enum CELL {EMPTY, NAUGHT, CROSS};
	
	public enum SIDE {NAUGHT, CROSS}; // this is the side picked by the user for the game
	
	// board is a CELL array reference variable that can store either null or values defined in CELL
	// board is the TicTacToe game board
	private CELL[][] board;
	
	private SIDE currentTurn = SIDE.CROSS;
	
	// Defining the constructor for the game. Each time a Game object is created, it is initialized with a board of 9 empty cells
	public Game() {
		
		// storing a 3x3 CELL object in board
		board = new CELL[3][3];
		// need to make the cell empty initially. Using for loop to empty the board
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				board[x][y] = CELL.EMPTY; // refer to appendix I of Introduction to Java Programming and Data Structures, Comprehensive Version 11th Edition by Daniel Liang for more info on assigning enumerated values to a variable
			}
		}
	}
	
	// View what's in a given cell
	public CELL getCell(int x, int y) {
		return board[x][y];
	}
	
	// Set cell value only if it is empty
	public boolean setCell(int x, int y, CELL cell) {
		if(board[x][y] == CELL.EMPTY) {
			board[x][y] = cell;
			return true;
		} else {
			return false;
		}
	}

	public SIDE getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(SIDE currentTurn) {
		this.currentTurn = currentTurn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
