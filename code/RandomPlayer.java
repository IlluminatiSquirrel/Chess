package uk.ac.sheffield.aca14gk;

/**
* RandomPlayer.java 
*
* Class to represent a random type of player
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class RandomPlayer extends Player implements ComputerPlayer{
	
	ChessBoardDisplay chessBoardPanel;
	ArrayList<Move> allAvailableMoves;
	ArrayList<Move> pieceAvailableMoves;
	Move m = null;
	int x1, x2, y1, y2;

	public RandomPlayer(String n, Pieces p, Board b, Player o, ChessBoardDisplay cb){
		super(n, p, b, o);
		chessBoardPanel = cb;
	}
	
	public boolean makeMove() {
		
		//makeMove() sleeps for 1000ms so the movement of pieces would not be jumpy
		try {
	        Thread.sleep(1000);
	    } catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
		
		//creates 2 arraylists (available moves for specific piece , all available moves
		allAvailableMoves = new ArrayList<Move>();
		pieceAvailableMoves = new ArrayList<Move>();
		
		ChessPiecesDisplay piecesPanel = chessBoardPanel.getPieces();
		
		getAllAvailableMoves();
		
		selectRandomMove();
		
		getCoordinates();
		
		Piece playersPiece = m.getPiece();
		Piece capturedPiece = getBoard().getPiece(x2, y2);
		
		boolean isOccupied = getBoard().occupied(x2, y2);
		
		//simple move
		if (!isOccupied){
			getBoard().remove(x1, y1);
			getBoard().setPosition(x2, y2, playersPiece);
			getBoard().getPiece(x2, y2).setPosition(x2, y2);
			String filename = piecesPanel.getFilename(y1*8+x1, chessBoardPanel.getBoard());
			piecesPanel.addPiece(filename, y2*8+x2, chessBoardPanel.getBoard());
			piecesPanel.deletePiece(y1*8+x1, chessBoardPanel.getBoard());
			piecesPanel.update();
			return true;
		}
		
		//capturing a piece
		if (isOccupied){
			getBoard().remove(x1, y1);
			getBoard().remove(x2, y2);
			getBoard().setPosition(x2, y2, playersPiece);
			getBoard().getPiece(x2, y2).setPosition(x2, y2);
			getOpponent().deletePiece(capturedPiece);
			System.out.println(playersPiece + " captured " + capturedPiece);
			String filename1 = piecesPanel.getFilename(y1*8+x1, chessBoardPanel.getBoard());
			piecesPanel.deletePiece(y2*8+x2, chessBoardPanel.getBoard());
			piecesPanel.addPiece(filename1, y2*8+x2, chessBoardPanel.getBoard());
			piecesPanel.deletePiece(y1*8+x1, chessBoardPanel.getBoard());
			piecesPanel.update();
			return true;
		}
		
		return false;
	}

	//method finds all available moves
	public void getAllAvailableMoves() {
		Pieces pieces = getPieces();
		int numPieces = pieces.getNumPieces();
		for (int i = 0; i < numPieces; i++){
			pieceAvailableMoves = pieces.getPiece(i).availableMoves();
			if (pieceAvailableMoves != null)
				allAvailableMoves.addAll(pieceAvailableMoves);
		}
	}

	//method selects random move from all available moves
	public void selectRandomMove() {
		int n = (int)(Math.random()*allAvailableMoves.size());
		m = allAvailableMoves.get(n);
	}

	//method gets the coordinates for moving the piece
	public void getCoordinates() {
		x1 = m.getX1();
		y1 = m.getY1();
		x2 = m.getX2();
		y2 = m.getY2();
		
	}
}