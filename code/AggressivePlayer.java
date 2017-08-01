package uk.ac.sheffield.aca14gk;

/**
* AggressivePlayer.java 
*
* Class to represent an aggressive type of player
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class AggressivePlayer extends Player implements ComputerPlayer{

	ArrayList<Move> allAvailableMoves;
	ArrayList<Move> pieceAvailableMoves;
	ArrayList<Move> pieceCapturingMoves;
	Move m = null;
	int x1, x2, y1, y2;
	
	ChessBoardDisplay chessBoardPanel;
	
	public AggressivePlayer(String n, Pieces p, Board b, Player o, ChessBoardDisplay cb) {
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
		
		//creates 3 arraylists (available moves for specific piece , all available moves and 
		//moves that would capture a piece)
		allAvailableMoves = new ArrayList<Move>();
		pieceAvailableMoves = new ArrayList<Move>();
		pieceCapturingMoves = new ArrayList<Move>();
		
		ChessPiecesDisplay piecesPanel = chessBoardPanel.getPieces();
		
		getAllAvailableMoves();
		
		//finds all moves that would capture a piece
		for (Move move : allAvailableMoves){
			int x = move.getX2();
			int y = move.getY2();
			if (getBoard().occupied(x, y))
				pieceCapturingMoves.add(move);
		}
		
		//finds the move that would capture a piece with the highest value
		if (pieceCapturingMoves != null){
			int max = 0;
			for (Move move : pieceCapturingMoves){
				int x = move.getX2();
				int y = move.getY2();
				char ch = getBoard().getPiece(x, y).getChar();
				int i = PieceCode.charToInt(ch);
				if (i > max){
					max = i;
					m = move;
				}
			}
		}
		
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
		if(pieceCapturingMoves.isEmpty()){
			int n = (int)(Math.random()*allAvailableMoves.size());
			m = allAvailableMoves.get(n);
		}
	}

	//method gets the coordinates for moving the piece
	public void getCoordinates() {
		x1 = m.getX1();
		y1 = m.getY1();
		x2 = m.getX2();
		y2 = m.getY2();
	}
}
