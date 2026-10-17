package model;

import pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    // ------------
    // | Constants |
    // ------------
    private static final int MAX_ROWS = 8;
    private static final int MAX_COLUMNS = 8;
    // Starting Rows
    private static final int ROW_BLACK_BACK = 0;
    private static final int ROW_BLACK_PAWN = 1;
    private static final int ROW_WHITE_PAWN = 6;
    private static final int ROW_WHITE_BACK = 7;
    // Starting Columns
    private static final int COLUMN_A = 0;
    private static final int COLUMN_B = 1;
    private static final int COLUMN_C = 2;
    private static final int COLUMN_D = 3;
    private static final int COLUMN_E = 4;
    private static final int COLUMN_F = 5;
    private static final int COLUMN_G = 6;
    private static final int COLUMN_H = 7;
    // ---------------------
    // | Instance Variables |
    // ---------------------
    private final GamePiece gameGrid[][];
    private final List<GamePiece> capturedGamePieces;

    // ---------------
    // | Constructor |
    // ---------------
    public Board() {
        this.gameGrid = new GamePiece[MAX_ROWS][MAX_COLUMNS];
        this.capturedGamePieces = new ArrayList<>();
        initialize();
    }

    // -----------------
    // | Public Methods |
    // -----------------
    public void initialize() {
        clearBoard();
        capturedGamePieces.clear();
        placeGamePieces(PieceColor.BLACK);
        placeGamePieces(PieceColor.WHITE);
    }

    /**
     * Places all the pieces on the game of a color
     *
     * @param pieceColor the color of the gamePiece
     */

    public void placeGamePieces(PieceColor pieceColor) {
        int backRow;
        int pawnRow;
        if (pieceColor == PieceColor.BLACK) {
            backRow = ROW_BLACK_BACK;
            pawnRow = ROW_BLACK_PAWN;
        } else {
            backRow = ROW_WHITE_BACK;
            pawnRow = ROW_WHITE_PAWN;
        }
        // Place the pawns
        for (int column = 0; column < MAX_COLUMNS; column++) {
            placeGamePiece(new Pawn(pieceColor, new Position(pawnRow, column)));
        }
        placeGamePiece(new Rook(pieceColor, new Position(backRow, COLUMN_A)));
        placeGamePiece(new Knight(pieceColor, new Position(backRow, COLUMN_B)));
        placeGamePiece(new Bishop(pieceColor, new Position(backRow, COLUMN_C)));
        placeGamePiece(new Queen(pieceColor, new Position(backRow, COLUMN_D)));
        placeGamePiece(new King(pieceColor, new Position(backRow, COLUMN_E)));
        placeGamePiece(new Bishop(pieceColor, new Position(backRow, COLUMN_F)));
        placeGamePiece(new Knight(pieceColor, new Position(backRow, COLUMN_G)));
        placeGamePiece(new Rook(pieceColor, new Position(backRow, COLUMN_H)));
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
     * Checks whether a position is outside the gameboard.
     *
     * @param position on the gameboard (row,column)
     * @return true when the position is outside the bounds of the gameboard
     */
    public boolean isOutOfBounds(Position position) {
        return position.isOutOfBounds();
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
        int rowDifference = target.getRow() - source.getRow();
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
        int column = source.getColumn() + columnOffset;
        while (row != target.getRow() || column != target.getColumn()) {
            if (gameGrid[row][column] != null) {
                return false;
            }
            row += rowOffset;
            column += columnOffset;
        }
        return true;
    }

    /**
     * Moves a piece from one position to another.
     * This method assumes the move has already been validated.
     *
     * @param source      the source position
     * @param destination the destination position
     * @return the captured piece, or null when no piece was captured
     */
    public GamePiece moveGamePiece(Position source, Position destination) {
        GamePiece movingPiece = getPiece(source);
        GamePiece capturedPiece = getPiece(destination);

        if (capturedPiece != null) {
            capturedGamePieces.add(capturedPiece);
        }
        setPieceAtPosition(source, null);
        setPieceAtPosition(destination, movingPiece);

        return capturedPiece;
    }

    // ------------------
    // | Private Methods |
    // ------------------

    /**
     * Resets the board to null values at all positions
     */
    private void clearBoard() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                this.gameGrid[row][column] = null;
            }
        }
    }

    /**
     * Places a particular game piece on the board
     *
     * @param gamePiece the game piece to place
     */
    private void placeGamePiece(GamePiece gamePiece) {
        Position position = gamePiece.getPosition();
        this.gameGrid[position.getRow()][position.getColumn()] = gamePiece;
    }

    // ---------------------
    // | Getters & Setters |
    // ---------------------

    /**
     * Returns the piece at the position
     *
     * @param position on the gameboard (row,column)
     * @return the piece at a given position OR null if the square is empty
     */
    public GamePiece getPiece(Position position) {
        if (isOutOfBounds(position)) {
            throw new IllegalArgumentException(
                    "Position is outside the board: " +
                            position.convertPositionToAlgebraic());
        }
        return gameGrid[position.getRow()][position.getColumn()];
    }

    /**
     * Places a piece at a given position
     *
     * @param position  on the gameboard (row,column)
     * @param gamePiece the gamePiece to set at position
     */
    public void setPieceAtPosition(Position position, GamePiece gamePiece) {
        if (isOutOfBounds(position)) {
            throw new IllegalArgumentException(
                    "Position is outside the board: " +
                            position.convertPositionToAlgebraic());
        } else {
            gameGrid[position.getRow()][position.getColumn()] = gamePiece;
            if (gamePiece != null) {
                gamePiece.setPosition(position);
            }
        }
    }
}
