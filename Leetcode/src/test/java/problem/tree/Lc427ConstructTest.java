package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Lc427ConstructTest {

    @Test
    void construct() {
        assertNotNull(new Lc427Construct().construct(ArrayParse.parse2DIntArray("[[0,1],[1,0]]")));
    }
}