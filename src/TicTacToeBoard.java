import java.util.ArrayList;
import java.util.List;

import Exceptions.InvalidBoardException;


public class TicTacToeBoard implements Board {
	private int size = 0;
	private GamePiece[][] grid = null;

	public TicTacToeBoard(int size) throws InvalidBoardException{
		if (size<2) {
			throw(new InvalidBoardException("Invalid board size!"));
		}
		this.size = size;
		grid = new GamePiece[this.size][this.size];
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setPieceAtPosition(GamePiece piece, Position position) {
		if(grid[position.x][position.y]==null) {
			grid[position.x][position.y] = piece;
		}
	}

	@Override
	public GamePiece getPieceAtPosition(Position position) {
		return grid[position.x][position.y];
	}

	@Override
	public Position[] getAvailablePositions() {
		List<Position> positions = new ArrayList<Position>();
		for(int i=0; i<this.size; i++) {
			for(int j=0; j<this.size; j++) {
				if(grid[i][j]==null) {
					positions.add(new Position(i, j));
				}
			}
		}
		return positions.toArray(new Position[0]);
	}

	@Override
	public boolean isPositionAvailable(Position position) {
		return grid[position.x][position.y]==null;
	}
}
