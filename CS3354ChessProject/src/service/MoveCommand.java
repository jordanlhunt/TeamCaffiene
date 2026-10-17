package service;

import model.Position;

/**
 * Represents a parsed move command
 */
public class MoveCommand {
    private final Position source;
    private final Position destination;

    // ---------------
    // | Constructor |
    // ---------------

    /**
     * Creates a move command
     * 
     * @param source      the source position
     * @param destination the destination position
     */
    public MoveCommand(Position source, Position destination) {
        this.source = source;
        this.destination = destination;
    }

    // -----------
    // | Getters |
    // -----------

    /**
     * Returns the source position.
     *
     * @return the source position
     */
    public Position getSourcePosition() {
        return this.source;
    }

    /**
     * Returns the destination position.
     *
     * @return the destination position
     */
    public Position getDestinaPosition() {
        return this.destination;
    }
}
