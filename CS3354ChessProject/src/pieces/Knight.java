package pieces;

import model.Board;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends GamePiece {
    // -------------
    // | Constants |
    // -------------
    private static final int[][] KNIGHT_DIRECTIONS = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };


    public Knight(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        for (int[] direction : KNIGHT_DIRECTIONS) {
            Position possibleMove = new Position(getPosition().getRow() + direction[0], getPosition().getColumn() + direction[1]);
            if (board.isInBoardBounds(possibleMove)) {
                GamePiece possibleCapture = board.getPiece(possibleMove);
                if(possibleCapture == null || possibleCapture.getPieceColor() != this.getPieceColor()) {
                    moves.add(possibleMove);
                }
        }
    }

    @Override
    public String getSymbol() {
        return "";
    }
}
