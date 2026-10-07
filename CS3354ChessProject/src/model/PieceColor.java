package model;

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
