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
    public static final char RANK_START = '1';
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
     * Converts
     * 
     * @return
     */

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