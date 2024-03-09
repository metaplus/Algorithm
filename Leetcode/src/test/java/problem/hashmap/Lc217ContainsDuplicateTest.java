package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc217ContainsDuplicateTest {

    @Test
    void containsDuplicate() {
        assertTrue(new Lc217ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}