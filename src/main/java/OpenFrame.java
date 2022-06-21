import java.util.ArrayList;

public class OpenFrame extends Frame {

    public OpenFrame(int firstThrow, int secondThrow, int rollNumber){
        super(firstThrow, secondThrow, rollNumber);
    }

    @Override
    public int score(ArrayList<Integer> knockedPins) {
        return firstThrow + secondThrow;
    }

    public String toString(){
        return Integer.toString(firstThrow) + Integer.toString(secondThrow);
    }
}
