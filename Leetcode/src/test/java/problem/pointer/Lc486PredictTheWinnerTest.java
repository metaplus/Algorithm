package problem.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.Lc486PredictTheWinner;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Lc486PredictTheWinnerTest {

    @Test
    void predictTheWinner() {
        assertFalse(new Lc486PredictTheWinner().predictTheWinner(ArrayParse.parseIntArray("[2,4,55,6,8]")));
    }
}