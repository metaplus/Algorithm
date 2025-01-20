package problem.dp;

import org.junit.jupiter.api.Test;
import problem.search.dfs.Lc3154WaysToReachStair;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3154WaysToReachStairTest {

    @Test
    void waysToReachStair() {
        assertEquals(2, new Lc3154WaysToReachStair().waysToReachStair(0));
        assertEquals(4, new Lc3154WaysToReachStair().waysToReachStair(1));
    }
}