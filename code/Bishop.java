package uk.ac.sheffield.aca14gk;

/**
* Bishop.java 
*
* Class to represent a bishop
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(int ix, int iy, int c, Board b){
		super(PieceCode.BISHOP, ix, iy, c, b);
	}

	// method implements abstract method in Piece class
	public ArrayList<Move> availableMoves() {
		return pieceBishop();
	}
	
	//method returns how many unoccupied spaces there are for a given direction from
	//start point coordinate to the end point coordinate
	private int checkBishop(String s, int x, int y, int m){
		int count;
		if (s == "ne"){ // northeast direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x+b, y-b))
					count++;
			return count;
		}
		if (s == "se"){ //southeast direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x+b, y+b))
					count++;
			return count;
		}
		if (s == "sw"){ //southwest direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x-b, y+b))
					count++;
			return count;
		}
		if (s == "nw"){ //northwest direction
			count = 0;
			for (int b = 1; b <= m; b++)
				if(!getBoard().occupied(x-b, y-b))
					count++;
			return count;
		}
		return 0;
	}
		
	private ArrayList<Move> pieceBishop() {
		int x = getX();
		int y = getY();
		
		ArrayList<Move> v = new ArrayList<Move>();
	      
		Move m = null;
		
		//as bishop can move from 1 to 7 spaces
		//with each iteration this loop increases bishops path length by one
		//then the if statement checks if the next move doesn't take the piece of the board
		//if not the next if statements checks whether there are enough unoccupied spaces
		//and if the last space is occupied or not
		for (int a = 1; a < 8 ; a++){
			if (x+a >= 0 && x+a < 8 && y-a >= 0 && y-a < 8){
				if (checkBishop("ne", x, y, a) == a){
					m = new Move(this, x, y, x+a, y-a); 
					v.add(m);
				}
				if (getBoard().occupied(x+a, y-a) && checkBishop("ne", x, y, a-1) == a-1 
					&& getBoard().getPiece(x+a, y-a).getColour() != this.getColour()){
					m = new Move(this, x, y, x+a, y-a); 
					v.add(m);
				}
			}
			if (x+a >= 0 && x+a < 8 && y+a >= 0 && y+a < 8){
				if (checkBishop("se", x, y, a) == a){
					m = new Move(this, x, y, x+a, y+a);
					v.add(m);
				}
				if (getBoard().occupied(x+a, y+a) && checkBishop("se", x, y, a-1) == a-1 
					&& getBoard().getPiece(x+a, y+a).getColour() != this.getColour()){
					m = new Move(this, x, y, x+a, y+a); 
					v.add(m);
				}
			}
			if (x-a >=0 && x-a < 8 && y+a >= 0 && y+a < 8){
				if (checkBishop("sw", x, y, a) == a){
					m = new Move(this, x, y, x-a, y+a); 
					v.add(m);
				}
				if (getBoard().occupied(x-a, y+a) && checkBishop("sw", x, y, a-1) == a-1 
					&& getBoard().getPiece(x-a, y+a).getColour() != this.getColour()){
					m = new Move(this, x, y, x-a, y+a); 
					v.add(m);
				}
			}
			if (x-a >=0 && x-a < 8 && y-a >= 0 && y-a < 8){
				if (checkBishop("nw", x, y, a) == a){
					m = new Move(this, x, y, x-a, y-a); 
					v.add(m);
				}
				if (getBoard().occupied(x-a, y-a) && checkBishop("nw", x, y, a-1) == a-1 
					&& getBoard().getPiece(x-a, y-a).getColour() != this.getColour()){
					m = new Move(this, x, y, x-a, y-a); 
					v.add(m);
				}
			}
		}
		if (v.isEmpty()) return null;
		return v;
	}
}
