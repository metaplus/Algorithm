package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1247MinimumSwapTest {

    @Test
    void minimumSwap() {
        assertEquals(3, new Lc1247MinimumSwap().minimumSwap("yyyxxxyxyy", "xxyxyxyxxy"));
        assertEquals(2, new Lc1247MinimumSwap().minimumSwap("xy", "yx"));
    }
}