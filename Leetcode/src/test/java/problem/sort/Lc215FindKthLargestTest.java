package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc215FindKthLargestTest {

    @Test
    void findKthLargest() {
        assertEquals(4, new Lc215FindKthLargest().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        assertEquals(5, new Lc215FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}