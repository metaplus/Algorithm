package problem.hashmap;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc287FindDuplicateTest {

    @Test
    void findDuplicate() {
        assertEquals(2, new Lc287FindDuplicate().findDuplicate(ArrayParse.parseIntArray("[1,3,4,2,2]")));
    }
}