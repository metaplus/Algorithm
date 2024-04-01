package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc189RotateTest {

    @Test
    void rotate() {

        {
            int[] arr = ArrayParse.parseIntArray("[-1,-100,3,99]");
            new Lc189Rotate().rotate(arr, 2);
            assertArrayEquals(ArrayParse.parseIntArray("[3,99,-1,-100]"), arr);
        }
        {
            int[] arr = ArrayParse.parseIntArray("[1,2,3,4,5,6,7]");
            new Lc189Rotate().rotate(arr, 3);
            assertArrayEquals(ArrayParse.parseIntArray("[5,6,7,1,2,3,4]"), arr);
        }
    }
}