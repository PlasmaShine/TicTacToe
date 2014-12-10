import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exceptions.InvalidBoardException;


public class BoardTests {
	
	Board board = null;
	GamePiece gamePiece = null;
	private Position position;
	
	private boolean positionArrayContainsElement(Position[] availablePositions,
			Position position) {
		for (int i=0;i<availablePositions.length;i++) {
			if(availablePositions[i]==position) {
				return true;
			}
		}
		return false;
	}

	@Before
	public void setUp() throws Exception {
		board = new TicTacToeBoard(3);
		gamePiece = new GamePiece();
		position = new Position(1,1);
	}

	@Test
	public void settingABoardSizeOfThreeReturnsThreeAsTheSize() {
		assertEquals("Board should have a size of 3", this.board.getSize(), 3);
	}
	
	@Test
	public void settingABoardSizeToTwoReturnsTwoAsTheSize() throws InvalidBoardException {
		this.board = new TicTacToeBoard(2);
		assertEquals("Board should have a size of 2", this.board.getSize(), 2);
	}

	@Test
	public void settingBoardSizeLessThan2ThrowsInvalidBoardSizeException(){
		try{
			new TicTacToeBoard(1);
			fail("An invalid board exceptions should have been thrown!");
		} catch (Exception thrownEx) {
			InvalidBoardException expected = new InvalidBoardException();
			assertEquals("Expected invalid board exception!", expected.getClass(), thrownEx.getClass());
		}
	}
	
	@Test
	public void initialBoardHasAllPositionsAvailable() {
		assertEquals("All positions on the board should be available!", this.board.getSize()*this.board.getSize(), board.getAvailablePositions().length);
	}
	
	@Test
	public void canPlacePieceOnBoard(){
		this.board.setPieceAtPosition(this.gamePiece, position);
		assertEquals("Should have been able to place piece on board", gamePiece, board.getPieceAtPosition(position));
		assertEquals("All but one position on the board should be available", this.board.getSize()*this.board.getSize()-1,board.getAvailablePositions().length);
	}

	@Test
	public void canPlaceTwoDifferentPiecesOnBoard(){
		Position secondPosition = new Position(2,2);
		GamePiece secondGamePiece = new GamePiece();
		this.board.setPieceAtPosition(gamePiece, position);
		this.board.setPieceAtPosition(secondGamePiece, secondPosition);
		assertEquals("Should have been able to place piece1 on board", this.gamePiece, board.getPieceAtPosition(position));
		assertEquals("Should have been able to place piece2 on board", secondGamePiece, board.getPieceAtPosition(secondPosition));
		assertEquals("All but two position on the board should be available", this.board.getSize()*this.board.getSize()-2,board.getAvailablePositions().length);
	}
	
	@Test
	public void cannotPlaceSecondPieceOnPreviousPiece(){
		GamePiece secondGamePiece = new GamePiece();
		this.board.setPieceAtPosition(this.gamePiece, position);
		this.board.setPieceAtPosition(secondGamePiece, position);
		assertEquals("Should have been able to place piece1 on board", this.gamePiece, board.getPieceAtPosition(position));
		assertEquals("All but one position on the board should be available", this.board.getSize()*this.board.getSize()-1,board.getAvailablePositions().length);		
	}

	@Test
	public void canCheckIfPositionIsOpen(){
		assertTrue("Position should be open", this.board.isPositionAvailable(position));		
	}
	
	@Test
	public void occupiedPositionIsNotOpen(){
		this.board.setPieceAtPosition(this.gamePiece, position);
		assertFalse("Occupied position should not be open", this.board.isPositionAvailable(position));
	}
	
	@Test
	public void occupiedPositionIsRemovedFromAvailablePositions(){
		this.board.setPieceAtPosition(this.gamePiece, position);
		Position[] availablePositions = this.board.getAvailablePositions();
		assertFalse("Occupied position should not be in the available positions", positionArrayContainsElement(availablePositions, position));
	}
}
