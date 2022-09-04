package tictactoe;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import tictactoe.controller.Controller;
import tictactoe.model.Game;
import tictactoe.model.Game.SIDE;
import tictactoe.view.Console;


public class TicTacToe implements Controller {
	
	private SIDE playerSide;
	private Console console;
	private Game currentGame;
	// creating a constructor
	public TicTacToe() {
		
		Console console = new Console(this);
		console.setVisible(true); // JFrame is not visible by default so need to set it to visible
		// WindowListener listens to window events (closed, opened, minimized, maximized, etc) and performs specific actions defined in the methods
		// WindowAdapter is used so we could remove unneeded interface methods
		console.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);	// Listen to window closing event and exit the tictactoe game	
			}		
		});
		
		console.setGameOn(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		// new object of class TicTacToe
		new TicTacToe(); // Created new TicTacToe object

	}

	@Override
	public void boardClick(int x, int y) {
		// Print statement is added to debug whether the click and start activity is working correctly
		System.out.println("Board Click at " + x + ", " + y);
		
	}

	@Override
	public void startButtonPressed(SIDE side) {
		// TODO Auto-generated method stub
		System.out.println("Start button clicked for side " + side);
		playerSide = side;
		console.setGameOn(true);
		
		currentGame = new Game();
		
		
	}

}
