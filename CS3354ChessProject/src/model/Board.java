package model;

import java.util.ArrayList;
import java.util.List;
import pieces.GamePiece;
import pieces.PieceColor;

public class Board {

    // ------------
    // | Constants |
    // ------------
    private static final int MAX_ROWS = 8;
    private static final int MAX_COLUMNS = 8;

    // ---------------------
    // | Instance Variables |
    // ---------------------
    private GamePiece gameBoard[][];
    private final List<GamePiece> capturedGamePieces;

    // ---------------
    // | Constructor |
    // ---------------
    public Board() {
        this.gameBoard = new GamePiece[MAX_ROWS][MAX_COLUMNS];
        this.capturedGamePieces = new ArrayList<>();
        Initialize();
    }

    // -----------------
    // | Public Methods |
    // -----------------
    public Initialize() {
        nullBoard();
        capturedGamePieces.clear();
        placeGamePieces(PieceColor.BLACK);
        placeGamePieces(PieceColor.WHITE);
    }
    /** Checks whether a position is inside the gameboard.
     * @param position on the gameboard (row,column)
     * @return true when the position is inside the bounds of the gameboard
     */
    public boolean isInBoardBounds(Position position){
        return position.isInBoardBounds();
    }

    public boolean isPathViable(Position source, Position target){
        if(source.equals(target)){
            return true;
        }
    }

    // ------------------
    // | Private Methods |
    // ------------------
    private nullBoard() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                this.gameBoard[row][column];
            }
        }
    }

    private void placeGamePiece(GamePiece gamePiece, PieceColor pieceColor) {
        Position position = piece.getPosition();
        squares[position.getRow()][position.getColumn()] = gamePiece;
    }

    // ----------
    // | Getters |
    // ----------

    /**
     * Returns the piece at the position
     *
     * @param position on the gameboard (row,column)
     * @return the piece at a given position OR null if the square is empty
     */
    public Piece getPiece(Position position) {
        if (!isInBoardBounds(position)) {
            throw new IllegalArgumentException(
                "Position is outside the board: " + position.toAlgebraic()
            );
            return null;
        }
        return gameBoard[position.getRow()][position.getColumn()];
    }

    /**
     * Places a piece at a given position
     *
     * @param position on the gameboard (row,column)
     * @param gamePiece the gamePiece to set at position
     */
    public void setPieceAtPosition(Position position, gamePiece gamePiece){
        if (!isInBoardBounds(position)) {
            throw new IllegalArgumentException(
                "Position is outside the board: " + position.toAlgebraic()
            );
            else
            {
                gameBoard[position.getRow() ][position.getColumn()]=gamePiece;
                if(gamePiece != null){
                    gamePiece.setPosition(position);
                }
            }
    }

}
