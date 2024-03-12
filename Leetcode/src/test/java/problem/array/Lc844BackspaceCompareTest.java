package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc844BackspaceCompareTest {

    @Test
    void backspaceCompare() {
        assertFalse(new Lc844BackspaceCompare().backspaceCompare("bbbextm", "bbb#extm"));
        assertTrue(new Lc844BackspaceCompare().backspaceCompare("nzp#o#g", "b#nzp#o#g"));
        assertTrue(new Lc844BackspaceCompare().backspaceCompare("bxj##tw", "bxo#j##tw"));
        assertTrue(new Lc844BackspaceCompare().backspaceCompare("a##c", "#a#c"));
        assertTrue(new Lc844BackspaceCompare().backspaceCompare("ab##", "c#d#"));
    }
}