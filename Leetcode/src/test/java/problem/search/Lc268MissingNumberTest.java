package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc268MissingNumberTest {

    @Test
    void missingNumber() {
        assertEquals(1,new Lc268MissingNumber().missingNumber(ArrayParse.parseIntArray("[0,2,3]")));
    }
}