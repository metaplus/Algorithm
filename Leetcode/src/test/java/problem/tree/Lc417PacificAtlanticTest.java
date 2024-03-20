package problem.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

class Lc417PacificAtlanticTest extends Assertions {

    @Test
    void pacificAtlantic() {
        assertEquals(7, new Lc417PacificAtlantic().pacificAtlantic(ArrayParse.parse2DIntArray("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")).size());
        assertEquals(4, new Lc417PacificAtlantic().pacificAtlantic(ArrayParse.parse2DIntArray("[[2,1],[1,2]]")).size());
    }
}