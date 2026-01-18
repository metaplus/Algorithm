package daily;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc2300SuccessfulPairs;

import static org.junit.jupiter.api.Assertions.*;

class Lc2300SuccessfulPairsTest {

    @Test
    void successfulPairs() {
        assertArrayEquals(ArrayParse.parseIntArray("[4,0,3]"),
                new Lc2300SuccessfulPairs().successfulPairs(
                        ArrayParse.parseIntArray("[5,1,3]"),
                        ArrayParse.parseIntArray("[1,2,3,4,5]"),
                        7L
                ));
    }
}