package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Lc1306CanReachTest {

    @Test
    void canReach() {
        assertFalse(new Lc1306CanReach().canReach(ArrayParse.parseIntArray("[3,0,2,1,2]"), 2));
    }
}