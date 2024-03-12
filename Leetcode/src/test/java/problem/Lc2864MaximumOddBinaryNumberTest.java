package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2864MaximumOddBinaryNumberTest {

    @Test
    void maximumOddBinaryNumber() {
        assertEquals("1001", new Lc2864MaximumOddBinaryNumber().maximumOddBinaryNumber("0101"));
        assertEquals("001", new Lc2864MaximumOddBinaryNumber().maximumOddBinaryNumber("010"));
    }
}