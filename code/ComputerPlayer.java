package uk.ac.sheffield.aca14gk;

/**
* ComputerPlayer.java 
*
* An interface to be used for random and aggressive players
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

public interface ComputerPlayer{
	
	public void getAllAvailableMoves();
	
	public void selectRandomMove();
	
	public void getCoordinates();
	
}