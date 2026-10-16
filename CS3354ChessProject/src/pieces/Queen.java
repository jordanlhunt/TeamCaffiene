package pieces;

import java.util.ArrayList;
import java.util.List;
import model.Board;
import model.Position;

public class Queen extends GamePiece {

    // -------------
    // | Constants |
    // -------------
    private static final int[][] QUEEN_DIRECTIONS = {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 },
        { -1, -1 },
        { -1, 1 },
        { 1, -1 },
        { 1, 1 },
    };

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
     * @param board the current board
     * @return
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
     * @return
     */
    @Override
    public String getSymbol() {
        return selectSymbol("♛", "♕");
    }
}
