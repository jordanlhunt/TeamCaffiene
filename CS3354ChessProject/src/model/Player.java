package model;

import pieces.PieceColor;

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
    public Player(String playerName, PieceColor pieceColor) {
        this.playerName = playerName;
        this.pieceColor = pieceColor;
    }

    // -----------
    // | Getters |
    // -----------

    /**
     * Returns the player Name
     *
     * @return the player name
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * Returns the piece color
     *
     * @return the piece color
     */
    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    // -------------
    // | Overrides |
    // -------------
    @Override
    public String toString() {
        return (this.playerName + " | " + this.pieceColor);
    }
}
