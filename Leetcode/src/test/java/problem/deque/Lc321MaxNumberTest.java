package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc321MaxNumberTest {

    @Test
    void maxNumber() {
        assertArrayEquals(ArrayParse.parseIntArray("[6,7,6,0,4]"),
                new Lc321MaxNumber().maxNumber(
                        ArrayParse.parseIntArray("[6,7]"),
                        ArrayParse.parseIntArray("[6,0,4]"),
                        5
                ));
        assertArrayEquals(ArrayParse.parseIntArray("[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]"),
                new Lc321MaxNumber().maxNumber(
                        ArrayParse.parseIntArray("[2,5,6,4,4,0]"),
                        ArrayParse.parseIntArray("[7,3,8,0,6,5,7,6,2]"),
                        15
                ));
        assertArrayEquals(ArrayParse.parseIntArray("[9,7,5]"),
                new Lc321MaxNumber().maxNumber(
                        ArrayParse.parseIntArray("[8,6,9]"),
                        ArrayParse.parseIntArray("[1,7,5]"),
                        3
                ));

        assertArrayEquals(ArrayParse.parseIntArray("[9,8,6,5,3]"),
                new Lc321MaxNumber().maxNumber(
                        ArrayParse.parseIntArray("[3,4,6,5]"),
                        ArrayParse.parseIntArray("[9,1,2,5,8,3]"),
                        5
                ));
    }
}