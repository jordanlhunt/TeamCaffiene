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
    public void Initialize() {
        nullBoard();
        capturedGamePieces.clear();
        placeGamePieces(PieceColor.BLACK);
        placeGamePieces(PieceColor.WHITE);
    }

    /**
     * Places all of the pieces on the game of a color
     * 
     * @param pieceColor
     */

    public void placeGamePieces(PieceColor pieceColor) {
        if (pieceColor == PieceColor.BLACK) {
            placeGamePiece(null, pieceColor);
        } else {

        }
    }

    /**
     * Checks whether a position is inside the gameboard.
     * 
     * @param position on the gameboard (row,column)
     * @return true when the position is inside the bounds of the gameboard
     */
    public boolean isInBoardBounds(Position position) {
        return position.isInBoardBounds();
    }

    /**
     * Checks whether the path between two positions is clear
     * .
     * 
     * @param source the source position
     * @param target the target position
     * @return true if the path is clear
     */
    public boolean isPathClear(Position source, Position target) {
        if (source.equals(target)) {
            return true;
        }
        int rowDifference = target.getRow() - source.getColumn();
        int columnDifference = target.getColumn() - source.getColumn();
        int rowOffset = 0;
        int columnOffset = 0;

        if (rowDifference == 0) {
            if (columnDifference > 0) {
                columnOffset = 1;
            } else if (columnDifference < 0) {
                columnOffset = -1;
            } else {
                return false;
            }
        } else if (columnDifference == 0) {
            if (rowDifference > 0) {
                rowOffset = 1;
            } else {
                rowOffset = -1;
            }
        } else if (Math.abs(rowDifference) == Math.abs(columnDifference)) {
            if (rowDifference > 0) {
                rowOffset = 1;
            } else {
                rowOffset = -1;
            }
            if (columnDifference > 0) {
                columnOffset = 1;
            } else {
                columnOffset = -1;
            }
        } else {
            return false;
        }

        int row = source.getRow() + rowOffset;
        int column = source.getRow() + columnOffset;
        while (row != target.getRow() || column != target.getColumn()) {
            if (gameBoard[row][column] != null) {
                return false;
            }
            row += rowOffset;
            column += columnOffset;
        }
        return true;
    }

    // ------------------
    // | Private Methods |
    // ------------------
    private void nullBoard() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                this.gameBoard[row][column] = null;
            }
        }
    }

    private void placeGamePiece(GamePiece gamePiece, PieceColor pieceColor) {
        Position position = gamePiece.getPosition();
        this.gameBoard[position.getRow()][position.getColumn()] = gamePiece;
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
    public GamePiece getPiece(Position position) {
        if (!isInBoardBounds(position)) {
            throw new IllegalArgumentException(
                    "Position is outside the board: " + position.convertPositionToAlgebraic());
        }
        return gameBoard[position.getRow()][position.getColumn()];
    }

    /**
     * Places a piece at a given position
     *
     * @param position  on the gameboard (row,column)
     * @param gamePiece the gamePiece to set at position
     */
    public void setPieceAtPosition(Position position, GamePiece gamePiece) {
        if (!isInBoardBounds(position)) {
            throw new IllegalArgumentException(
                    "Position is outside the board: " + position.convertPositionToAlgebraic());
        } else {
            gameBoard[position.getRow()][position.getColumn()] = gamePiece;
            if (gamePiece != null) {
                gamePiece.setPosition(position);
            }
        }

    }
}