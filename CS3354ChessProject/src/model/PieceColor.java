package model;

/**
 * Represents the color a chess piece
 */
public enum PieceColor {
    WHITE,
    BLACK;

    public PieceColor oppositeColor() {
        if (this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
