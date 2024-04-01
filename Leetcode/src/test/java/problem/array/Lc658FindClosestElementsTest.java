package problem.array;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;
import problem.heap.Lc658FindClosestElements;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc658FindClosestElementsTest {

    @Test
    void findClosestElements() {
        assertEquals(FastList.newListWith(1, 2, 3, 4), new Lc658FindClosestElements()
                .findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        assertEquals(FastList.newListWith(10), new Lc658FindClosestElements()
                .findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));

    }
}