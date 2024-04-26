package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc153FindMin;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc153FindMinTest {

    @Test
    void findMin() {
        assertEquals(11, new Lc153FindMin().findMin(ArrayParse.parseIntArray("[11,13,15,17]")));
        assertEquals(0, new Lc153FindMin().findMin(ArrayParse.parseIntArray("[4,5,6,7,0,1,2]")));
    }
}