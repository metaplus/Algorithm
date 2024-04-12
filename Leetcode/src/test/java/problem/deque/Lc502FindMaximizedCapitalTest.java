package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc502FindMaximizedCapitalTest {

    @Test
    void findMaximizedCapital() {
        assertEquals(4, new Lc502FindMaximizedCapital()
                .findMaximizedCapital(2, 0, ArrayParse.parseIntArray("[1,2,3]"), ArrayParse.parseIntArray("[0,1,1]")));
    }
}