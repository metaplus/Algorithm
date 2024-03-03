package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1575CountRoutesTest {

    @Test
    void countRoutes() {
        assertEquals(596422131, new Lc1575CountRoutes().countRoutes(new int[]{99569, 99784, 99706, 99950, 99683, 99955, 99595, 99899, 99802, 99968, 99590, 99965, 99966, 99850, 99792, 99962, 99934, 99622, 99546, 99545, 99541, 99751, 99697, 99587, 99919, 99700, 99642, 99915, 99720, 99746, 99607, 99724, 99690, 99558, 99828, 99741, 99844, 99887, 99616, 99623, 99754, 99721, 99648, 99639, 99709, 99649, 99833, 99863, 99730, 99780, 99525, 99609, 99637, 99781, 99619, 99548, 99728, 99652, 99744, 99900, 99922, 99969, 99610, 99892, 99845, 99985, 99549, 99654, 99657, 99535, 99612, 99755, 99742, 99798, 99838, 99676, 99553, 99601, 99989, 99606, 99944, 99611}, 42, 62, 98));
        assertEquals(615088286, new Lc1575CountRoutes().countRoutes(new int[]{1, 2, 3}, 0, 2, 40));
        assertEquals(2, new Lc1575CountRoutes().countRoutes(new int[]{2, 1, 5}, 0, 0, 3));
        assertEquals(5, new Lc1575CountRoutes().countRoutes(new int[]{4, 3, 1}, 1, 0, 6));
        assertEquals(4, new Lc1575CountRoutes().countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
    }
}