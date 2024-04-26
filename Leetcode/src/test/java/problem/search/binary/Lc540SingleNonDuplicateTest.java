package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc540SingleNonDuplicateTest {

    @Test
    void singleNonDuplicate() {
        assertEquals(2, new Lc540SingleNonDuplicate().singleNonDuplicate(ArrayParse.parseIntArray("[1,1,2,3,3,4,4,8,8]")));
    }
}