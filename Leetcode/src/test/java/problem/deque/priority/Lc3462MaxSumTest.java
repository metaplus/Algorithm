package problem.deque.priority;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3462MaxSumTest {

    @Test
    void maxSum() {
        assertEquals(86, new Lc3462MaxSum()
                .maxSum(ArrayParse.parse2DIntArray("[[5,5,9,2,1,5,9,7,0,10,10,1,7],[0,9,1,3,8,5,6,8,6,4,0,0,6]]"),
                        ArrayParse.parseIntArray("[13,2]"), 12));
    }
}