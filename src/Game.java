public class Game {

    private final Board board;
    private final int toWin;

    private Status status;

    private Position lastPosition;

    public Game(int rows, int columns, int toWin) {
        this.board = new Board(rows, columns);
        this.toWin = toWin;
        this.status = Status.ONE_PLAYS;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean canPlayColumn(int column) {
        return this.board.canPlayColumn(column);
    }

    public Move play(int column) {
        Player player;
        Position position;
        Move newMove;
        Status initialStatus = this.status;
        if(initialStatus == Status.ONE_PLAYS){
            player = Player.ONE;
            position = this.board.play(column, player);
            newMove = new Move(player, position);
        }
        else{
            player = Player.TWO;
            position = this.board.play(column, player);
            newMove = new Move(player, position);
        }
        this.lastPosition = position;
        updateStatus();
        return newMove;
    }

    public boolean isFinished() {
        if(this.status == Status.ONE_HAS_WON){
            return true;
        }
        if(this.status == Status.TWO_HAS_WON){
            return true;
        }
        if(this.status == Status.DRAW){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateStatus() {
        if(this.board.maxConnected(this.lastPosition) == this.toWin && this.status == Status.TWO_PLAYS){
            this.status = Status.TWO_HAS_WON;
        }
        else if(this.board.maxConnected(this.lastPosition) == this.toWin && this.status == Status.ONE_PLAYS){
            this.status = Status.ONE_HAS_WON;
        }
        else if(this.board.maxConnected(this.lastPosition) != this.toWin && !this.board.hasValidMoves()){
            this.status = Status.DRAW;
        }
        else{
            if(this.status == Status.ONE_PLAYS){
                this.status = Status.TWO_PLAYS;
            }
            else{
                this.status = Status.ONE_PLAYS;
            }
        }
    }
    // Only for testing

    public void loadGame(String str) {
        // Does not check if it corresponds to a "real" game
        int played = board.loadBoard(str);
        status = played % 2 == 0
                ? Status.ONE_PLAYS
                : Status.TWO_PLAYS;
    }
    
    public String toString() {
        return this.board.toString();
    }
}
