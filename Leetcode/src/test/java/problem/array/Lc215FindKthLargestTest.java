package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc215FindKthLargestTest {

    @Test
    void findKthLargest() {
        assertEquals(1, new Lc215FindKthLargest().findKthLargest(new int[]{1}, 1));
        assertEquals(5, new Lc215FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}