package week06;

import java.util.Arrays;
import java.util.Scanner;

public class Week06TicTacToeLab {

	// This Lab requires you to program a simple game of Tic Tac Toe
			//
			// 		 Note:  there are many ways to implement this game.  Use what 
			//		  		you have already learned.  You have the tools to implement
			//		  		this game.  
			//
			// Rules:  
			//		- Tic Tac Toe is a 2-player game played on a 3x3 grid.  
			//
			//		- One player usually plays "X"s and the other player plays "O"s.
			//
			// 		- In our version of the game, "X"s will always start.
			//
			//		- Players will alternate turns.
			//
			// 		- The game will end when one of the conditions is true:
			//				1. A player gets three squares in a row 
			//				2. A player gets three squares in a column
			//				3. A player gets three squares in either diagonal
			//				4. Every square is filled in, but no player has achieved 
			//					conditions 1,2, or 3 as described above --> A Draw!
			//
			//		- A player can win on turn 5, 6, 7, 8, or 9 (start checking for winners on or before turn 5)
			//
			//		- Error checking of input is not necessary here, but will make this game much more
			//				robust.  If you choose to implement this, get the game working first, and then
			//				add a check of the input to make sure that it's an Integer from 1 to 9.
			//
			//		- Use the Scanner to input the users choice of square -- one suggestion is  
			//				to create numbers within the square, and then have the user choose 
			//				that integer (1-9) to choose the location.
			//
			//		- One way to display the game board would be as follows:
			//				+---+---+---+       to		+---+---+---+		+---+---+---+		+---+---+---+
			//				| 1 | 2 | 3 |	   find		|---|---|---|		| | | | | | |		| \ |   | / |
			//				+---+---+---+	   a win	+---+---+---+		+---+---+---+		+---+---+---+
			//				| 4 | 5 | 6 |	-- look-->	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
			//				+---+---+---+	 at these	+---+---+---+		+---+---+---+		+---+---+---+
			//				| 7 | 8 | 9 |	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
			//				+---+---+---+		        +---+---+---+		+---+---+---+		+---+---+---+
				
				
			// Start with these steps:
			//
			//		1. Create a class with a main method -- this Lab can be implemented in just one class.
			//				
			//				Alternatively, you could create an object with it's own methods. 
			//				(e.g. GameBoard.java)
			//
			//		2. You will need to declare a gameBoard.  
			//
			//				As shown above, Tic Tac Toe is played on a 3x3 grid that has 9 spaces. 
			//
			//					a. One suggestion is to create an array of length 9 to represent the board:
			//
			//						For example:  String[] gameBoard = new String[9]; 
			//
			//							i. Just remember that arrays are 0 based, so to access the grid, 
			//							the index would go from 0-8.  
			//
			//							ii. Wins can occur in 8 ways (see above).
			//								For example: A horizontal win would be found by 
			//								looking at the contents of: 
			//									gameBoard[0] & gameBoard[1] & gameBoard[2] 
			//									gameBoard[3] & gameBoard[4] & gameBoard[5] 
			//									gameBoard[6] & gameBoard[7] & gameBoard[8] 
			//
			//					b. Another option for the gameBoard would be a 2d array -- This option might be
			//						is a bit more challenging!  
			//
			//						For example:  String[][] gameBoard = new String[3][3];
			//					
			//							i. Just remember that arrays are 0 based, so to access the grid, 
			//							the index would go from 0-2 in two directions.  
			//
			//							ii. Wins can occur in 8 ways.  A horizontal win would be comparing:  
			//									gameBoard[0][0] & gameBoard[0][1] & gameBoard[0][2] 
			// 
			//		3.  Implement the rules as listed above.  
			//
			//		4.  You might want to have the following methods:
			//					a. display() -- to print the gameBoard
			//					b. checkWinStatus() -- to check if a player has won
			//					c. initialize() -- to set up your new gameBoard
			//			
			//		5.  Reminder:  There is no one way to implement this game.
			//		
			//	
			
