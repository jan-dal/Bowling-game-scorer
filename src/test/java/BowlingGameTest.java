import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;




class BowlingGameTest {

    static final int n = 100;

    @Test
    @DisplayName("Create a new open frame")
    void openFrame() {
        BowlingGame game = new BowlingGame();
        ArrayList<Integer> knockedPins = game.getKnockedPins();
        ArrayList<Frame> frames = game.getFrames();
        int firstRandomThrow, secondRandomThrow;

        for(int i = 0; i < n; i++){
            firstRandomThrow = ThreadLocalRandom.current().nextInt(0, 10);
            secondRandomThrow = ThreadLocalRandom.current().nextInt(0, 10-firstRandomThrow);
            game.openFrame(firstRandomThrow, secondRandomThrow);
            assertEquals(firstRandomThrow + Integer.toString(secondRandomThrow), frames.get(i).toString());
            assertEquals(firstRandomThrow, knockedPins.get(2*i));
            assertEquals(secondRandomThrow, knockedPins.get(2*i+1));
        }
    }

    @Test
    @DisplayName("Create a new spare frame")
    void spare() {
        BowlingGame game = new BowlingGame();
        ArrayList<Integer> knockedPins = game.getKnockedPins();
        ArrayList<Frame> frames = game.getFrames();
        int firstRandomThrow, secondRandomThrow;

        for(int i = 0; i < n; i++){
            firstRandomThrow = ThreadLocalRandom.current().nextInt(0, 10);
            secondRandomThrow = 10 - firstRandomThrow;
            game.spare(firstRandomThrow, secondRandomThrow);
            assertEquals(firstRandomThrow + "/", frames.get(i).toString());
            assertEquals(firstRandomThrow, knockedPins.get(2*i));
            assertEquals(secondRandomThrow, knockedPins.get(2*i+1));
        }
    }

    @Test
    @DisplayName("Create a new strike frame")
    void strike() {
        BowlingGame game = new BowlingGame();
        ArrayList<Integer> knockedPins = game.getKnockedPins();
        ArrayList<Frame> frames = game.getFrames();

        for(int i = 0; i < n; i++){
            game.strike();
            assertEquals("X", frames.get(i).toString());
            assertEquals(10, knockedPins.get(i));
        }
    }

    @Test
    @DisplayName("Add bonus roll")
    void bonusRoll() {
        BowlingGame game = new BowlingGame();
        ArrayList<Integer> knockedPins = game.getKnockedPins();
        int randomThrow;

        for(int i = 0; i < n; i++){
            randomThrow = ThreadLocalRandom.current().nextInt(0, 11);
            game.bonusRoll(randomThrow);
            assertEquals(randomThrow, knockedPins.get(i));
        }
    }

    @DisplayName("Calculate the total score of the bowling game")
    @ParameterizedTest
    @CsvFileSource(resources = "/TestSource.csv")
    void totalScore(String rolls, int score) {
        StringToBowlingGame converter = new StringToBowlingGame(rolls);
        BowlingGame game = converter.getBowlingGame();
        assertEquals(score, game.totalScore());
    }
}