package pieces;

import model.Board;
import model.Position;

import java.util.List;

public class King extends GamePiece {
    public King(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    /**
     * @param board the current board
     * @return
     */
    @Override
    public List<Position> possibleMoves(Board board) {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public String getSymbol() {
        return "";
    }
}
