package uk.ac.sheffield.aca14gk;

/**
* ChessBoardGUI.java 
*
* Class to represent graphical display of chessboard
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessBoardDisplay extends JFrame implements MouseListener{
	
	Color brown = new Color(169, 117, 49);
	Color lightBrown = new Color(247, 205, 140);
	JPanel chessBoard = new JPanel();
	JPanel board = board();
	
	ChessPiecesDisplay pieces = new ChessPiecesDisplay(board);
	
	//creates chessboard with letter and number panels
	public ChessBoardDisplay(){
		board.setBounds(30, 30, 450, 450);
		JLayeredPane letters1 = letterPanel();
		letters1.setBounds(30, 0, 450, 30);
		JLayeredPane letters2 = letterPanel();
		letters2.setBounds(30, 480, 450, 30);
		JLayeredPane numbers1 = numberPanel();
		numbers1.setBounds(0, 30, 30, 450);
		JLayeredPane numbers2 = numberPanel();
		numbers2.setBounds(480, 30, 30, 450);
		
		chessBoard.setLayout(null);
		chessBoard.setBounds(0, 0 , 510, 510);
		chessBoard.setOpaque(true);
		chessBoard.setBackground(new Color(70, 27, 5));
		
		chessBoard.add(letters1);
		chessBoard.add(letters2);
		chessBoard.add(numbers1);
		chessBoard.add(numbers2);
		chessBoard.add(board);

	}
	
	//method creates the board
	public JPanel board(){
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(8,8));
		for (int i = 1; i < 9; i++){
			for (int j = 1; j < 9; j++){
				JPanel square = new JPanel();
				board.add(square);
				square.setOpaque(true);
				if (i % 2 != 0 && j % 2 == 0)
					square.setBackground(brown);
				if (i % 2 != 0 && j % 2 != 0)
					square.setBackground(lightBrown);
				if (i % 2 == 0 && j % 2 == 0)
					square.setBackground(lightBrown);
				if (i % 2 == 0 && j % 2 != 0)
					square.setBackground(brown);
			}
		}
		
		return board;
	}
	
	//method creates letter panel that is to be added to the board
	public JLayeredPane letterPanel(){
		JLayeredPane letters = new JLayeredPane();
		letters.setLayout(new GridLayout(0,8));
		letters.setPreferredSize(new Dimension(450, 20));
		for (char i = 'A'; i < 'I'; i++){
			JLabel letter = new JLabel(Character.toString(i));
			letter.setHorizontalAlignment(JLabel.CENTER);
			letter.setForeground(lightBrown);
			letters.add(letter);
		}
		return letters;
	}
	
	//method creates number panel that is to be added to the board
	public JLayeredPane numberPanel(){
		JLayeredPane numbers = new JLayeredPane();
		numbers.setLayout(new GridLayout(8,0));
		for (int i = 1; i < 9; i++){
			JLabel number = new JLabel(Integer.toString(i));
			number.setPreferredSize(new Dimension(20, 450));
			number.setHorizontalAlignment(JLabel.CENTER);
			number.setForeground(lightBrown);
			numbers.add(number);
		}
		return numbers;
	}
	
	public JPanel getChessBoard(){
		return chessBoard;
	}
	
	public JPanel getBoard(){
		return board;
	}
	
	public ChessPiecesDisplay getPieces(){
		return pieces;
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}
}