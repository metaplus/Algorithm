package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc167TwoSumTest {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{2, 3},
                new Lc167TwoSum().twoSum(new int[]{5, 25, 75}, 100));

        assertArrayEquals(new int[]{1, 2},
                new Lc167TwoSum().twoSum(new int[]{0, 0, 3, 4}, 0));
        assertArrayEquals(new int[]{1, 2},
                new Lc167TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}