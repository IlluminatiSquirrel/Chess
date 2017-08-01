package uk.ac.sheffield.aca14gk;

/**
* Move.java 
*
* Class to represent a single move
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

public class Move {
	
	private Piece piece;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Move(Piece p, int ix, int iy, int jx, int jy){
		piece = p;
		x1 = ix;
		y1 = iy;
		x2 = jx;
		y2 = jy;
	}
	
	//method returns true if references of the current move object are equal to
	//references of some other move object
	public boolean equals(Piece p, int ix, int iy, int jx, int jy){
		if (piece == p && x1 == ix && y1 == iy && x2 == jx && y2 == jy)
			return true;
		else
			return false;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	public int getX1(){
		return x1;
	}
	
	public int getY1(){
		return y1;
	}
	
	public int getX2(){
		return x2;
	}
	
	public int getY2(){
		return y2;
	}
}