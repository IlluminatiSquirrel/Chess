package uk.ac.sheffield.aca14gk;

/**
* AggressivePlayer.java 
*
* Class to represent a human player
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class HumanPlayer extends Player{
	
	ChessBoardDisplay chessBoardDisplay;
	MouseActionListener mouseInput;
	
	static boolean selected; //keeps track of whether the human player has entered a move
	
	public HumanPlayer(String n, Pieces p, Board b, Player o, ChessBoardDisplay cb){
		super(n, p, b, o);
		chessBoardDisplay = cb;
		mouseInput = new MouseActionListener(chessBoardDisplay.getBoard());
		chessBoardDisplay.getBoard().addMouseListener(mouseInput);
	}
	
	// method for making a move
	public boolean makeMove() {
		
		//program sleeps and checks whether the player has moved piece
		selected = false;
		while (!selected){
	        try {
		        Thread.sleep(5);
		    } catch(InterruptedException ex) {
		        Thread.currentThread().interrupt();
		    }
		}
		
		//gets the coordinates for moving the piece from the mouse input 
		//(each square is 57x57px, so need to divide by 57)
		int x1 = (int) Math.round(mouseInput.getPiecePos1().getX()/57);
		int x2 = (int) Math.round(mouseInput.getPiecePos2().getX()/57);
		int y1 = (int) Math.round(mouseInput.getPiecePos1().getY()/57);
		int y2 = (int) Math.round(mouseInput.getPiecePos2().getY()/57);
		
		Piece playersPiece = getBoard().getPiece(x1, y1);
		Piece capturedPiece = getBoard().getPiece(x2, y2);
		boolean test = getBoard().occupied(x2, y2);
		
		ChessPiecesDisplay piecesPanel = chessBoardDisplay.getPieces();
		
		// gets all available moves for that piece and stores them in ArrayList
		ArrayList<Move> a = playersPiece.availableMoves();
		
		if (a == null){ // no available moves
			return false;
		}
		
		for (Move b : a){
			
			//if selected piece is not the players piece returns false
			if(getBoard().getPiece(x1, y1).getColour() != getPieces().getPiece(1).getColour())
				return false;
				
			// if references of the available move object are equal to references 
			// provided by player and the pieces destination is not occupied 
			// then the position of piece is updated on the board and the new position is set
			if (b.equals(playersPiece, x1, y1, x2, y2)&&!test){
				getBoard().remove(x1, y1);
				getBoard().setPosition(x2, y2, playersPiece);
				getBoard().getPiece(x2, y2).setPosition(x2, y2);
				String filename = piecesPanel.getFilename(y1*8+x1, chessBoardDisplay.getBoard());
				piecesPanel.addPiece(filename, y2*8+x2, chessBoardDisplay.getBoard());
				piecesPanel.deletePiece(y1*8+x1, chessBoardDisplay.getBoard());
				piecesPanel.update();
				return true;
			}
			// if references of the available move object are equal to references 
			// provided by player and the pieces destination is occupied
			// then the position of piece is updated on the board, the new position is set
			// and captured piece is deleted from collection
			if (b.equals(playersPiece, x1, y1, x2, y2)&&test){
				getBoard().remove(x1, y1);
				getBoard().remove(x2, y2);
				getBoard().setPosition(x2, y2, playersPiece);
				getBoard().getPiece(x2, y2).setPosition(x2, y2);
				getOpponent().deletePiece(capturedPiece);
				System.out.println(playersPiece + " captured " + capturedPiece);
				String filename1 = chessBoardDisplay.getPieces().getFilename(y1*8+x1, chessBoardDisplay.getBoard());
				piecesPanel.deletePiece(y2*8+x2, chessBoardDisplay.getBoard());
				piecesPanel.addPiece(filename1, y2*8+x2, chessBoardDisplay.getBoard());
				piecesPanel.deletePiece(y1*8+x1, chessBoardDisplay.getBoard());
				piecesPanel.update();
				return true;
			}
		}	
		return false;
	}
}