package service;

import model.Board;
import model.MoveResult;
import model.Position;
import pieces.GamePiece;

import java.util.List;
import java.util.Scanner;

/**
 * Provides the console interface for the playing of the game
 */
public class ConsoleUI {
    // --------------------
    // | Member Variables |
    // --------------------

    private final Game game;
    private final Scanner scanner;
    private final InputParser inputParser;

    // ---------------
    // | Constructor |
    // --------------

    /**
     * Creates the console interface
     *
     * @param game the game service
     */
    public ConsoleUI(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
        this.inputParser = new InputParser();
    }
// -------------
    // | Public Methods |
    // -------------

    /**
     * Runs the console game loop
     */
    public void runGame() {
        System.out.println("Console Chess by Team Caffeine (Jordan Hunt)");
        System.out.println("How to play\n-------\nWhite moves first. Enter movement commands as [FROM] [TO], for example 'E2 E4' will move the target at E2 to the space E4\nEnter 'quit' or 'exit' to shutdown the game\n Have fun!");
        game.startGame();
        boolean isGameRunning = true;
        while (isGameRunning) {
            displayCurrentBoard(game.getBoard());
            displayCapturedPieces(game.getBoard());
            System.out.println("Turn: " + game.getCurrentPlayer().toString());
            System.out.print("Enter a move or QUIT: ");
            String input = scanner.nextLine();
            if (inputParser.isQuit(input)) {
                isGameRunning = false;
                System.out.println("Game has ended. Thank you for playing");
            } else {
                try {
                    MoveCommand moveCommand = inputParser.parseMove(input);
                    MoveResult moveResult = game.tryMove(moveCommand.getSourcePosition(), moveCommand.getDestinaPosition());
                    System.out.println(moveResult.getMessage());
                    if (!moveResult.getIsSuccessful()) {
                        System.out.println("Invalid Move or Command");
                        System.out.println("Board and current turn remain unchanged");
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println("Invalid input: " + exception.getMessage());
                    System.out.println("Board and turn remain unchanged.");
                }
            }
        }
    }
    // -------------------
    // | Private Methods |
// -------------------


    private void displayCurrentBoard(Board board) {
        System.out.println();
        System.out.println("   A  B  C  D  E  F  G  H");

        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " ");
            for (int column = 0; column < 8; column++) {
                GamePiece piece = board.getPiece(new Position(row, column));
                if (piece == null) {
                    System.out.print("## ");
                } else {
                    System.out.print(piece.getSymbol() + " ");
                }
            }
            System.out.println(" " + (8 - row));
        }

        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.println();
    }

    private void displayCapturedPieces(Board board) {
        List<GamePiece> capturedPieces = board.getCapturedGamePieces();
        if (capturedPieces.isEmpty()) {
            System.out.println("Captured pieces: none");
            return;
        }

        System.out.print("Captured pieces: ");
        for (GamePiece piece : capturedPieces) {
            System.out.print(piece.getSymbol() + " ");
        }
        System.out.println();
    }
}
