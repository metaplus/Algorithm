package problem.dp.state;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc983MincostTicketsTest {

    @Test
    void mincostTickets() {
        assertEquals(11, new Lc983MincostTickets().mincostTickets(
                ArrayParse.parseIntArray("[1,4,6,7,8,20]"), ArrayParse.parseIntArray("[2,7,15]")));
    }
}