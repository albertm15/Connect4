import java.util.StringTokenizer;

public class Board {

    private final int numRows;
    private final int numColumns;
    private final Player[][] cells;

    public Board(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.cells = new Player[numRows][numColumns];
    }

    public boolean canPlayColumn(int column) {
        boolean resulCanPlayColumn = false;

        if(this.numColumns <= column){
            return false;
        }
        if(column >= 0) {
            for(int i = 0;i < this.numRows && resulCanPlayColumn == false; i++){
                if(this.cells[i][column] == null){
                    resulCanPlayColumn = true;
                }
            }
            return resulCanPlayColumn;
        }
        else {
            return false;
        }
    }

    public boolean hasValidMoves() {
        boolean validMoves = false;

        for(int i = 0; i < this.numColumns; i++){
            if(canPlayColumn(i) == true){
                return true;
            }
        }
        return validMoves;
    }

    public Position play(int column, Player player) {
        Position newMovement;

        if(canPlayColumn(column) == false){
            return null;
        }
        else{
            this.cells[lastEmptyRow(column)][column] = player;
            newMovement = new Position(lastEmptyRow(column) + 1, column);
            return newMovement;
        }
    }

    public int lastEmptyRow(int column) {
        boolean foundLastEmptyRow = false;
        int emptyRow = 0;
        if(canPlayColumn(column) == false){
            return -1;
        }
        else{
            for(emptyRow = this.numRows - 1; emptyRow >= 0 && foundLastEmptyRow == false; emptyRow--){
                if(this.cells[emptyRow][column] == null){
                    foundLastEmptyRow = true;
                    return emptyRow;
                }
            }
            return emptyRow;
        }
    }

    public int maxConnected(Position position) {
        int maxConnected = 0;
        int maxInVertical = connectedVertical(position);
        int maxInHorizontal = connectedHorizontal(position);
        int maxInMainDiagonal = connectedMainDiagonal(position);
        int maxInContraDiagonal = connectedContraDiagonal(position);

        if(maxConnected <= maxInVertical){
            maxConnected = maxInVertical;
        }
        if(maxConnected <= maxInHorizontal){
            maxConnected = maxInHorizontal;
        }
        if(maxConnected <= maxInMainDiagonal){
            maxConnected = maxInMainDiagonal;
        }
        if(maxConnected <= maxInContraDiagonal){
            maxConnected = maxInContraDiagonal;
        }

        return maxConnected;
    }
    public int connected (Direction direction, Position pos1, Position pos2, Position position){
        boolean connected = true;
        int numConnected = 1;
        Player actualPlayer = this.cells[position.getRow()][position.getColumn()];
        Direction invertedDirection = direction.invert();
        Position movingPosition = new Position(position.getRow(),position.getColumn());

        for(int i = 0; i < Position.pathLength(pos1, position)-1 && connected == true; i++){
            movingPosition = movingPosition.move(direction);
            if(actualPlayer.isEqualTo(this.cells[movingPosition.getRow()][movingPosition.getColumn()])){
                numConnected += 1;
            }
            else{
                connected = false;
            }
        }
        connected = true;
        movingPosition = position;
        for(int i = 0; i < Position.pathLength(pos2, position)-1 && connected == true; i++){
            movingPosition= movingPosition.move(invertedDirection);
            if(actualPlayer.isEqualTo(this.cells[movingPosition.getRow()][movingPosition.getColumn()])){
                numConnected += 1;
            }
            else{
                connected = false;
            }
        }
        return numConnected;
    }

    public int connectedVertical(Position position){
        Direction direction = Direction.DOWN;
        Position pos2 = new Position(0, position.getColumn());
        Position pos1 = new Position(this.numRows -1, position.getColumn());

        return connected(direction,pos1,pos2,position);
    }
    public int connectedHorizontal(Position position){
        Direction direction = Direction.RIGHT;
        Position pos2 = new Position(position.getRow(), 0);
        Position pos1 = new Position(position.getRow(), this.numColumns-1);

        return connected(direction,pos1,pos2,position);
    }

    public int connectedMainDiagonal(Position position){
        Direction direction = Direction.MAIN_DIAGONAL;
        int row = position.getRow();
        int column = position.getColumn();
        int invertedRow = position.getRow();
        int invertedColumn = position.getColumn();

        while(row < this.numRows -1 && column < this.numColumns -1){
            row++;
            column++;
        }
        while(invertedRow > 0 && invertedColumn > 0){
            invertedRow--;
            invertedColumn--;
        }
        Position pos2 = new Position(invertedRow, invertedColumn);
        Position pos1 = new Position(row, column);

        return connected(direction,pos1,pos2,position);
    }

    public int connectedContraDiagonal(Position position){
        Direction direction = Direction.CONTRA_DIAGONAL;
        int row = position.getRow();
        int column = position.getColumn();
        int invertedRow = position.getRow();
        int invertedColumn = position.getColumn();
        while(row < this.numRows -1 && column > 0){
            row++;
            column--;
        }
        while(invertedRow > 0 && invertedColumn < this.numColumns -1){
            invertedRow--;
            invertedColumn++;
        }
        Position pos2 = new Position(invertedRow, invertedColumn);
        Position pos1 = new Position(row, column);
        Position movingPosition = new Position(position.getRow(),position.getColumn());

        return connected(direction,pos1,pos2,position);
    }

    
    // Only for testing

    public int loadBoard(String str) {
        // Does not check if it corresponds to a "real" game
        StringTokenizer st = new StringTokenizer(str, "\n");
        int nonEmpty = 0;
        int row = 0;
        while (st.hasMoreTokens()) {
            String rowChars = st.nextToken();
            for (int column = 0; column < rowChars.length(); column++) {
                Player player = Player.fromChar(rowChars.charAt(column));
                if (player != null) {
                    nonEmpty += 1;
                }
                cells[row][column] = player;
            }
            row += 1;
        }
        return nonEmpty;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                Player player = cells[row][column];
                sb.append(player != null ? player.toString() : "·");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
