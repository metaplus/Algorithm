package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.heap.Lc480MedianSlidingWindow;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc480MedianSlidingWindowTest {

    @Test
    void medianSlidingWindow() {
        assertArrayEquals(ArrayParse.parseDoubleArray("[8.0,3.5,1.5,6.0,8.5,7.0,5.5,6.0,6.5]"),
                new Lc480MedianSlidingWindow().medianSlidingWindow(ArrayParse.parseIntArray("[9,7,0,3,9,8,6,5,7,6]"), 2));
        assertArrayEquals(ArrayParse.parseDoubleArray("[-1.0737418235E9, -1.0737418235E9, -49.5, -49.5, 2.0, 5.5, -46.0, -46.0, 12.5, 19.5, 1.0737418345E9, 2.147483647E9, 2.147483647E9, 2.147483647E9, 2.147483647E9]"),
                new Lc480MedianSlidingWindow().medianSlidingWindow(ArrayParse.parseIntArray("[-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648]"), 6));
        assertArrayEquals(new double[]{1, -1, -1, 3, 5, 6},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new double[]{1, 2},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{1, 2}, 1));
        assertArrayEquals(new double[]{2.5},
                new Lc480MedianSlidingWindow().medianSlidingWindow(new int[]{1, 4, 2, 3}, 4));

    }
}