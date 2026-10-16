package pieces;

import java.util.ArrayList;
import java.util.List;
import model.Board;
import model.Position;

public class Knight extends GamePiece {

    // -------------
    // | Constants |
    // -------------
    private static final int[][] KNIGHT_DIRECTIONS = {
        { -2, -1 },
        { -2, 1 },
        { -1, -2 },
        { -1, 2 },
        { 1, -2 },
        { 1, 2 },
        { 2, -1 },
        { 2, 1 },
    };

    /**
     * Creates a knight.
     *
     * @param color         the piece color
     * @param startPosition the starting position
     */
    public Knight(PieceColor pieceColor, Position startPosition) {
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
        List<Position> moves = new ArrayList<>();
        for (int[] direction : KNIGHT_DIRECTIONS) {
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
                    moves.add(possibleMove);
                }
            }
        }
        return moves;
    }

      /**
     * Returns the symbol for the knight.
     * @return the king symbol
     */
    @Override
    public String getSymbol() {
        return selectSymbol("♞", "♘");
    }
}
