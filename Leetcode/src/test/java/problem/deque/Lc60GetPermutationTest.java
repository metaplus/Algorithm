package problem.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc60GetPermutationTest {

    @Test
    void getPermutation() {
        assertEquals("213", new Lc60GetPermutation().getPermutation(3, 3));
    }
}