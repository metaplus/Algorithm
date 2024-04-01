package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc785IsBipartiteTest {

    @Test
    void isBipartite() {
        assertFalse(new Lc785IsBipartite().isBipartite(ArrayParse.parse2DIntArray("[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]")));
        assertTrue(new Lc785IsBipartite().isBipartite(ArrayParse.parse2DIntArray("[[1,3],[0,2],[1,3],[0,2]]")));
    }
}