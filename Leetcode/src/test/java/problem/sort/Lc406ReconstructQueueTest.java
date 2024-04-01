package problem.sort;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc406ReconstructQueueTest {

    @Test
    void reconstructQueue() {
        assertArrayEquals(ArrayParse.parse2DIntArray("[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]"), new Lc406ReconstructQueue().reconstructQueue(ArrayParse.parse2DIntArray(" [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]")));
    }
}