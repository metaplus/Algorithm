package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc683KEmptySlotsTest {

    @Test
    void kEmptySlots() {
        assertEquals(8, new Lc683KEmptySlots().kEmptySlots(
                new int[]{6, 5, 8, 9, 7, 1, 10, 2, 3, 4}, 2));
        assertEquals(-1, new Lc683KEmptySlots().kEmptySlots(
                new int[]{1, 2, 3, 4}, 1));
    }
}