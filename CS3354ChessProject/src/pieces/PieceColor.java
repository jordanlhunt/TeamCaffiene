package pieces;

/**
 * Represents the color a chess piece
 */
public enum PieceColor {
    WHITE,
    BLACK;

    public PieceColor oppositeColor() {
        if (this == BLACK) {
            return WHITE;
        } else {
            return BLACK;
        }
    }
}
