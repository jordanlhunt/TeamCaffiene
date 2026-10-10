package model;

public class MoveResult {
    private final boolean isSuccessful;
    private final String message;

    public MoveResult(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }
}
