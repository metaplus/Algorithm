package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1004LongestOnesTest {

    @Test
    void longestOnes() {
        assertEquals(3, new Lc1004LongestOnes().longestOnes(
                new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
        assertEquals(4, new Lc1004LongestOnes().longestOnes(
                new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0));
        assertEquals(2, new Lc1004LongestOnes().longestOnes(
                new int[]{0, 1, 1}, 0));
        assertEquals(6, new Lc1004LongestOnes().longestOnes(
                new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}