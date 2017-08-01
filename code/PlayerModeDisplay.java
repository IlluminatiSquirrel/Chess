package uk.ac.sheffield.aca14gk;

/**
* PlayerModeGUI.java 
*
* Class to open a window at a start of the game
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerModeDisplay extends JFrame{
	
	Container contentPane = getContentPane();
	Font plainFont = new Font("Calibri", Font.PLAIN, 14);
	Font boldFont = new Font("Calibri", Font.BOLD, 16);
	JComboBoxListener listener = new JComboBoxListener();
	
	static boolean selected = false; // keeps track whether the type of player has been selected
	static boolean startGame = false; // keeps track whether 'start game' button has been clicked
	
	public void selectGameMode(){
		
		setTitle("Welcome!");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = toolkit.getScreenSize();
		
		setSize(500, 180);
		setLocation(new Point(screenDimension.width/3, screenDimension.height/3));
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 235, 166));
		
		JLabel label = new JLabel();
		label.setText("Welcome to the game of chess. Please choose the type of players.");
		label.setFont(boldFont);
		label.setBounds(20, 10, 450, 30);
		
		//creates 1st JComboBox
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Human Player");
		comboBox.addItem("Random Player");
		comboBox.addItem("Aggressive Player");
		comboBox.setSelectedIndex(-1);
		comboBox.setFont(plainFont);
		comboBox.setBounds(70, 50, 140, 20);
		comboBox.addActionListener(listener);
		
		//creates 2nd JComboBox
		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.addItem("Human Player");
		comboBox2.addItem("Random Player");
		comboBox2.addItem("Aggressive Player");
		comboBox2.setSelectedIndex(-1);
		comboBox2.setFont(plainFont);
		comboBox2.setBounds(270, 50, 140, 20);
		comboBox2.addActionListener(listener);
		
		JLabel label2 = new JLabel("against");
		label2.setBounds(219, 50, 50, 20);
		label2.setFont(plainFont);
		
		//creates 'start game' button
		JButton button = new JButton();
		button.setText("Start game");
		button.setBounds(189, 90, 100, 30);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (selected){
					startGame = true;
					dispose();
				}
			}
		});
		
		contentPane.add(label);
		contentPane.add(comboBox);
		contentPane.add(comboBox2);
		contentPane.add(label2);
		contentPane.add(button);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//method returns which type of player has been chosen
	public Object getItem(){
		selected = false;
		//waits until an item in JComboBox has been selected
		while (!PlayerModeDisplay.selected){
	        try {
		        Thread.sleep(5);
		    } catch(InterruptedException ex) {
		        Thread.currentThread().interrupt();
		    }
		}
		return listener.getItem();
	}
}