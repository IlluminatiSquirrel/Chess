package uk.ac.sheffield.aca14gk;

/**
* JComboBoxListener.java 
*
* Class listens to JComboBox and performs actions
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class JComboBoxListener implements ActionListener {
	Object item;
	
  	public void actionPerformed(ActionEvent e) {
  		PlayerModeDisplay.selected = true;
  		JComboBox cb = (JComboBox) e.getSource();
	    item = cb.getSelectedItem();
	    cb.setEnabled(false);
	    UIManager.put( "ComboBox.disabledForeground", Color.GRAY );
  	}
  	
  	public Object getItem(){
  		return item;
  	}
}
