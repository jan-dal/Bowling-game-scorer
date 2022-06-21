import java.util.ArrayList;

public abstract class Frame {
    protected final int firstThrow, secondThrow, rollNumber;
    public Frame(int firstThrow, int secondThrow, int rollNumber){
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.rollNumber = rollNumber;
    }
    public abstract int score(ArrayList<Integer> knockedPins);
}