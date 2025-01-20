package problem.array.simulate;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc100300SumDigitDifferencesTest {

    @Test
    void sumDigitDifferences() {
        assertEquals(2, new Lc100300SumDigitDifferences().sumDigitDifferences(ArrayParse.parseIntArray("[6,2,2]")));
        assertEquals(4, new Lc100300SumDigitDifferences().sumDigitDifferences(ArrayParse.parseIntArray("[13,23,12]")));
    }
}