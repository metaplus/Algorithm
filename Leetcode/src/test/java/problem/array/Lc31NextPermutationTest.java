package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc31NextPermutationTest {

    @Test
    void nextPermutation() {
        {
            int[] arr = ArrayParse.parseIntArray("[2,3,1]");
            new Lc31NextPermutation().nextPermutation(arr);
            assertArrayEquals(ArrayParse.parseIntArray("[3,1,2]"), arr);
        }
        {
            int[] arr = ArrayParse.parseIntArray("[1,3,2]");
            new Lc31NextPermutation().nextPermutation(arr);
            assertArrayEquals(ArrayParse.parseIntArray("[2,1,3]"), arr);
        }
    }
}