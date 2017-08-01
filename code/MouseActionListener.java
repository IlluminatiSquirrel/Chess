package uk.ac.sheffield.aca14gk;

/**
* MouseActionListener.java 
*
* Class listens to the mouse and performs actions
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseActionListener implements MouseListener {
	
	JPanel board;
	JLabel chessPiece;
	JPanel startPanel;
	JPanel destPanel;
	Point piecePos1;
	Point piecePos2;
	int click = 0;
	
	public MouseActionListener(JPanel b){
		board = b;
	}
	
	public void mouseClicked(MouseEvent e){
		
		click++;
		
		//click == 1 means the piece has been selected
		if (click == 1){
			Component c = board.findComponentAt(e.getX(), e.getY());
			piecePos1 = c.getParent().getLocation();
			
			if (c instanceof JPanel) 
				  return;
			chessPiece = (JLabel)c;
			startPanel = (JPanel)board.getComponentAt(e.getX(), e.getY());
			startPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		
		//click == 2 means that the pieces destination has been selected
		else{
			click = 0; //resets click counter
			Component b =  board.findComponentAt(e.getX(), e.getY());
			destPanel = (JPanel)board.getComponentAt(e.getX(), e.getY());
			
			if (b instanceof JLabel && chessPiece != null){
				piecePos2 = b.getParent().getLocation();
				startPanel.setBorder(BorderFactory.createEmptyBorder());
				chessPiece = null;
				HumanPlayer.selected = true;
			}
			else if (b instanceof JPanel && chessPiece != null){
				piecePos2 = b.getLocation();
				startPanel.setBorder(BorderFactory.createEmptyBorder());
				chessPiece = null;
				HumanPlayer.selected = true;
			}
		}
	}	
	
	//returns the point of pieces starting position
	public Point getPiecePos1(){
		return piecePos1;
	}
	
	//returns the point of pieces destination
	public Point getPiecePos2(){
		return piecePos2;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

}