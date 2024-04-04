package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc1245TreeDiameterTest {

    @Test
    void treeDiameter() {
        assertEquals(5,new Lc1245TreeDiameter().treeDiameter(ArrayParse.parse2DIntArray("[[0,1],[1,2],[0,3],[3,4],[2,5],[3,6]]")));
        assertEquals(2,new Lc1245TreeDiameter().treeDiameter(ArrayParse.parse2DIntArray("[[0,1],[0,2]]")));
        assertEquals(4,new Lc1245TreeDiameter().treeDiameter(ArrayParse.parse2DIntArray("[[0,1],[1,2],[2,3],[1,4],[4,5]]")));
    }
}