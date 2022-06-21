import java.util.ArrayList;

public class SpareFrame extends Frame{

    public SpareFrame(int firstThrow, int secondThrow, int rollNumber){
        super(firstThrow, secondThrow, rollNumber);
    }

    @Override
    public int score(ArrayList<Integer> knockedPins) {
        return 10 + knockedPins.get(rollNumber + 2);
    }

    public String toString(){
        return Integer.toString(firstThrow) + "/";
    }
}
