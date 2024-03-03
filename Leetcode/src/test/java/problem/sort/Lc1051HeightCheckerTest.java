package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1051HeightCheckerTest {

    @Test
    void heightChecker() {
        assertEquals(5, new Lc1051HeightChecker().heightChecker(new int[]{5, 1, 2, 3, 4}));
        assertEquals(3, new Lc1051HeightChecker().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}