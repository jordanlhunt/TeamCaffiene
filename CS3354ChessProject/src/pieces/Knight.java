package pieces;

import model.Board;
import model.Position;

import java.util.List;

public class Knight extends GamePiece {
    public Knight(PieceColor pieceColor, Position startPosition) {
        super(pieceColor, startPosition);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        return List.of();
    }

    @Override
    public String getSymbol() {
        return "";
    }
}
