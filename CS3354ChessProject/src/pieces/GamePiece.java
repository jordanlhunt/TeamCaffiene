package pieces;

import model.Position;

import java.util.List;

/**
 * Represents a chess piece
 * This class stores the color and position of all the chess pieces
 * There will be no "gamepieces" instances so the class will be abstract
 */
public abstract class GamePiece {
    private final PieceColor pieceColor;
    private final Position position;

    // ---------------
    // | Constructor |
    // ---------------

    /**
     * Creates a chess piece
     *
     * @param pieceColor    the piece color
     * @param startPosition the starting position
     */
    protected GamePiece(PieceColor pieceColor, Position startPosition) {
        this.pieceColor = pieceColor;
        this.position = startPosition;
    }

    // -----------
    // | Getters |
    // -----------

    /**
     * Returns the piece color
     *
     * @return the piece color
     */
    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    /**
     * Returns the current position
     *
     * @return the current position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Return the possible destination squares for this gamepiece
     *
     * @param board the current board
     * @return a list of possible destination squares
     */
    public abstract List<Position> possibleMoves(Board board);
}
