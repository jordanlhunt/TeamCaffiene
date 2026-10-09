package chess.model;

import java.util.Objects;

/**
 * Represents a board coordinate. Row 0 is rank 8, column 0 is file A. Position
 * is 'final' to be read-only
 */
public final class Position {
    // -------------
    // | Constants |
    // -------------
    public static final int MAX_ROWS = 8;
    public static final int MAX_COLUMNS = 8;
    public static final char FILE_START = 'A';
    public static final char FILE_END = 'H';
    public static final char RANK_START = '0';
    public static final char RANK_END = '8';

    // ----------------------
    // | Instance Variables |
    // ----------------------
    private final int row;
    private final int column;

    // ---------------
    // | Constructor |
    // ---------------

    /**
     * Create a position
     * 
     * @param row    the row value from 0 to 7
     * @param column the column value from 0 to 7
     * @throws IllegalArgumentException if the position is outside the bounds of the
     *                                  board
     */
    public Position(int row, int column) {
        if (!isOnBoard(row, column)) {
            throw new IllegalArgumentException("[ERROR] - Position is outside the board");
        } else {
            this.row = row;
            this.column = column;
        }
    }

    // ------------------
    // | Public Methods |
    // ------------------

    /**
     * Returns whether the row and column are on the board
     * 
     * @param row    the row value
     * @param column the column value
     * @return true if the row and column coordinate is valid
     */
    public static boolean isOnBoard(int row, int column) {
        return (row >= 0 && row < MAX_ROWS && column >= 0 && column < MAX_COLUMNS);
    }

    /**
     * Returns a new position translated (in the mathmatical sense) by the given row
     * and column deltas
     * 
     * @param rowDelta    the row change
     * @param columnDelta the column change
     * @return the translated position
     */
    public Position translatedBy(int rowDelta, int columnDelta) {
        return (new Position(this.row + rowDelta, this.column + columnDelta));
    }

    /**
     * Converts algebraic notation to a position
     * 
     * @param algebraicString the algebraic coordinate in the form "A-H"+"0-8"
     * @return the converted position
     */
    public static Position convertAlgebraicToPosition(String algebraicString) {
        if (algebraicString == NULL) {
            throw new IllegalArgumentException("[ERROR] - Algebraic coordinate cannot be null.");
        }
        String trimmedString = algebraicString.trim().toUpperCase();
        if (trimmedString.length() != 2) {
            throw new IllegalArgumentException("[ERROR] - Coordinate must contain a file letter.");
        }
        char file = trimmedString.charAt(0);
        char rank = trimmedString.charAt(1);
        if (file < FILE_START || file > FILE_END) {
            throw new IllegalArgumentException("[ERROR] - File must be 'A' through 'H' inclusive.");
        }
        if (rank < RANK_START || rank > RANK_END) {
            throw new IllegalArgumentException("[ERROR] - Rank must be 0-8 inclusive.");
        }
        int row = MAX_ROWS - (rank - RANK_START);
        int column = file - FILE_START;
        return (new Position(row, column));
    }

    // -----------
    // | Getters |
    // -----------

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    // -------------
    // | Overrides |
    // -------------

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof Position)) {
            return false;
        }
        Position otherPosition = (Position) otherObject;
        return (row == otherPosition.row && column == otherPosition.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return conventToAlgebraic();
    }
}