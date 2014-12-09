import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exceptions.InvalidNumberOfPlayersException;
import Exceptions.InvalidPlayerException;

public class GameTests {
	private Game game;
	private Board board;

	private Player[] createPlayers(Integer numberOfPlayers) {
		Player[] players = new Player[numberOfPlayers];
		for (int i=0;i<numberOfPlayers;i++) {
			players[i] = new Player();
		}
		return players;
	}
	
	private void assertGameThrowsInvalidNumberOfPlayersException(String message, Player[] players) {
		try{
			game = new TicTacToeGame(board, players);
			fail(message);
		} catch (Exception thrownEx) {
			InvalidNumberOfPlayersException expected = new InvalidNumberOfPlayersException();
			assertEquals("Invalid exception thrown!", expected.getClass(), thrownEx.getClass());
		}
	}
	
	private void createNewGame() throws Exception {
		Player[] players = createPlayers(2);
		game = new TicTacToeGame(board, players);
	}
	
	private void assertGameThrowsInvalidPlayerException(String message, Player player) {
		try{
			game.setCurrentPlayer(player);
			fail(message);
		} catch (Exception thrownEx) {
			InvalidPlayerException expected = new InvalidPlayerException();
			assertEquals("Invalid exception thrown!", expected.getClass(), thrownEx.getClass());
		}
	}
	
	@Before
	public void setUp() {
		board = new TicTacToeBoard();		
	}
	
	@Test
	public void gameHasABoard() throws Exception {
		Player[] players = createPlayers(2);
		game = new TicTacToeGame(board, players);
		assertTrue("Game should have a board!", game.getBoard()!=null);
	}
	
	@Test
	public void gameHasPlayers() throws Exception {
		Player[] players = createPlayers(2);
		game = new TicTacToeGame(board, players);
		assertTrue("Game should have players!", game.getPlayers()!=null);
		assertArrayEquals("Players should be those previously set", players, game.getPlayers());
	}

	@Test
	public void gameHasMaximumNumberOfPlayersof2() throws Exception {
		createNewGame();
		assertEquals("Maximum number of players should be 2", (Integer)2, game.getMaximumNumberOfPlayers());
	}
	
	@Test
	public void gameWillNotAcceptMoreThan2Players() throws Exception {
		Player[] players = createPlayers(3);
		assertGameThrowsInvalidNumberOfPlayersException("Should not be able to set more than 2 players", players);
	}

	@Test
	public void gameWillNotAcceptLessThan2Players() throws Exception {
		Player[] players = createPlayers(1);
		assertGameThrowsInvalidNumberOfPlayersException("Should not be able to set less than 2 players", players);
	}

	@Test
	public void gameWillNotAcceptNullPlayers() throws Exception {
		assertGameThrowsInvalidNumberOfPlayersException("Should not be able to set null players", null);
	}
	
	@Test
	public void currentPlayerForNewGameIsFirstPlayer() throws Exception {
		createNewGame();
		assertEquals("Current player should be first player", game.getPlayers()[0], game.getCurrentPlayer());
	}

	@Test
	public void canSetCurrentPlayerOfGame() throws Exception {
		createNewGame();
		game.setCurrentPlayer(game.getPlayers()[1]);
		assertEquals("Current player should be second player", game.getPlayers()[1], game.getCurrentPlayer());
	}

	@Test
	public void settingNonExistentPlayerThrowsNonExistentPlayerException() throws Exception {
		createNewGame();
		assertGameThrowsInvalidPlayerException("Should not be able to set this player", null);
	}
	
	@Test
	public void newGameStatusIsNotStaterd() throws Exception{
		createNewGame();
		assertEquals("Game should not be strated", Game.GameStatus.NOTSTARTED, game.getStatus());	
	}

	@Test
	public void startingGameSetsStatusToStaterd() throws Exception{
		createNewGame();
		game.play();
		assertEquals("Game should be strated", Game.GameStatus.STARTED, game.getStatus());	
	}
}
