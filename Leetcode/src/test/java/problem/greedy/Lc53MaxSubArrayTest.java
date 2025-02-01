package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.dp.Lc53MaxSubArray;

import static org.junit.jupiter.api.Assertions.*;

class Lc53MaxSubArrayTest {

    @Test
    void maxSubArray() {
        assertEquals(23, new Lc53MaxSubArray().maxSubArray(new int[]{5,4,-1,7,8}));
        assertEquals(6, new Lc53MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, new Lc53MaxSubArray().maxSubArray(new int[]{-2, 1}));
    }
}