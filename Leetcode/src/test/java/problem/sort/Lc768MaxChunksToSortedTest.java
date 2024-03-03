package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc768MaxChunksToSortedTest {

    @Test
    void maxChunksToSorted() {
        assertEquals(4, new Lc768MaxChunksToSorted().maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        assertEquals(5, new Lc768MaxChunksToSorted().maxChunksToSorted(new int[]{0, 0, 1, 1, 1}));
        assertEquals(2, new Lc768MaxChunksToSorted().maxChunksToSorted(new int[]{0, 3, 0, 3, 2}));
        assertEquals(1, new Lc768MaxChunksToSorted().maxChunksToSorted(new int[]{4, 2, 2, 1, 1}));
        assertEquals(1, new Lc768MaxChunksToSorted().maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
    }
}