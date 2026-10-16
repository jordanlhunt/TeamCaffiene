package model;

public class MoveResult {

    // --------------------
    // | Member Variables |
    // --------------------
    private final boolean isSuccessful;
    private final String message;

    // ---------------
    // | Constructor |
    // ---------------

    public MoveResult(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    // ------------------
    // | Public Methods |
    // ------------------

    /**
     * Creates a successful move result
     *
     * @param message the result message
     * @return the move result
     */
    public static MoveResult success(String message) {
        return new MoveResult(true, message);
    }

    /**
     * Creates a failed move result
     *
     * @param message the result message
     * @return the move result
     */
    public static MoveResult failure(String message) {
        return new MoveResult(false, message);
    }

    /**
     * Checks whether the move succeeded
     *
     * @return true when the move succeeded
     */
    public boolean getIsSuccessful() {
        return this.isSuccessful;
    }

    // -----------
    // | Getters |
    // -----------

    /**
     * Return the result message
     *
     * @return the result message
     */
    public String getMessage() {
        return this.message;
    }
}
