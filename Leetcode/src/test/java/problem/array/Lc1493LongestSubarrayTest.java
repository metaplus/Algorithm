package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1493LongestSubarrayTest {

    @Test
    void longestSubarray() {
        assertEquals(3, new Lc1493LongestSubarray().longestSubarray(new int[]{1, 1, 0, 1}));
    }
}