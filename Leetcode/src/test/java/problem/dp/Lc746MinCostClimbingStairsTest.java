package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc746MinCostClimbingStairsTest {

    @Test
    void minCostClimbingStairs() {
        assertEquals(15,new Lc746MinCostClimbingStairs().minCostClimbingStairs(ArrayParse.parseIntArray("[10,15,20]")));
    }
}