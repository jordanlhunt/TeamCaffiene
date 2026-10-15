package pieces;

import model.Board;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends GamePiece {

    // -------------
    // | Constants |
    // -------------
    private static final int[][] ROOK_DIRECTIONS = {
            {-1, 0}, // Up
            {1, 0}, // Down
            {0, 1}, // Right
            {0, -1} // Left
    };

    /**
     * Creates a rook.
     *
     * @param color         the piece color
     * @param startPosition the starting position
     */
    public Rook(PieceColor color, Position startPosition) {
        super(color, startPosition);
    }

    // ------------------
    // | Public Methods |
    // ------------------
    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        for (int[] direction : ROOK_DIRECTIONS) {
            addSlidingMoves(board, moves, direction[0], direction[1]);
        }
        return moves;
    }

    @Override
    public String getSymbol() {
        return selectSymbol("♜", "♖");
    }
}
