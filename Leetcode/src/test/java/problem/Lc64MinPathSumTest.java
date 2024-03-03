package problem;

import org.junit.jupiter.api.Test;
import problem.dp.Lc64MinPathSum;

import static org.junit.jupiter.api.Assertions.*;

class Lc64MinPathSumTest {

    @Test
    void minPathSum() {
        assertEquals(3, new Lc64MinPathSum().minPathSum(new int[][]{new int[]{1, 2}, new int[]{1, 1}}));
        assertEquals(12, new Lc64MinPathSum().minPathSum(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}}));
    }

}