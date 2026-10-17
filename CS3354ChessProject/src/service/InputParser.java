package service;

import model.Position;

/**
 * Parses console input for chess commands
 */
public class InputParser {

    private final static String[] QUIT_COMMANDS = {
            "quit", "exit", "shutdown", "end"
    };

    /**
     * Checks whether the input is a quit command.
     *
     * @param input the raw input
     * @return true when the input is a quit command
     */
    public boolean isQuit(String input) {
        if (input == null) {
            return false;
        }
        String trimmedInput = input.trim();
        for (String command : QUIT_COMMANDS) {
            if (trimmedInput.equals(command)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Parses a move command
     *
     * @param input raw input from the console
     * @return the parsed move command
     */
    public MoveCommand parseMove(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[INVALID COMMAND] - Input cannot be null.");
        }
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("[INVALID COMMAND] - Input cannot be empty.");
        }

        String[] parts = trimmed.split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("[INVALID COMMAND] - Enter exactly two squares, such as E2 E3.");
        }
        Position source = Position.convertAlgebraicToPosition(parts[0]);
        Position destination = Position.convertAlgebraicToPosition(parts[1]);
        return new MoveCommand(source, destination);
    }
}
