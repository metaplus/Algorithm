package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc115NumDistinctTest {

    @Test
    void numDistinct() {
        assertEquals(5, new Lc115NumDistinct().numDistinct("babgbag", "bag"));
        assertEquals(3, new Lc115NumDistinct().numDistinct("rabbbit", "rabbit"));
    }
}