package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc354MaxEnvelopesTest {

    @Test
    void maxEnvelopes() {
        assertEquals(3, new Lc354MaxEnvelopes()
                .maxEnvelopes(ArrayParse.parse2DIntArray("[[5,4],[6,4],[6,7],[2,3]]")));
    }
}