package problem.deque.priority;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc857MincostToHireWorkersTest {

    @Test
    void mincostToHireWorkers() {
        assertEquals(30.666666666666664, new Lc857MincostToHireWorkers()
                .mincostToHireWorkers(ArrayParse.parseIntArray("[3,1,10,10,1]"), ArrayParse.parseIntArray("[4,8,2,2,7]"), 3));
    }
}