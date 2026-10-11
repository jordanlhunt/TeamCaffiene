package pieces;

import model.Position;

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

}
