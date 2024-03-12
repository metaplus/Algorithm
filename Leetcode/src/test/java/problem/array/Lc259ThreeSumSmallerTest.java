package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc259ThreeSumSmallerTest {

    @Test
    void threeSumSmaller() {
        assertEquals(2, new Lc259ThreeSumSmaller().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}