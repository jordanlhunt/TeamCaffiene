package service;

import model.Board;
import model.MoveResult;
import model.Player;
import model.Position;
import pieces.GamePiece;
import pieces.PieceColor;
import java.util.List;

/**
 * Coordinates chess game rules, board updates, and turns.
 */
public class Game {
    // --------------------
    // | Member Variables |
    // --------------------
    private final Board board;
    private final Player blackPlayer;
    private final Player whitePlayer;
    private Player currentPlayer;
    private boolean isGameOver;
    // ---------------
    // | Constructor |
    // ---------------
    {
        isGameOver = true;
    }

    // ------------------
    // | Public Methods |
    // ------------------
    /**
     * Creates a new game
     */
    public Game() {
        this.board = new Board();
        this.blackPlayer = new Player("Black", PieceColor.BLACK);
        this.whitePlayer = new Player("White", PieceColor.WHITE);
        currentPlayer = whitePlayer;
        isGameOver = false;
    }

    /**
     * Start or reset the game
     */
    public void startGame() {
        board.initialize();
        currentPlayer = whitePlayer;
        isGameOver = false;
    }

    /**
     * Ends the game
     */
    public void endGame() {
        this.isGameOver = true;
    }

    /**
     * Attempts to move a piece
     *
     * @param source      the source position
     * @param destination the destination position
     * @return the movement result
     */
    public MoveResult tryMove(Position source, Position destination) {
        MoveResult isMoveResultValid = isTryMoveLegal(source, destination);
        if (!isMoveResultValid.getIsSuccessful()) {
            return isMoveResultValid;
        }
        GamePiece movingPiece = board.getPiece(source);
        List<Position> possibleMoves = movingPiece.possibleMoves(board);
        GamePiece capturedGamePiece = board.moveGamePiece(source, destination);
        String movementMessage = currentPlayer.getPlayerName() + " moved " + movingPiece.getClass().getSimpleName()
                + " from " + source.convertPositionToAlgebraic() + " to " + destination.convertPositionToAlgebraic();
        if (capturedGamePiece != null) {
            movementMessage += currentPlayer.getPlayerName() + " captured "
                    + capturedGamePiece.getClass().getSimpleName() + ".";
        }
        changeTurn();
        return MoveResult.success(movementMessage);
    }

    // ---------------------
    // | Getters & Setters |
    // ---------------------
    /**
     * Returns the board.
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Returns the current player.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the black player.
     *
     * @return the black player
     */
    public Player getBlackPlayer() {
        return blackPlayer;
    }

    /**
     * Returns the white player.
     *
     * @return the white player
     */
    public Player getWhitePlayer() {
        return whitePlayer;
    }

    /**
     * Checks whether the game has ended.
     *
     * @return true when the game has ended
     */
    public Boolean isGameOver() {
        return this.isGameOver;
    }

    // -------------------
    // | Private Methods |
    // -------------------
    /**
     * A helper function to switch the current player after a successful move
     */
    private void changeTurn() {
        if (currentPlayer == blackPlayer) {
            currentPlayer = whitePlayer;
        } else {
            currentPlayer = blackPlayer;
        }
    }

    /**
     * A helper function to check if move is legal.
     *
     * @param source      the source position
     * @param destination the destination position
     * @return null if move tryMove() is legal
     */
    private MoveResult isTryMoveLegal(Position source, Position destination) {
        if (isGameOver) {
            return MoveResult.failure("[INVALID MOVE] - The game has ended.");
        }
        if (source == null || destination == null) {
            return MoveResult.failure("[INVALID MOVE] - Source and destination are required.");
        }
        if (board.isOutOfBounds(source)) {
            return MoveResult.failure("[INVALID MOVE] - Source square is outside the board.");
        }
        if (board.isOutOfBounds(destination)) {
            return MoveResult.failure("[INVALID MOVE] - Destination square is outside the board.");
        }
        if (source.equals(destination)) {
            return MoveResult.failure("[INVALID MOVE] - Source and destination must be different.");
        }
        GamePiece piece = board.getPiece(source);
        if (piece == null) {
            return MoveResult
                    .failure("[INVALID MOVE] - There is no piece on " + source.convertPositionToAlgebraic() + ".");
        }
        if (piece.getPieceColor() != currentPlayer.getPieceColor()) {
            return MoveResult
                    .failure("[INVALID MOVE] - That piece does not belong to " + currentPlayer.getPlayerName() + ".");
        }
        GamePiece target = board.getPiece(destination);
        if (target != null && target.getPieceColor() == piece.getPieceColor()) {
            return MoveResult.failure("[INVALID MOVE] - The destination contains a friendly piece.");
        }
        List<Position> possibleMoves = piece.possibleMoves(board);
        if (!possibleMoves.contains(destination)) {
            return MoveResult.failure(
                    "[INVALID MOVE] - The " + piece.getClass().getSimpleName()
                            + " cannot move from " + source.convertPositionToAlgebraic()
                            + " to " + destination.convertPositionToAlgebraic() + ".");
        }
        return MoveResult.success("[VALID MOVE] - Move is valid");
    }
}
