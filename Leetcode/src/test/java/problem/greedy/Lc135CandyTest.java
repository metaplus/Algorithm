package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc135CandyTest {

    @Test
    void candy() {
        assertEquals(11, new Lc135Candy().candy(ArrayParse.parseIntArray("[1,3,4,5,2]")));
        assertEquals(5, new Lc135Candy().candy(new int[]{1, 0, 2}));
    }
}