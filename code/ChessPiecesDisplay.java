package uk.ac.sheffield.aca14gk;

/**
* ChessPiecesGUI.java 
*
* Class to represent graphical display of chess pieces
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessPiecesDisplay {
	
	JPanel panel;
	
	//method adds all chess pieces to the board
	public ChessPiecesDisplay(JPanel cb){
		
		addPiece("images/white_rook.png", 0, cb);
		addPiece("images/white_knight.png", 1, cb);
		addPiece("images/white_bishop.png", 2, cb);
		addPiece("images/white_queen.png", 3, cb);
		addPiece("images/white_king.png", 4, cb);
		addPiece("images/white_bishop.png", 5, cb);
		addPiece("images/white_knight.png", 6, cb);
		addPiece("images/white_rook.png", 7, cb);
		for (int i = 8; i < 16; i++){
			addPiece("images/white_pawn.png", i, cb);
		}
		for (int i = 48; i < 56; i++){
			addPiece("images/black_pawn.png", i, cb);
		}
		addPiece("images/black_rook.png", 56, cb);
		addPiece("images/black_knight.png", 57, cb);
		addPiece("images/black_bishop.png", 58, cb);
		addPiece("images/black_queen.png", 59, cb);
		addPiece("images/black_king.png", 60, cb);
		addPiece("images/black_bishop.png", 61, cb);
		addPiece("images/black_knight.png", 62, cb);
		addPiece("images/black_rook.png", 63, cb);
	}
	
	//method adds a piece to the board
	public void addPiece(String s, int i, JPanel cb){
		JLabel piece = new JLabel( new ImageIcon(s));
		panel = (JPanel)cb.getComponent(i);
		panel.setName(s);
		panel.setLayout(new BorderLayout());
		panel.add(piece, BorderLayout.CENTER);
	}
	
	//method deletes the piece from the board
	public void deletePiece(int i, JPanel cb){
		panel = (JPanel)cb.getComponent(i);
		panel.removeAll();
	}
	
	//method gets the filename of the piece
	public String getFilename(int i, JPanel cb){
		panel = (JPanel)cb.getComponent(i);
		String s = panel.getName();
		return s;
	}
	
	//method updates the board
	public void update(){
		panel.revalidate();
		panel.repaint();
	}
	
	public JPanel getPanel(){
		return panel;
	}
}