package pieces;

import model.Board;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends GamePiece {

    // -------------
    // | Constants |
    // -------------
    private static final int[][] QUEEN_DIRECTIONS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1},
    };
    // --------------
    // | Constructor |
    // --------------

    /**
     * Creates a queen.
     *
     * @param color         the piece color
     * @param startPosition the starting position
     */
    public Queen(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    // ------------------
    // | Public Methods |
    // ------------------

    /**
     * Returns a list of all the possible moves
     *
     * @param board the current board
     * @return a list of all possible moves
     */
    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> possibleMoves = new ArrayList<>();
        for (int direction[] : QUEEN_DIRECTIONS) {
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
        return selectSymbol("♛", "♕");
    }
}
