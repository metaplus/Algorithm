package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1498NumSubseqTest {

    @Test
    void numSubseq() {
        assertEquals(4, new Lc1498NumSubseq().numSubseq(ArrayParse.parseIntArray("[3,5,6,7]"), 9));
    }
}