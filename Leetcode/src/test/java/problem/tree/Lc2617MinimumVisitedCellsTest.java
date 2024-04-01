package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2617MinimumVisitedCellsTest {

    @Test
    void minimumVisitedCells() {
        assertEquals(3, new Lc2617MinimumVisitedCells().minimumVisitedCells(ArrayParse.parse2DIntArray("[[3,2],[0,0]]")));
        assertEquals(-1, new Lc2617MinimumVisitedCells().minimumVisitedCells(ArrayParse.parse2DIntArray("[[2,1,0],[1,0,0]]")));
        assertEquals(4, new Lc2617MinimumVisitedCells().minimumVisitedCells(ArrayParse.parse2DIntArray("[[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]")));
    }
}