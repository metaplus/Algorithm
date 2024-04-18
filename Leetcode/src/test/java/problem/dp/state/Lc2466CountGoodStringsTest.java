package problem.dp.state;

import org.junit.jupiter.api.Test;
import problem.dp.sequence.Lc2466CountGoodStrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2466CountGoodStringsTest {

    @Test
    void countGoodStrings() {
        assertEquals(873327137, new Lc2466CountGoodStrings().countGoodStrings(500, 500, 5, 2));
        assertEquals(8, new Lc2466CountGoodStrings().countGoodStrings(3, 3, 1, 1));
    }
}