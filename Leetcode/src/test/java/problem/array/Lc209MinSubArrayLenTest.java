package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.pointer.Lc209MinSubArrayLen;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc209MinSubArrayLenTest {

    @Test
    void minSubArrayLen() {
        assertEquals(0, new Lc209MinSubArrayLen().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        assertEquals(2, new Lc209MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(3, new Lc209MinSubArrayLen().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}