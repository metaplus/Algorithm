package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc719SmallestDistancePairTest {

    @Test
    void smallestDistancePair() {
        assertEquals(0, new Lc719SmallestDistancePair().smallestDistancePair(new int[]{1, 3, 1}, 1));
    }
}