public class Position {

    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Position move(Direction direction) {
        int newRow = this.row + direction.getChangeInRow();
        int newColumn = this.column + direction.getChangeInColumn();
        Position newPosition = new Position(newRow, newColumn);

        return newPosition;
    }

    public boolean isEqualTo(Position other) {
        return (this.row == other.row && this.column == other.column);
    }

    public static int pathLength(Position pos1, Position pos2) {
        int resultRow = Math.abs(pos1.row - pos2.row)+1;
        int resultColumn = Math.abs(pos1.column - pos2.column)+1;

        if(pos1.row == pos2.row){
            return resultColumn;
        }
        else if (pos1.column == pos2.column){
            return resultRow;
        }
        else{
            return (resultColumn + resultRow) / 2;
        }
    }
}
