package problem.search.dfs;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.greedy.Lc134CanCompleteCircuit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc134CanCompleteCircuitTest {

    @Test
    void canCompleteCircuit() {
        assertEquals(-1, new Lc134CanCompleteCircuit().canCompleteCircuit(ArrayParse.parseIntArray("[2,3,4]"), ArrayParse.parseIntArray("[3,4,3]")));
        assertEquals(4, new Lc134CanCompleteCircuit().canCompleteCircuit(ArrayParse.parseIntArray("[5,1,2,3,4]"), ArrayParse.parseIntArray("[4,4,1,5,1]")));
        assertEquals(3, new Lc134CanCompleteCircuit().canCompleteCircuit(ArrayParse.parseIntArray("[1,2,3,4,5]"), ArrayParse.parseIntArray("[3,4,5,1,2]")));
    }
}