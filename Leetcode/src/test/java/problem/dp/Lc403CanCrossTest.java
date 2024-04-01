package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc403CanCrossTest {

    @Test
    void canCross() {
        assertTrue(new Lc403CanCross().canCross(ArrayParse.parseIntArray("[0,1,3,5,6,8,12,17]")));
    }
}