package problem.backtrack;

import base.AlgorithmTest;
import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.dfs.Lc39CombinationSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc39CombinationSumTest extends AlgorithmTest {

    @Test
    void combinationSum() {
        assertEquals(ArrayParse.parse2DIntList("[[2,2,3],[7]]"), new Lc39CombinationSum().combinationSum(ArrayParse.parseIntArray("[2,3,6,7]"), 7));
    }
}