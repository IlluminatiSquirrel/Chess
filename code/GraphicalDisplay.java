package uk.ac.sheffield.aca14gk;

/**
* GraphicalDisplay.java 
*
* Class that opens a window displaying chessboard and chess pieces
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Container;

import javax.swing.*;

public class GraphicalDisplay extends JFrame implements Display{
	
	Container contentPane = getContentPane();
	ChessBoardDisplay chessBoardDisplay;
	
	public GraphicalDisplay(ChessBoardDisplay cb) {
		chessBoardDisplay = cb;
	}
	
	public void showGraphicalDisplay(){
		
		setTitle("Chess");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = toolkit.getScreenSize();
		
		setSize(526, 549);
		setLocation(new Point(screenDimension.width/4, screenDimension.height/10));
		
		contentPane.add(chessBoardDisplay.getChessBoard());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public ChessBoardDisplay getBoard(){
		return chessBoardDisplay;
	}
}