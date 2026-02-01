package problem.deque.priority;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.heap.priority.Lc2462TotalCost;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2462TotalCostTest {

    @Test
    void totalCost() {
        assertEquals(223, new Lc2462TotalCost().totalCost(ArrayParse.parseIntArray("[18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75]"), 13, 23));
        assertEquals(11, new Lc2462TotalCost().totalCost(ArrayParse.parseIntArray("[17,12,10,2,7,2,11,20,8]"), 3, 4));
    }
}