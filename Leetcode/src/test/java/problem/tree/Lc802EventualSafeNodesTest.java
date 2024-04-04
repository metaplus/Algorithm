package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc802EventualSafeNodesTest {

    @Test
    void eventualSafeNodes() {
        assertEquals(ArrayParse.parseIntList("[2,4,5,6]"),
                new Lc802EventualSafeNodes().eventualSafeNodes(ArrayParse.parse2DIntArray("[[1,2],[2,3],[5],[0],[5],[],[]]")));
    }
}