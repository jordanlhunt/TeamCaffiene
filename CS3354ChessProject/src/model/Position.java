package model;

import java.util.Objects;

/**
 * Represents a board coordinate. Row 0 is rank 8, column 0 is file A. Position
 * is 'final' to be read-only
 */
public final class Position {
    // -------------
    // | Constants |
    // -------------
    private static final int MAX_ROWS = 8;
    private static final int MAX_COLUMNS = 8;
    private static final char FILE_START = 'A';
    private static final char FILE_END = 'H';
    private static final char RANK_START = '1';
    private static final char RANK_END = '8';
    private static final int COORDINATE_LENGTH = 2;

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
        if (!isInBoardBounds(row, column)) {
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
     * Returns whether the row and column in the bounds of the board
     *
     * @param row    the row value
     * @param column the column value
     * @return true if the row and column coordinate is valid
     */
    public static boolean isInBoardBounds(int row, int column) {
        return (row >= 0 && row < MAX_ROWS && column >= 0 && column < MAX_COLUMNS);
    }

    /**
     * Converts algebraic notation to a position
     *
     * @param algebraicString the algebraic coordinate in the form "A-H"+"0-8"
     * @return the converted position
     */
    public static Position convertAlgebraicToPosition(String algebraicString) {
        if (algebraicString == null) {
            throw new IllegalArgumentException("[ERROR] - Algebraic coordinate cannot be null.");
        }
        String trimmedString = algebraicString.trim().toUpperCase();
        if (trimmedString.length() != COORDINATE_LENGTH) {
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
        int row = MAX_ROWS - (rank - RANK_START + 1);
        int column = file - FILE_START;
        return (new Position(row, column));
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
        char file = (char) (FILE_START + column);
        char rank = (char) (RANK_START + (MAX_ROWS - row) - 1);
        return String.valueOf(file) + rank;
    }
}