package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc881NumRescueBoatsTest {

    @Test
    void numRescueBoats() {
        assertEquals(2, new Lc881NumRescueBoats().numRescueBoats(new int[]{2, 4}, 5));
    }
}