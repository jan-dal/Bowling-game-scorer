import java.util.ArrayList;

public class BowlingGame {

    private int currentRollNumber;
    private final ArrayList<Frame> frames;
    private final ArrayList<Integer> knockedPins;

    public BowlingGame() {
        frames = new ArrayList<>();
        knockedPins = new ArrayList<>();
        currentRollNumber = 0;
    }

    public void openFrame(int firstThrow, int secondThrow){
        frames.add(new OpenFrame(firstThrow, secondThrow, currentRollNumber));
        knockedPins.add(firstThrow);
        knockedPins.add(secondThrow);
        currentRollNumber += 2;
    }

    public void spare(int firstThrow, int secondThrow){
        frames.add(new SpareFrame(firstThrow, secondThrow, currentRollNumber));
        knockedPins.add(firstThrow);
        knockedPins.add(secondThrow);
        currentRollNumber += 2;
    }

    public void strike(){
        frames.add(new StrikeFrame(currentRollNumber));
        knockedPins.add(10);
        currentRollNumber++;
    }

    public void bonusRoll(int bonusThrow){
        knockedPins.add(bonusThrow);
        currentRollNumber++;
    }

    public int totalScore(){
        int total = 0;
        for (Frame frame: frames
             ) {
            total += frame.score(knockedPins);
        }
        return total;
    }

    public ArrayList<Frame> getFrames(){
        return frames;
    }

    public ArrayList<Integer> getKnockedPins(){
        return knockedPins;
    }

    public int getCurrentRollNumber(){
        return currentRollNumber;
    }
}
