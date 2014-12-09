import Exceptions.InvalidNumberOfPlayersException;
import Exceptions.InvalidPlayerException;



public class TicTacToeGame implements Game {
	private Board board = null;
	private Player[] players = null;
	private Player currentplayer = null;
	private GameStatus gameStatus = GameStatus.NOTSTARTED;

	public TicTacToeGame(Board board, Player[] players) throws Exception {
		if (players==null || players.length!=2) {
			throw(new InvalidNumberOfPlayersException("Invalid Number Of Players"));
		};
		this.board = board;
		this.players = players;
		this.currentplayer = players[0];
		
	}

	@Override
	public Board getBoard() {
		return this.board;
	}

	@Override
	public Player[] getPlayers() {
		return this.players;
	}

	@Override
	public Integer getMaximumNumberOfPlayers() {
		return 2;
	}

	@Override
	public Player getCurrentPlayer() {
		return currentplayer;
	}

	@Override
	public void setCurrentPlayer(Player player) throws InvalidPlayerException {
		if(!playerExists(player)) {
			throw(new InvalidPlayerException("Invalid player!"));
		} else {
			this.currentplayer = player;
		}
	}
	
	private boolean playerExists(Player player) {
		for(int i=0; i<players.length; i++) {
			if(players[i]==player) {
				return true;
			}
		}
		return false;
	}

	@Override
	public GameStatus getStatus() {
		return this.gameStatus;
	}

	@Override
	public void play() {
		this.gameStatus = GameStatus.STARTED;
	}
}