			// START YOUR IMPLEMENTATION BELOW THIS LINE
	
	
	public static void main(String[] args) {
		String winner = "";
		Boolean cellCheck;
		
		// Create Scanner to read input of the players (either X or O entered)
		Scanner myScanner = new Scanner(System.in);
		
		// Create a gameBoard to play on - this is the array that will hold the gameBoard sections (totaling 9).
		String[] gameBoard = new String[9];
		
		initialize(gameBoard);
		
		// Create the variables needed to run the game
		int gameBoardCell;
		int allCells = 1;
		String player = "X";
		
		// Open the game
		System.out.println();
		System.out.println("==============================");
		System.out.println("    The game Tic-Tac-Toe!");
		System.out.println("   First turn will be:  X ");
		System.out.println("==============================");
		System.out.println();
		
		// Print out the game board
		display(gameBoard);
		
		// Play the game
		while (winner.equals("") && allCells <= 9) {
			// to enter the X or O at the space on the gameboard
			System.out.println(player + "'s turn -- enter the number representing the cell to place your " + player + " in:");
			
			// read from keyboard the cell selected
			String readInput = myScanner.nextLine();
			
			// assign keyboard entry to variable (selecting the cell to modify)
			gameBoardCell = Integer.valueOf(readInput);
			if(gameBoardCell > 0 && gameBoardCell <= 9) {
			cellCheck = validateSettingCell(gameBoard, gameBoardCell, readInput, player);
				if (cellCheck == true) {
					// assign the players symbol (X or O) to the cell from keyboard input
					gameBoard[gameBoardCell - 1] = player;
						
					// alternate players based on the current player (if current player is X then O becomes next player)
					if (player.equals("X")) {
						player = "O";
					} else {
						player = "X";
					}
						
					allCells += 1;
						
					// display the gameBoard after each move
					display(gameBoard);
						
					// check for a winner of the game
					winner = checkWinStatus(gameBoard);
				} else {
					System.out.println("Cell has already been used.");
				}
			} else {
				System.out.println("Invalid input.");
			}
		}
		
		// End of game
		System.out.println();
		System.out.println("==============================");
		System.out.println("         Game Over:");
		if (winner.equals("Draw")) {
			System.out.println("     This game is a " + winner + "!");
		} else {
			System.out.println("           " + winner + " wins!");
		}
		System.out.println("==============================");
		
		// close the Scanner once game is done
		myScanner.close();
	}
	
	public static void display(String[] myArray) {
		System.out.println("     +---+---+---+");
		System.out.println("     | " + myArray[0] + " | " + myArray[1] + " | " + myArray[2] + " | ");
		System.out.println("     +---+---+---+");
		System.out.println("     | " + myArray[3] + " | " + myArray[4] + " | " + myArray[5] + " | ");
		System.out.println("     +---+---+---+");
		System.out.println("     | " + myArray[6] + " | " + myArray[7] + " | " + myArray[8] + " | ");
		System.out.println("     +---+---+---+");
		System.out.print("\n");
	}
	
	public static String checkWinStatus(String[] myArray) {
		// create code to check the status of one of the winning combinations
		for (int cell = 0; cell < 8; cell++) {
			String winningCombination = null;
			
			switch (cell) {
			// case 0, 1, or 2 for horizontal wins
			case 0:
				winningCombination = myArray[0] + myArray[1] + myArray[2];
				break;
			case 1:
				winningCombination = myArray[3] + myArray[4] + myArray[5];
				break;
			case 2:
				winningCombination = myArray[6] + myArray[7] + myArray[8];
				break;
			// case 3, 4, or 5 for vertical wins
			case 3:
				winningCombination = myArray[0] + myArray[3] + myArray[6];
				break;
			case 4:
				winningCombination = myArray[1] + myArray[4] + myArray[7];
				break;
			case 5:
				winningCombination = myArray[2] + myArray[5] + myArray[8];
				break;
			// case 6 or 7 for diagonal wins
			case 6:
				winningCombination = myArray[0] + myArray[4] + myArray[8];
				break;
			case 7:
				winningCombination = myArray[2] + myArray[4] + myArray[6];
				break;			
			}
			
			// X wins
			if (winningCombination.equals("XXX")) {
				return "X";
			} 
			
			// O wins
			else if (winningCombination.equals("OOO")) {
				return "O";
			}
						
		}
		
		// if no one wins
		for (int cell = 1; cell <= 9; cell ++) {
			if(Arrays.asList(myArray).contains(String.valueOf(cell))) {
				break;
			} else if (cell == 9) {
				return "Draw";
			}
		}
		return "";
	}
	
	public static void initialize(String[] myArray) {
		// initialize the gameBoard to play on which is an array
		for (int i = 1; i <= 9; i++) {
			myArray[i - 1] = String.valueOf(i);				
		}		
	}
	
	public static boolean validateSettingCell(String[] myArray, int number, String input, String player) {
		if(myArray[number - 1].equals(String.valueOf(input))) {
			myArray[number - 1] = player;
			return true;
		} else {
			return false;
		}
	}

}
