package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc480MedianSlidingWindowTest {

    @Test
    void medianSlidingWindow() {
        assertArrayEquals(new double[]{1, 2},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647}, 2));
        assertArrayEquals(new double[]{1, 2},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{1, 2}, 1));
        assertArrayEquals(new double[]{2.5},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{1, 4, 2, 3}, 4));
        assertArrayEquals(new double[]{1, -1, -1, 3, 5, 6},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}