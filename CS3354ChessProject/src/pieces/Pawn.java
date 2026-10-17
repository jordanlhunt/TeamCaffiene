package pieces;

import model.Board;
import model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a pawn
 */
public class Pawn extends GamePiece {

    // -------------
    // | Constants |
    // -------------
    final int[] DIAGONAL_CAPTURE_OFFSETS = { -1, 1 };

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
        List<Position> moves = new ArrayList<>();
        int direction = 1;
        if (getPieceColor() == PieceColor.WHITE) {
            direction = -1;
        }
        int startRow = 1;
        if (getPieceColor() == PieceColor.WHITE) {
            startRow = 6;
        }
        // Regular movement
        Position oneStep = new Position(
                getPosition().getRow() + direction,
                getPosition().getColumn());
        // check if the space ahead is bounds and also free
        if (board.isInBoardBounds(oneStep) && board.getPiece(oneStep) == null) {
            moves.add(oneStep);
            // If currently start row let the pawn move two spaces
            if (getPosition().getRow() == startRow) {
                Position twoStep = new Position(
                        getPosition().getRow() + 2 * direction,
                        getPosition().getColumn());
                if (board.isInBoardBounds(twoStep) &&
                        board.getPiece(twoStep) == null) {
                    moves.add(twoStep);
                }
            }
        }
        // Capture movement
        for (int offset : DIAGONAL_CAPTURE_OFFSETS) {
            Position possibleCapture = new Position(
                    getPosition().getRow() + direction,
                    getPosition().getColumn() + offset);
            if (board.isInBoardBounds(possibleCapture)) {
                GamePiece targetGamePiece = board.getPiece(possibleCapture);
                if (targetGamePiece != null &&
                        targetGamePiece.getPieceColor() != this.getPieceColor()) {
                    moves.add(possibleCapture);
                }
            }
        }
        return moves;
    }

    /**
     * Returns the symbol for the pawn.
     *
     * @return the king symbol
     */
    @Override
    public String getSymbol() {
        return selectSymbol("♟", "♙");
    }
}
