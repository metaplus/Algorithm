package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc452FindMinArrowShotsTest {

    @Test
    void findMinArrowShots() {
        assertEquals(2, new Lc452FindMinArrowShots().findMinArrowShots(ArrayParse.parse2DIntArray("[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]")));
        assertEquals(2, new Lc452FindMinArrowShots().findMinArrowShots(ArrayParse.parse2DIntArray("[[-2147483646,-2147483645],[2147483646,2147483647]]")));
        assertEquals(2, new Lc452FindMinArrowShots()
                .findMinArrowShots(new int[][]{
                        new int[]{3, 9}, new int[]{7, 12}, new int[]{3, 8}, new int[]{6, 8},
                        new int[]{9, 10}, new int[]{2, 9}, new int[]{0, 9}, new int[]{3, 9},
                        new int[]{0, 6}, new int[]{2, 8}
                }));
        assertEquals(2, new Lc452FindMinArrowShots()
                .findMinArrowShots(new int[][]{
                        new int[]{10, 16}, new int[]{2, 8}, new int[]{1, 6}, new int[]{7, 12}
                }));
    }
}