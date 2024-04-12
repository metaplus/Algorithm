package problem.deque.priority;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc621LeastIntervalTest {

    @Test
    void leastInterval() {
        assertEquals(12,new Lc621LeastInterval().leastInterval(
                ArrayParse.parseCharArray("[\"A\",\"A\",\"A\",\"A\",\"A\",\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\"]"),1));
        assertEquals(8,new Lc621LeastInterval().leastInterval(
                ArrayParse.parseCharArray("[\"A\",\"A\",\"A\",\"B\",\"B\",\"B\"]"),2));
    }
}