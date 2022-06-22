import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class StringToBowlingGameTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/TestSource.csv")
    void getBowlingGame(String rolls, int score) {
        StringToBowlingGame converter = new StringToBowlingGame(rolls);
        BowlingGame game = converter.getBowlingGame();
        assertEquals(score, game.totalScore());
    }
}