package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.Lc295MedianFinder.MedianFinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc295MedianFinderTest {


    @Test
    void medianFinder() {
        {
            MedianFinder finder = new MedianFinder();
            finder.addNum(-1);
            finder.addNum(-2);
            finder.addNum(-3);
            assertEquals(-2, finder.findMedian());
        }
        {
            MedianFinder finder = new MedianFinder();
            finder.addNum(2);
            finder.addNum(3);
            assertEquals(2.5, finder.findMedian());
        }
    }
}