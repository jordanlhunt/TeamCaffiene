package pieces;

import model.Board;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends GamePiece {

    // -------------
    // | Constants |
    // -------------
    private static final int[][] KING_DIRECTIONS = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
    };

    // --------------
    // | Constructor |
    // --------------

    /**
     * Creates a king.
     *
     * @param pieceColor    the piece color
     * @param startPosition the starting position
     */
    public King(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    // ------------------
    // | Public Methods |
    // ------------------

    @Override
    /**
     * Returns a list of all the possible moves
     *
     * @param board the current board
     * @return a list of all possible moves
     */
    public List<Position> possibleMoves(Board board) {
        List<Position> possibleMoves = new ArrayList<>();
        for (int direction[] : KING_DIRECTIONS) {
            Position possibleMove = new Position(
                    getPosition().getRow() + direction[0],
                    getPosition().getColumn() + direction[1]
            );
            if (board.isInBoardBounds(possibleMove)) {
                GamePiece possibleCapture = board.getPiece(possibleMove);
                if (
                        possibleCapture == null ||
                                possibleCapture.getPieceColor() != this.getPieceColor()
                ) {
                    possibleMoves.add(possibleMove);
                }
            }
        }
        return possibleMoves;
    }

    /**
     * Returns the symbol for the king.
     *
     * @return the king symbol
     */
    @Override
    public String getSymbol() {
        return selectSymbol("♚", "♔");
    }
}
