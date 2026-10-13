package model;

import pieces.GamePiece;

public class Board {
    private static final int MAX_ROWS = 8;
    private static final int MAX_COLUMNS = 8;
    // Instance Variables
    GamePiece gameBoard[][];

    public Board() {
        this.gameBoard = new GamePiece[MAX_ROWS][MAX_COLUMNS];
    }

    public Initialize(){

    }
}
