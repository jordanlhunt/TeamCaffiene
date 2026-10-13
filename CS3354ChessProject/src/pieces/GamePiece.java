package pieces;

import model.Board;
import model.Position;
import java.util.List;

/**
 * Represents a chess piece
 * This class stores the color and position of all the chess pieces
 * There will be no "gamepieces" instances so the class will be abstract
 */
public abstract class GamePiece {
    private final PieceColor pieceColor;
    private final Position position;

    // ---------------
    // | Constructor |
    // ---------------
    /**
     * Creates a chess piece
     *
     * @param pieceColor    the piece color
     * @param startPosition the starting position
     */
    protected GamePiece(PieceColor pieceColor, Position startPosition) {
        this.pieceColor = pieceColor;
        this.position = startPosition;
    }

    // -----------
    // | Getters |
    // -----------
    /**
     * Returns the piece color
     *
     * @return the piece color
     */
    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    /**
     * Returns the current position
     *
     * @return the current position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Return the possible destination squares for this gamepiece
     *
     * @param board the current board
     * @return a list of possible destination squares
     */
    public abstract List<Position> possibleMoves(Board board);

    /**
     * Returns the display symbol for the piece
     * 
     * @return the display symbol
     */
    public abstract String getSymbol();

    /**
     * Selects the symbol based on the piece color
     * 
     * @param blackSymbol the black symbol
     * @param whiteSymbol the white symbol
     * @return the selected symbol
     */
    protected String selectSymbol(String blackSymbol, String whiteSymbol) {
        if (this.pieceColor == PieceColor.BLACK) {
            return blackSymbol;
        } else {
            return whiteSymbol;
        }
    }

    /**
     * Add sliding moves in one direction. Queens, Bishops, and Rooks
     * 
     * @param board         the current board
     * @param possibleMoves the list of possibleMove
     * @param rowOffset     the row offset
     * @param columnOffset  the column offset
     */
    protected void addSlidingMoves(Board board, List<Position> possibleMoves, int rowOffset, int columnOffset) {
        int row = this.position.getRow() + rowOffset;
        int column = this.position.getColumn() + columnOffset;
        while (row >= 0 && row < Position.MAX_ROWS && column >= 0 && column < Position.MAX_COLUMNS) {
            Position possibleMove = new Position(row, column);
            GamePiece target = board.getPiece(possibleMove);
            if (target == null) {
                possibleMoves.add(possibleMove);
            } else {
                if (target.getPieceColor() != this.pieceColor) {
                    possibleMoves.add(possibleMove);
                }
                break;
            }
            row += rowOffset;
            column += columnOffset;
        }
    }
}
