package uk.ac.sheffield.aca14gk;

/**
* King.java 
*
* Class to represent a king
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class King extends Piece {
	
	public King(int ix, int iy, int c, Board b){
		super(PieceCode.KING, ix, iy, c, b);
	}

	public ArrayList<Move> availableMoves() {
		return pieceKing();
	}
	
	private ArrayList<Move> pieceKing() {
		int x = getX();
		int y = getY();
		
		ArrayList<Move> v = new ArrayList<Move>();
	      
		Move m = null;
		
		// each if statement checks if the next move doesn't take the piece of the board
		// and whether the last space is occupied or not
		// in total king has 16 possible moves (8 moves plus 8 taking other piece moves)
		if (y-1 >= 0 && !getBoard().occupied(x, y-1)){
			m = new Move(this, x, y, x, y-1);
			v.add(m);
		}
		if (y-1 >= 0 && getBoard().occupied(x, y-1) 
			&& getBoard().getPiece(x, y-1).getColour() != this.getColour()){
			m = new Move(this, x, y, x, y-1);
			v.add(m);
		}
		if (x+1 <= 7 && y-1 >= 0 && !getBoard().occupied(x+1, y-1)){
			m = new Move(this, x, y, x+1, y-1);
			v.add(m);
		}
		if (x+1 <= 7 && y-1 >= 0 && getBoard().occupied(x+1, y-1) 
			&& getBoard().getPiece(x+1, y-1).getColour() != this.getColour()){
			m = new Move(this, x, y, x+1, y-1);
			v.add(m);
		}
		if (x+1 <= 7 && !getBoard().occupied(x+1, y)){
			m = new Move(this, x, y, x+1, y);
			v.add(m);
		}
		if (x+1 <= 7 && getBoard().occupied(x+1, y) 
			&& getBoard().getPiece(x+1, y).getColour() != this.getColour()){
			m = new Move(this, x, y, x+1, y);
			v.add(m);
		}
		if (x+1 <= 7 && y+1 <= 7 && !getBoard().occupied(x+1, y+1)){
			m = new Move(this, x, y, x+1, y+1);
			v.add(m);
		}
		if (x+1 <= 7 && y+1 <= 7 && getBoard().occupied(x+1, y+1) 
			&& getBoard().getPiece(x+1, y+1).getColour() != this.getColour()){
			m = new Move(this, x, y, x+1, y+1);
			v.add(m);
		}
		if (y+1 <= 7 && !getBoard().occupied(x, y+1)){
			m = new Move(this, x, y, x, y+1);
			v.add(m);
		}
		if (y+1 <= 7 && getBoard().occupied(x, y+1) 
			&& getBoard().getPiece(x, y+1).getColour() != this.getColour()){
			m = new Move(this, x, y, x, y+1);
			v.add(m);
		}
		if (x-1 >= 0 && y+1 <= 7 && !getBoard().occupied(x-1, y+1)){
			m = new Move(this, x, y, x-1, y+1);
			v.add(m);
		}
		if (x-1 >= 0 && y+1 <= 7 && getBoard().occupied(x-1, y+1) 
			&& getBoard().getPiece(x-1, y+1).getColour() != this.getColour()){
			m = new Move(this, x, y, x-1, y+1);
			v.add(m);
		}
		if (x-1 >= 0 && !getBoard().occupied(x-1, y)){
			m = new Move(this, x, y, x-1, y);
			v.add(m);
		}
		if (x-1 >= 0 && getBoard().occupied(x-1, y) 
			&& getBoard().getPiece(x-1, y).getColour() != this.getColour()){
			m = new Move(this, x, y, x-1, y);
			v.add(m);
		}
		if (x-1 >= 0 && y-1 >= 0 && !getBoard().occupied(x-1, y-1)){
			m = new Move(this, x, y, x-1, y-1);
			v.add(m);
		}
		if (x-1 >= 0 && y-1 >= 0 && getBoard().occupied(x-1, y-1) 
			&& getBoard().getPiece(x-1, y-1).getColour() != this.getColour()){
			m = new Move(this, x, y, x-1, y-1);
			v.add(m);
		}
		if (v.isEmpty()) return null;
		return v;
	}
}
