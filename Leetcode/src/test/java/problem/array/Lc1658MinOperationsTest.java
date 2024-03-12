package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1658MinOperationsTest {

    @Test
    void minOperations() {
        assertEquals(5, new Lc1658MinOperations().minOperations(new int[]{3,2,20,1,1,3}, 10));
        assertEquals(-1, new Lc1658MinOperations().minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        assertEquals(2, new Lc1658MinOperations().minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }
}