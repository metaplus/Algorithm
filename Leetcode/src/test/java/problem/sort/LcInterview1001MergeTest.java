package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LcInterview1001MergeTest {

    @Test
    void merge() {
        {
            int[] arr = new int[]{4,0,0,0,0,0};
            new LcInterview1001Merge()
                    .merge(arr, 1, new int[]{1,2,3,5,6}, 5);
            assertArrayEquals(new int[]{1,2,3,4,5,6}, arr);
        }
        {
            int[] arr = new int[]{1, 2, 3, 0, 0, 0};
            new LcInterview1001Merge()
                    .merge(arr, 3, new int[]{2, 5, 6}, 3);
            assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, arr);
        }
    }
}