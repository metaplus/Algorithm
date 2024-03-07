package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc56MergeTest {

    @Test
    void merge() {
        assertArrayEquals(new int[][]{new int[]{1, 6}, new int[]{8, 10}, new int[]{15, 18}},
                new Lc56Merge().merge(new int[][]{
                        new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}
                }));
        assertArrayEquals(new int[][]{new int[]{0, 5}},
                new Lc56Merge().merge(new int[][]{
                        new int[]{1, 4}, new int[]{0, 2}, new int[]{3, 5}
                }));

        assertArrayEquals(new int[][]{new int[]{1, 10}},
                new Lc56Merge().merge(new int[][]{new int[]{2, 3}, new int[]{4, 5}, new int[]{6, 7}, new int[]{8, 9},
                        new int[]{1, 10}
                }));
    }
}