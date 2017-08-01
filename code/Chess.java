package uk.ac.sheffield.aca14gk;

/**
* Chess.java 
*
* Main class that launches the game
*
* @version 1.1 14 May 2015
*
* @author Gabriele Kukauskaite
*/

public class Chess {
	public static void main(String[] args){
		
		//opens a window to choose the type of players
		PlayerModeDisplay pm = new PlayerModeDisplay();
		pm.selectGameMode();
		
		String player1Type = (String)pm.getItem();
		String player2Type = (String)pm.getItem();
		
		Board chessboard = new Board();
		Pieces chesspieces1 = new Pieces(chessboard, 1);
		Pieces chesspieces2 = new Pieces(chessboard, 0);
		ChessBoardDisplay chessBoardDisplay = new ChessBoardDisplay();
		Player opponent = null;
		
		Player chessplayer1 = null;
		Player chessplayer2 = null;
		
		String name1 = "White Player";
		String name2 = "Black Player";
		
		//creates first chess player based on the user's input
		if (player1Type.equals("Human Player"))
			chessplayer1 = new HumanPlayer(name1, chesspieces1, chessboard, opponent, chessBoardDisplay);
		else if (player1Type.equals("Random Player"))
			chessplayer1 = new RandomPlayer(name1, chesspieces1, chessboard, opponent, chessBoardDisplay);
		else 
			chessplayer1 = new AggressivePlayer(name1, chesspieces1, chessboard, opponent, chessBoardDisplay);
		
		//creates second chess player based on the user's input
		if (player2Type.equals("Human Player"))
			chessplayer2 = new HumanPlayer(name2, chesspieces2, chessboard, opponent, chessBoardDisplay);
		else if (player2Type.equals("Random Player"))
			chessplayer2 = new RandomPlayer(name2, chesspieces2, chessboard, opponent, chessBoardDisplay);
		else 
			chessplayer2 = new AggressivePlayer(name2, chesspieces2, chessboard, opponent, chessBoardDisplay);
		
		chessplayer1.setOpponent(chessplayer2);
		chessplayer2.setOpponent(chessplayer1);
		
		//program sleeps and checks whether 'start game' button has been clicked every 5ms
		while (!PlayerModeDisplay.startGame){
	        try {
		        Thread.sleep(5);
		    } catch(InterruptedException ex) {
		        Thread.currentThread().interrupt();
		    }
		}
		
		//opens a window displaying chessboard and chess pieces 
		GraphicalDisplay gdisplay = new GraphicalDisplay(chessBoardDisplay);
		gdisplay.showGraphicalDisplay();
		
		boolean move; // to track if the move has been made or not
		String winner = null; 
		
		// continue the game while white king and black king is in game
		while (chessplayer1.whiteKingCheck() && chessplayer2.blackKingCheck()){
			move = false;
			while (!move)
				move = chessplayer1.makeMove();
			if (!chessplayer2.blackKingCheck()){
				winner = name1;
				break;
			}
		
			move = false;
			while (!move)
				move = chessplayer2.makeMove();
			if (!chessplayer1.whiteKingCheck()){
				winner = name2;
				break;
			}
		}
		
		//pops up the window stating that the game is over
		GameEndDisplay gameOver = new GameEndDisplay();
		gameOver.showGraphicalDisplay(winner);
	}
}