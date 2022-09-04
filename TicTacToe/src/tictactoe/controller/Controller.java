package tictactoe.controller;

import tictactoe.model.Game.SIDE;

// Game needs to know when user has interacted with the game
// this will contain the methods that can be defined in the TicTacToe

public interface Controller {
	
	public void boardClick(int x, int y);
	
	public void startButtonPressed(SIDE side);

}
