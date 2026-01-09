import java.util.Objects;

public class Player {

    public static final Player ONE = new Player('1');
    public static final Player TWO = new Player('2');

    private final char id;

    private Player(char id) {
        this.id = id;
    }

    public boolean isEqualTo(Player other) {

        if(other == null){
            return false;
        }
        if(this.id == other.id){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean isOne() {
        boolean resultOne = false;
        if(this.id == '1'){
            resultOne = true;
        }
        else{
            resultOne = false;
        }
        return resultOne;
    }

    public boolean isTwo() {
        boolean resultTwo = false;
        if(this.id == '2'){
            resultTwo = true;
        }
        else{
            resultTwo = false;
        }
        return resultTwo;
    }

    // Only for testing

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public static Player fromChar(char c) {
        switch (c) {
            case '1': return ONE;
            case '2': return TWO;
            default : return null;
        }
    }
}
