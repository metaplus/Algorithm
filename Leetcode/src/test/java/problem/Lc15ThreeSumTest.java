package problem;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;
import problem.array.Lc15ThreeSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc15ThreeSumTest {

    @Test
    void threeSum() {
        new Lc15ThreeSum().threeSum(new int[]{
                34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49
        });
        assertEquals(FastList.newListWith(
                FastList.newListWith(-2, 0, 2),
                FastList.newListWith(-2, 1, 1)
        ), new Lc15ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2}));
        assertEquals(FastList.newListWith(
                FastList.newListWith(-1, -1, 2),
                FastList.newListWith(-1, 0, 1)
        ), new Lc15ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}