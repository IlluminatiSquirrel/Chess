package uk.ac.sheffield.aca14gk;

/**
* ChessPiecesGUI.java 
*
* Class to open a window at the end of the game
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Container;
import javax.swing.*;

public class GameEndDisplay extends JFrame{
	
	Container contentPane = getContentPane();
	
	public void showGraphicalDisplay(String s){
		
		setTitle("Game Over");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = toolkit.getScreenSize();
		
		setSize(300, 200);
		setLocation(new Point(screenDimension.width/3, screenDimension.height/3));
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 235, 166));

		JLabel label = new JLabel("The winner is");
		label.setBounds(90, 40, 150, 20);
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JLabel label2 = new JLabel(s);
		label2.setBounds(73, 80, 150, 20);
		label2.setFont(new Font("Calibri", Font.BOLD, 25));
		
		contentPane.add(label);
		contentPane.add(label2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
}