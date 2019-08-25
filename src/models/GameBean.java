package models;

public class GameBean {

	String [] board = new String[9];
	String player = "O";
	int playerTurn = 0;

	public GameBean() {
		for(int i = 0; i < board.length; i++) {
			board[i] = "*";
		}
	}

	public void setMove(int loc) {
		board[loc] = player;
	}

	public String getMove(int loc) {
		return this.board[loc];
	}

	public void setPlayer() {
		if(player == "O") {
			player = "X";
		}
		else {
			player = "O";
		}
	}

	public String getPlayer() {
		return this.player;
	}

	public void setPlayerTurn() {
		playerTurn++;
	}

	public int getPlayerTurn() {
		return this.playerTurn;
	}

	public boolean isValid(int loc) {
		if(board[loc] == "X" || board[loc] == "O"){
			return false;
		}
		return true;
	}

	public String getWinnerWinnerChickenDinner() {
		String winner = "";
		for(int i = 0; i < board.length -1; i++) {
			switch(i) {
			case 0: winner = board[0] + board [1] + board[2];
				break;
			case 1: winner = board[3] + board [4] + board[5];
				break;
			case 2: winner = board[6] + board [7] + board[8];
				break;
			case 3: winner = board[0] + board [3] + board[6];
				break;
			case 4: winner = board[1] + board [4] + board[7];
				break;
			case 5: winner = board[2] + board [5] + board[8];
				break;
			case 6: winner = board[0] + board [4] + board[8];
				break;
			case 7: winner = board[2] + board [4] + board[6];
				break;

			}

			if(winner.equalsIgnoreCase("OOO")) {
				return "O";
			}
			else if(winner.equalsIgnoreCase("XXX")) {
				return "X";
			}
		}

		if(playerTurn >= 9) {
			return "Draw";
		}
		return null;
	}
}
