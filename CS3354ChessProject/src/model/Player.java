package model;

public class Player {

    // ----------------------
    // | Instance Variables |
    // ----------------------
    private final String playerName;
    private final PieceColor pieceColor;

    // ---------------
    // | Constructor |
    // ---------------

    /**
     * Represents a chess Player
     */
    public Player(string playerName, PieceColor pieceColor) {
        this.playerName = playerName;
        this.pieceColor = pieceColor;
    }

    // -----------
    // | Getters |
    // -----------

    public String getPlayerName() {
        return this.playerName;
    }

    public String getPieceColor() {
        return this.pieceColor;
    }

}
