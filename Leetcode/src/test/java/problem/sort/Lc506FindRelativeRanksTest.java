package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc506FindRelativeRanksTest {

    @Test
    void findRelativeRanks() {
        assertArrayEquals(new String[]{"5", "4", "Bronze Medal", "Silver Medal", "Gold Medal"},
                new Lc506FindRelativeRanks().findRelativeRanks(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"},
                new Lc506FindRelativeRanks().findRelativeRanks(new int[]{10, 3, 8, 9, 4}));
        assertArrayEquals(new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"},
                new Lc506FindRelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1}));
    }
}