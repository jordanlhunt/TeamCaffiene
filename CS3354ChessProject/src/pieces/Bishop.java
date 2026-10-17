package pieces;

import model.Board;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends GamePiece {
    // -------------
    // | Constants |
    // -------------
    private static final int[][] BISHOP_DIRECTIONS = {
            { -1, -1 },
            { -1, 1 },
            { 1, -1 },
            { 1, 1 },
    };

    // --------------
    // | Constructor |
    // --------------

    /**
     * Creates a Bishop
     *
     * @param pieceColor
     * @param startPosition
     */
    public Bishop(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    /**
     * Returns a list of all the possible moves
     *
     * @param board the current board
     * @return a list of all possible moves
     */
    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> possibleMoves = new ArrayList<>();
        for (int direction[] : BISHOP_DIRECTIONS) {
            addSlidingMoves(board, possibleMoves, direction[0], direction[1]);
        }
        return possibleMoves;
    }

    /**
     * Returns the symbol for the bishop.
     *
     * @return the king symbol
     */
    @Override
    public String getSymbol() {
        return selectSymbol("♝", "♗");
    }
}
