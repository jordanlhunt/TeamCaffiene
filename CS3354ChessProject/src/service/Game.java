package service;

import model.Board;
import model.MoveResult;
import model.Player;
import model.Position;
import pieces.PieceColor;

/**
 * Coordinates chess game rules, board updates, and turns.
 */
public class Game {
    private final Board board;
    private final Player blackPlayer;
    private final Player whitePlayer;
    private Player currentPlayer;
    private boolean isGameOver;

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
     * Attempts to move a piece
     * @param source the source position
     * @param destination the destination position
     * @return the movement result
     */
    public MoveResult tryMove(Position source, Position destination)
}
