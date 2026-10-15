package pieces;

import model.Board;
import model.Position;

import java.util.List;

/**
 * Represents a pawn
 */
public class Pawn extends GamePiece {
    // --------------
    // | Constructor |
    // --------------

    /**
     * Creates a pawn
     *
     * @param pieceColor       the piece's color
     * @param startingPosition the starting position
     */
    public Pawn(PieceColor pieceColor, Position startingPosition) {
        super(pieceColor, startingPosition);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        return List.of();
    }

    @Override
    public String getSymbol() {
        return "";
    }
}
