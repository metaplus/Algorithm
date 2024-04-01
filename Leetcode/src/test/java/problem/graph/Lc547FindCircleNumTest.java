package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc547FindCircleNumTest {

    @Test
    void findCircleNum() {
        assertEquals(1, new Lc547FindCircleNum().findCircleNum(ArrayParse.parse2DIntArray("[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]")));
    }
}