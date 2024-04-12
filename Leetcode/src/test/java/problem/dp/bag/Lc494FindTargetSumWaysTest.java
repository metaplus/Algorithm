package problem.dp.bag;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc494FindTargetSumWaysTest {

    @Test
    void findTargetSumWays() {
        assertEquals(256, new Lc494FindTargetSumWays().findTargetSumWays(ArrayParse.parseIntArray("[0,0,0,0,0,0,0,0,1]"), 1));
        assertEquals(5, new Lc494FindTargetSumWays().findTargetSumWays(ArrayParse.parseIntArray("[1,1,1,1,1]"), 3));
    }
}