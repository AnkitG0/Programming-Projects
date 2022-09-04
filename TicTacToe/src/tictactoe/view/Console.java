package tictactoe.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tictactoe.controller.Controller;
import tictactoe.model.*;
import tictactoe.model.Game.SIDE;

public class Console extends JFrame implements ActionListener {
	
	private String CLICK_START_MESSAGE = "Click a start button";
	
	private JButton[][] buttons;
	private JButton startXButton = new JButton("Start X");
	private JButton startOButton = new JButton("Start O");
	private JTextArea status = new JTextArea();
	
	private Controller controller;
	
	// Constructor for Console
	public Console(Controller controller) {
		// Console object gets the value of controller from the parameter passed while using the constructor)
		this.controller = controller;
		buttons = new JButton[3][3];
		
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		
		for(int y=0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				buttons[x][y] = new JButton(); // creating each button in the 3x3 grid
				gamePanel.add(buttons[x][y]); // add the button to the gamepanel
				buttons[x][y].setActionCommand(x + "," + y); // set the action command of the button to be this
				buttons[x][y].addActionListener(this);
			}
		}
		// Set the size of the console 
		setSize(400, 600);
		
		// Creating the control panel
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(startXButton);
		controlPanel.add(startOButton);
		
		// Add actionlistener to listen to action performed (specific button clicked) on the game and perform specific activity
		startXButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.startButtonPressed(SIDE.CROSS);
			}
		});
			
		startOButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.startButtonPressed(SIDE.NAUGHT);
			}
		});
		
		// Borderlayout ties together all the elements created so far 
		this.setLayout(new BorderLayout());
		
		this.add(gamePanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(status, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String actionCommand = arg0.getActionCommand();
		String[] xy = actionCommand.split(","); // Split the action command using the ',' and store each element in a string array
		int x = Integer.valueOf(xy[0]); // Cast the X and Y value which is in string into integer and store in x and y
		int y = Integer.valueOf(xy[1]);
		controller.boardClick(x, y); // Call the boardClick method using x and y parameters
	}
	
	public void setGameOn(boolean gameOn) {

		for(int y=0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				buttons[x][y].setEnabled(gameOn);
			}

		}
		startXButton.setEnabled(!gameOn);
		startOButton.setEnabled(!gameOn);
		
//		if (!gameOn) {
//			status.setText(CLICK_START_MESSAGE);
//		}
	
	}

}
