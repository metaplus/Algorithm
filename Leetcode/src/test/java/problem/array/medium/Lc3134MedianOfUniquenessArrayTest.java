package problem.array.medium;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3134MedianOfUniquenessArrayTest {

    @Test
    void medianOfUniquenessArray() {
        assertEquals(3, new Lc3134MedianOfUniquenessArray().medianOfUniquenessArray(ArrayParse.parseIntArray("[30,23,61,12,23,23,30]")));
        assertEquals(1, new Lc3134MedianOfUniquenessArray().medianOfUniquenessArray(ArrayParse.parseIntArray("[1,2,3]")));
        assertEquals(2, new Lc3134MedianOfUniquenessArray().medianOfUniquenessArray(ArrayParse.parseIntArray("[88,68,68,88,68]")));
    }
}