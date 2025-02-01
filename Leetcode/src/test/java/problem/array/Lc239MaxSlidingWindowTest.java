package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc239MaxSlidingWindowTest {

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(new int[]{10,10,9,2}, new Lc239MaxSlidingWindow()
                .maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5));
        assertArrayEquals(new int[]{3,3,2,5}, new Lc239MaxSlidingWindow()
                .maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3));
        assertArrayEquals(new int[]{1,-1}, new Lc239MaxSlidingWindow()
                .maxSlidingWindow(new int[]{1,-1}, 1));
        assertArrayEquals(new int[]{3,3,5,5,6,7}, new Lc239MaxSlidingWindow()
                .maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}