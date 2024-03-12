package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Lc220ContainsNearbyAlmostDuplicateTest {

    @Test
    void containsNearbyAlmostDuplicate() {
        assertFalse(new Lc220ContainsNearbyAlmostDuplicate()
                .containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}