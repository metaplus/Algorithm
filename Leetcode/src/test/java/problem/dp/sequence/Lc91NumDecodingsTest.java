package problem.dp.sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc91NumDecodingsTest {

    @Test
    void numDecodings() {
        assertEquals(2,new Lc91NumDecodings().numDecodings("12"));
        assertEquals(3,new Lc91NumDecodings().numDecodings("226"));
    }
}