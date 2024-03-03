package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc908SmallestRangeIITest {

    @Test
    void smallestRangeII() {
        assertEquals(5, new Lc908SmallestRangeII().smallestRangeII(new int[]{7,8,8,5,2}, 4));
        assertEquals(2, new Lc908SmallestRangeII().smallestRangeII(new int[]{3,1,10}, 4));
        assertEquals(2, new Lc908SmallestRangeII().smallestRangeII(new int[]{5,6,4}, 5));
        assertEquals(1, new Lc908SmallestRangeII().smallestRangeII(new int[]{7,8,8}, 5));
        assertEquals(3, new Lc908SmallestRangeII().smallestRangeII(new int[]{1, 3, 6}, 3));
    }
}