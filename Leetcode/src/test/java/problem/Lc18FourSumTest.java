package problem;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;
import problem.array.Lc18FourSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc18FourSumTest {

    @Test
    void fourSum() {

        assertEquals(FastList.newList(),
                new Lc18FourSum().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}