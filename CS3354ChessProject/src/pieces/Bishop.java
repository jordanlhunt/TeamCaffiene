package pieces;

import java.util.ArrayList;
import java.util.List;
import model.Board;
import model.Position;

public class Bishop extends GamePiece {

    private static final int[][] BISHOP_DIRECTIONS = {
        { -1, -1 },
        { -1, 1 },
        { 1, -1 },
        { 1, 1 },
    };

    /**
     * Creates a Bishop
     *
     * @param pieceColor
     * @param startPosition
     */
    public Bishop(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    @Override
    /**
     * Returns a list of all the possible moves
     *
     * @param board the current board
     * @return a list of all possible moves
     */
    public List<Position> possibleMoves(Board board) {
        List<Position> possibleMoves = new ArrayList<>();
        for (int direction[] : BISHOP_DIRECTIONS) {
            addSlidingMoves(board, possibleMoves, direction[0], direction[1]);
        }
        return possibleMoves;
    }

    @Override
    public String getSymbol() {
        return selectSymbol("♝", "♗");
    }
}
