package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc207CanFinishTest {

    @Test
    void canFinish() {
        assertTrue(new Lc207CanFinish().canFinish(3, ArrayParse.parse2DIntArray("[[0,1],[0,2],[1,2]]")));
        assertTrue(new Lc207CanFinish().canFinish(5, ArrayParse.parse2DIntArray("[[1,4],[2,4],[3,1],[3,2]]")));
        assertTrue(new Lc207CanFinish().canFinish(3, ArrayParse.parse2DIntArray("[[2,0],[2,1]]")));
        assertFalse(new Lc207CanFinish().canFinish(2, ArrayParse.parse2DIntArray("[[1,0],[0,1]]")));
        assertTrue(new Lc207CanFinish().canFinish(2, ArrayParse.parse2DIntArray("[[1,0]]")));
    }
}