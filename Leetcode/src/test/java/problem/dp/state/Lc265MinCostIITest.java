package problem.dp.state;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc265MinCostIITest {

    @Test
    void minCostII() {
        assertEquals(5, new Lc265MinCostII().minCostII(ArrayParse.parse2DIntArray("[[1,5,3],[2,9,4]]")));
    }
}