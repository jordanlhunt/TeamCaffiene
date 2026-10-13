package model;

import java.util.ArrayList;
import java.util.List;

import pieces.GamePiece;
import pieces.PieceColor;

public class Board {
    private static final int MAX_ROWS = 8;
    private static final int MAX_COLUMNS = 8;

    // Instance Variables
    private GamePiece gameBoard[][];
    private final List<GamePiece> capturedGamePieces;

    public Board() {
        this.gameBoard = new GamePiece[MAX_ROWS][MAX_COLUMNS];
        this.capturedGamePieces = new ArrayList<>();
        Initialize();
    }

    public Initialize(){
nullBoard();
capturedGamePieces.clear();
placePieces(PieceColor.BLACK);
placePieces(PieceColor.WHITE);
    }

    private  nullBoard(){
        for(int row= 0 ; row < MAX_ROWS; row++){for(int column =0; column < MAX_COLUMNS; column++){this.gameBoard[row][column];}}
    }
}
