import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {

    @Test
    @DisplayName("Create a new open frame")
    void openFrame() {
        BowlingGame game = new BowlingGame();
        game.openFrame(2, 3);
        assertEquals("23", game.getFrames().get(0).toString());
        assertEquals(2, game.getKnockedPins().get(0));
        assertEquals(3, game.getKnockedPins().get(1));
    }

    @Test
    @DisplayName("Create a new spare frame")
    void spare() {
        BowlingGame game = new BowlingGame();
        game.spare(4, 6);
        assertEquals("4/", game.getFrames().get(0).toString());
        assertEquals(4, game.getKnockedPins().get(0));
        assertEquals(6, game.getKnockedPins().get(1));
    }

    @Test
    @DisplayName("Create a new strike frame")
    void strike() {
        BowlingGame game = new BowlingGame();
        game.strike();
        game.openFrame(4, 1);
        assertEquals("X", game.getFrames().get(0).toString());
        assertEquals(10, game.getKnockedPins().get(0));
    }

    @Test
    @DisplayName("Add bonus roll")
    void bonusRoll() {
        BowlingGame game = new BowlingGame();
        game.bonusRoll(9);
        assertEquals(9, game.getKnockedPins().get(0));
    }

    @Test
    @DisplayName("Calculate the total score of the bowling game")
    void totalScore() {
        BowlingGame game = new BowlingGame();
        for(int i = 0; i < 10; i++){
            game.strike();
        }
        game.bonusRoll(4);
        game.bonusRoll(6);

        assertEquals(284, game.totalScore());
    }
}