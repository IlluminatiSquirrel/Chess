package uk.ac.sheffield.aca14gk;

/**
* Knight.java 
*
* Class to represent a knight
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.*;

public class Knight extends Piece {

	public Knight(int ix, int iy, int c, Board b){
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}
	
	// method implements abstract method in Piece class
	public ArrayList<Move> availableMoves() {
		return pieceKnight();
	}
	
	private ArrayList<Move> pieceKnight() {
		int x = getX();
		int y = getY();
	
	    ArrayList<Move> v = new ArrayList<Move>();
	       
	    Move m = null;

	    // each if statement checks if the next move doesn't take the piece of the board
	 	// and whether the last space is occupied or not
	    // in total knight has 16 possible moves (8 moves plus 8 capturing other piece moves)
		if (x+1 < 8 && y-2 >= 0 && !getBoard().occupied(x+1, y-2)){
			m = new Move(this, x, y, x+1, y-2);
			v.add(m);
		}
		if (x+1 < 8 && y-2 >= 0 && getBoard().occupied(x+1, y-2) 
			&& getBoard().getPiece(x+1, y-2).getColour() != this.getColour()){
			m = new Move(this, x, y, x+1, y-2);
			v.add(m);
		}
		if (x+2 < 8 && y-1 >= 0 && !getBoard().occupied(x+2, y-1)){
			m = new Move(this, x, y, x+2, y-1);
			v.add(m);
		}
		if (x+2 < 8 && y-1 >= 0 && getBoard().occupied(x+2, y-1) 
			&& getBoard().getPiece(x+2, y-1).getColour() != this.getColour()){
			m = new Move(this, x, y, x+2, y-1);
			v.add(m);
		}
		if (x+2 < 8 && y+1 < 8 && !getBoard().occupied(x+2, y+1)){
			m = new Move(this, x, y, x+2, y+1);
			v.add(m);
		}
		if (x+2 < 8 && y+1 < 8 && getBoard().occupied(x+2, y+1) 
			&& getBoard().getPiece(x+2, y+1).getColour() != this.getColour()){
			m = new Move(this, x, y, x+2, y+1);
			v.add(m);
		}
		if (x+1 < 8 && y+2 < 8 && !getBoard().occupied(x+1, y+2)){
			m = new Move(this, x, y, x+1, y+2);
			v.add(m);
		}
		if (x+1 < 8 && y+2 < 8 && getBoard().occupied(x+1, y+2) 
			&& getBoard().getPiece(x+1, y+2).getColour() != this.getColour()){
			m = new Move(this, x, y, x+1, y+2);
			v.add(m);
		}
		if (x-1 >= 0 && y+2 < 8 && !getBoard().occupied(x-1, y+2)){
			m = new Move(this, x, y, x-1, y+2);
			v.add(m);
		}
		if (x-1 >= 0 && y+2 < 8 && getBoard().occupied(x-1, y+2) 
			&& getBoard().getPiece(x-1, y+2).getColour() != this.getColour()){
			m = new Move(this, x, y, x-1, y+2);
			v.add(m);
		}
		if (x-2 >= 0 && y+1 < 8 && !getBoard().occupied(x-2, y+1)){
			m = new Move(this, x, y, x-2, y+1);
			v.add(m);
		}
		if (x-2 >= 0 && y+1 < 8 && getBoard().occupied(x-2, y+1) 
			&& getBoard().getPiece(x-2, y+1).getColour() != this.getColour()){
			m = new Move(this, x, y, x-2, y+1);
			v.add(m);
		}
		if (x-2 >= 0 && y-1 >= 0 && !getBoard().occupied(x-2, y-1)){
			m = new Move(this, x, y, x-2, y-1);
			v.add(m);
		}
		if (x-2 >= 0 && y-1 >= 0 && getBoard().occupied(x-2, y-1) 
			&& getBoard().getPiece(x-2, y-1).getColour() != this.getColour()){
			m = new Move(this, x, y, x-2, y-1);
			v.add(m);
		}
		if (x-1 >= 0 && y-2 >= 0 && !getBoard().occupied(x-1, y-2)){
			m = new Move(this, x, y, x-1, y-2);
			v.add(m);
		}
		if (x-1 >= 0 && y-2 >= 0 && getBoard().occupied(x-1, y-2) 
			&& getBoard().getPiece(x-1, y-2).getColour() != this.getColour()){
			m = new Move(this, x, y, x-1, y-2);
			v.add(m);
		}	
		if (v.isEmpty()) return null;
		return v;
	}	    
}
