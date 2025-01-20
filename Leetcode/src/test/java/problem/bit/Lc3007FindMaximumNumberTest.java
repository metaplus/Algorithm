package problem.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3007FindMaximumNumberTest {

    @Test
    void findMaximumNumber() {
        assertEquals(6, new Lc3007FindMaximumNumber().findMaximumNumber(9, 1));
    }
}