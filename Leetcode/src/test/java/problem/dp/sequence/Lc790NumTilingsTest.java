package problem.dp.sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc790NumTilingsTest {

    @Test
    void numTilings() {
        assertEquals(5, new Lc790NumTilings().numTilings(3));
        assertEquals(11, new Lc790NumTilings().numTilings(4));
    }
}