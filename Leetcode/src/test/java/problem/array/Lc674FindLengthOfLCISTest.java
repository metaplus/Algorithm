package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc674FindLengthOfLCISTest {

    @Test
    void findLengthOfLCIS() {
        assertEquals(3, new Lc674FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}