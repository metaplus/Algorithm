package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1052MaxSatisfiedTest {

    @Test
    void maxSatisfied() {
        assertEquals(16, new Lc1052MaxSatisfied()
                .maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}