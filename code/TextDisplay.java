package uk.ac.sheffield.aca14gk;

/**
* TextDisplay.java 
*
* Class for text display on the console
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

public class TextDisplay implements Display{

	public void showPiecesOnBoard(Piece[][] data) {
		System.out.println();
		System.out.println("————————————————————————————————————");
		System.out.print("    | ");
		for (char i = 'A'; i <= 'H'; i++)
			System.out.print(i + " | ");
		System.out.println();
		System.out.println("————————————————————————————————————");
		for (int i = 0; i < 8; i++){
			System.out.print("| " + (i+1) + " | ");
			for (int j = 0; j < 8; j++){
				if (data[j][i]==null)
					System.out.print("  | ");
				else
					System.out.print(data[j][i] + " | ");
			}
			System.out.println();
			System.out.println("————————————————————————————————————");
		}
		System.out.println();
	}

	@Override
	public void showGraphicalDisplay() {
		
	}
	
}