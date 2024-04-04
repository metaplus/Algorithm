package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc2192GetAncestorsTest {

    @Test
    void getAncestors() {
        assertEquals(ArrayParse.parse2DIntList("[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]"),new Lc2192GetAncestors().getAncestors(8,
                ArrayParse.parse2DIntArray("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]")));
    }
}