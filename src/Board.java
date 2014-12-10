
public interface Board {

	int getSize();
	void setPieceAtPosition(GamePiece gamePiece, Position position);
	GamePiece getPieceAtPosition(Position position);
	Position[] getAvailablePositions();
	boolean isPositionAvailable(Position position);

}
