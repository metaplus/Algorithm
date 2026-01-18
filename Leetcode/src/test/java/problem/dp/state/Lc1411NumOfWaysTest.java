package problem.dp.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1411NumOfWaysTest {

    @Test
    void numOfWays() {
        assertEquals(246, new Lc1411NumOfWays().numOfWays(3));
        assertEquals(12, new Lc1411NumOfWays().numOfWays(1));
    }
}