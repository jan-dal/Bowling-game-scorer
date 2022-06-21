import java.util.ArrayList;

public class StrikeFrame extends Frame{

    public StrikeFrame(int rollNumber){
        super(10, 0, rollNumber);
    }

    @Override
    public int score(ArrayList<Integer> knockedPins) {
        return 10 + knockedPins.get(rollNumber + 1) + knockedPins.get(rollNumber + 2);
    }

    public String toString(){
        return "X";
    }
}
