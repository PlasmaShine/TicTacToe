import Exceptions.InvalidPlayerException;



public interface Game {

	public enum GameStatus{
		NOTSTARTED,
		STARTED,
	};
	
	Board getBoard();
	Player[] getPlayers();
	Integer getMaximumNumberOfPlayers();
	Player getCurrentPlayer();
	void setCurrentPlayer(Player player) throws InvalidPlayerException;
	Game.GameStatus getStatus();
	void play();

}
