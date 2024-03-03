package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc164MaximumGapTest {

    @Test
    void maximumGap() {
        assertEquals(2901, new Lc164MaximumGap().maximumGap(new int[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740}));
        assertEquals(999_999_9, new Lc164MaximumGap().maximumGap(new int[]{1, 10000000}));
        assertEquals(3, new Lc164MaximumGap().maximumGap(new int[]{3, 6, 9, 1}));
    }
}