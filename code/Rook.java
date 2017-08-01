package uk.ac.sheffield.aca14gk;

/**
* Rook.java 
*
* Class to represent a rook
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class Rook extends Piece {

	public Rook(int ix, int iy, int c, Board b){
		super(PieceCode.ROOK, ix, iy, c, b);
	}
	
	public ArrayList<Move> availableMoves() {
		return Rookpiece();
	}
	
	//method returns how many unoccupied spaces there are for a given direction from
	//start point coordinate to the end point coordinate
	private int checkRook(String s, int x, int y, int m){
		int count;
		if (s == "s"){ //south direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x, y+b))
					count++;
			return count;
		}
		if (s == "n"){ //north direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x, y-b))
					count++;
			return count;
		}
		if (s == "e"){ //east direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x+b, y))
					count++;
			return count;
		}
		if (s == "w"){ //west direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x-b, y))
					count++;
			return count;
		}
		return 0;
	}
	
	private ArrayList<Move> Rookpiece() {
		int x = getX();
		int y = getY();
		      
		ArrayList<Move> v = new ArrayList<Move>();
		      
		Move m = null;
		
		//as rook can move from 1 to 7 spaces
		//with each iteration this loop increases rooks path length by one
		//then the if statement checks if the next move doesn't take the piece of the board
		//if not the next if statements checks whether there are enough unoccupied spaces
		//and if the last space is occupied or not
		for (int a = 1; a < 8 ; a++){
			if(y+a >= 0 && y+a <= 7){
				if (checkRook("s", x, y, a) == a){
					m = new Move(this, x, y, x, y+a); 
					v.add(m);
				}
				if (getBoard().occupied(x, y+a) && checkRook("s", x, y, a-1) == a-1 
				    && getBoard().getPiece(x, y+a).getColour() != this.getColour()){
					m = new Move(this, x, y, x, y+a);
					v.add(m);
				}
			}
			if(y-a >= 0 && y-a <= 7){
				if (checkRook("n", x, y, a) == a){
					m = new Move(this, x, y, x, y-a); 
					v.add(m);
				}
				if (getBoard().occupied(x, y-a) && checkRook("n", x, y, a-1) == a-1 
					&& getBoard().getPiece(x, y-a).getColour() != this.getColour()){
					m = new Move(this, x, y, x, y-a);
					v.add(m);
				}
			}
			if(x+a >= 0 && x+a <= 7){
				if (checkRook("e", x, y, a) == a){
					m = new Move(this, x, y, x+a, y); 
					v.add(m);
				}
				if (getBoard().occupied(x+a, y) && checkRook("e", x, y, a-1) == a-1 
					&& getBoard().getPiece(x+a, y).getColour() != this.getColour()){
					m = new Move(this, x, y, x+a, y); 
					v.add(m);
				}
			}
			if(x-a >= 0 && x-a <= 7){
				if (checkRook("w", x, y, a) == a){
					m = new Move(this, x, y, x-a, y); 
					v.add(m);
				}
				if (getBoard().occupied(x-a, y) && checkRook("w", x, y, a-1) == a-1 
					&& getBoard().getPiece(x-a, y).getColour() != this.getColour()){
					m = new Move(this, x, y, x-a, y); 
					v.add(m);
				}
			}
		}
		if (v.isEmpty()) return null;
		return v;
	}    
}
