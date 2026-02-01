package problem.array.prefix;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1840MaxBuildingTest {

    @Test
    void maxBuilding() {
        assertEquals(2, new Lc1840MaxBuilding().maxBuilding(10, ArrayParse.parse2DIntArray("[[8,5],[9,0],[6,2],[4,0],[3,2],[10,0],[5,3],[7,3],[2,4]]")));
        assertEquals(5, new Lc1840MaxBuilding().maxBuilding(6, new int[][]{}));
        assertEquals(5, new Lc1840MaxBuilding().maxBuilding(10, ArrayParse.parse2DIntArray("[[5,3],[2,5],[7,4],[10,3]]")));
    }
}