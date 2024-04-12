package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.dp.Lc122MaxProfit;

import static org.junit.jupiter.api.Assertions.*;

class Lc122MaxProfitTest {

    @Test
    void maxProfit() {
        assertEquals(2, new Lc122MaxProfit().maxProfit(new int[]{2,1,2,0,1}));
        assertEquals(4, new Lc122MaxProfit().maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(7, new Lc122MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}