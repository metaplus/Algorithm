package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc435EraseOverlapIntervalsTest {

    @Test
    void eraseOverlapIntervals() {

        assertEquals(2, new Lc435EraseOverlapIntervals()
                .eraseOverlapIntervals(new int[][]{
                        new int[]{1, 100}, new int[]{11, 22}, new int[]{1, 11}, new int[]{2, 12}
                }));
        assertEquals(2, new Lc435EraseOverlapIntervals()
                .eraseOverlapIntervals(new int[][]{
                        new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}
                }));
    }
}