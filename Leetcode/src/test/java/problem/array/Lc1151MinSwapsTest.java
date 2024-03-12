package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1151MinSwapsTest {

    @Test
    void minSwaps() {
        assertEquals(3, new Lc1151MinSwaps().minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
    }
}