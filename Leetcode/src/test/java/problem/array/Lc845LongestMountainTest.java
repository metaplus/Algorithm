package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc845LongestMountainTest {

    @Test
    void longestMountain() {
        assertEquals(3, new Lc845LongestMountain().longestMountain(new int[]{0, 2, 0, 2, 1, 2, 3, 4, 4, 1}));
        assertEquals(5, new Lc845LongestMountain().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}