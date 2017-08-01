package uk.ac.sheffield.aca14gk;

/**
* Queen.java 
*
* Class to represent a queen
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.util.ArrayList;

public class Queen extends Piece  {
	
	public Queen(int ix, int iy, int c, Board b){
		super(PieceCode.QUEEN, ix, iy, c, b);
	}
	
	public ArrayList<Move> availableMoves() {
		return pieceQueen();
	}
	
	//combination of bishops chechBishop and rooks chechRook
	private int checkQueen(String s, int x, int y, int m){	
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
	
	private ArrayList<Move> pieceQueen() {
		int x = getX();
		int y = getY();
		
		ArrayList<Move> v = new ArrayList<Move>();
	      
		Move m = null;
		
		//combination of bishops availableMoves and rooks availableMoves 
		for (int a = 1; a < 8 ; a++){
			if (x+a >= 0 && x+a < 8 && y-a >= 0 && y-a < 8){
				if (checkQueen("ne", x, y, a) == a){
					m = new Move(this, x, y, x+a, y-a); 
					v.add(m);
				}
				if (getBoard().occupied(x+a, y-a) && checkQueen("ne", x, y, a-1) == a-1 
					&& getBoard().getPiece(x+a, y-a).getColour() != this.getColour()){
					m = new Move(this, x, y, x+a, y-a); 
					v.add(m);
				}
			}
			if (x+a >= 0 && x+a < 8 && y+a >= 0 && y+a < 8){
				if (checkQueen("se", x, y, a) == a){
					m = new Move(this, x, y, x+a, y+a);
					v.add(m);
				}
				if (getBoard().occupied(x+a, y+a) && checkQueen("se", x, y, a-1) == a-1 
					&& getBoard().getPiece(x+a, y+a).getColour() != this.getColour()){
					m = new Move(this, x, y, x+a, y+a); 
					v.add(m);
				}
			}
			if (x-a >=0 && x-a < 8 && y+a >= 0 && y+a < 8){
				if (checkQueen("sw", x, y, a) == a){
					m = new Move(this, x, y, x-a, y+a); 
					v.add(m);
				}
				if (getBoard().occupied(x-a, y+a) && checkQueen("sw", x, y, a-1) == a-1 
					&& getBoard().getPiece(x-a, y+a).getColour() != this.getColour()){
					m = new Move(this, x, y, x-a, y+a); 
					v.add(m);
				}
			}
			if (x-a >=0 && x-a < 8 && y-a >= 0 && y-a < 8){
				if (checkQueen("nw", x, y, a) == a){
					m = new Move(this, x, y, x-a, y-a); 
					v.add(m);
				}
				if (getBoard().occupied(x-a, y-a) && checkQueen("nw", x, y, a-1) == a-1 
					&& getBoard().getPiece(x-a, y-a).getColour() != this.getColour()){
					m = new Move(this, x, y, x-a, y-a); 
					v.add(m);
				}
			}
			if(y+a >= 0 && y+a <= 7){
				if (checkQueen("s", x, y, a) == a){
					m = new Move(this, x, y, x, y+a); 
					v.add(m);
				}
				if (getBoard().occupied(x, y+a) && checkQueen("s", x, y, a-1) == a-1 
				    && getBoard().getPiece(x, y+a).getColour() != this.getColour()){
					m = new Move(this, x, y, x, y+a);
					v.add(m);
				}
			}
			if(y-a >= 0 && y-a <= 7){
				if (checkQueen("n", x, y, a) == a){
					m = new Move(this, x, y, x, y-a); 
					v.add(m);
				}
				if (getBoard().occupied(x, y-a) && checkQueen("n", x, y, a-1) == a-1 
					&& getBoard().getPiece(x, y-a).getColour() != this.getColour()){
					m = new Move(this, x, y, x, y-a);
					v.add(m);
				}
			}
			if(x+a >= 0 && x+a <= 7){
				if (checkQueen("e", x, y, a) == a){
					m = new Move(this, x, y, x+a, y); 
					v.add(m);
				}
				if (getBoard().occupied(x+a, y) && checkQueen("e", x, y, a-1) == a-1 
					&& getBoard().getPiece(x+a, y).getColour() != this.getColour()){
					m = new Move(this, x, y, x+a, y); 
					v.add(m);
				}
			}
			if(x-a >= 0 && x-a <= 7){
				if (checkQueen("w", x, y, a) == a){
					m = new Move(this, x, y, x-a, y); 
					v.add(m);
				}
				if (getBoard().occupied(x-a, y) && checkQueen("w", x, y, a-1) == a-1 
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
