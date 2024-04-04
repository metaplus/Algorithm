package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc269AlienOrderTest {

    @Test
    void alienOrder() {
        assertEquals("gthxaqsdufvwyijkm", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"tkqgsx\",\"xgguqjkm\",\"xhkdakkyf\",\"avwiqqm\"]")));
        assertEquals("", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"z\",\"x\",\"a\",\"zb\",\"zx\"]")));
        assertEquals("", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"z\",\"x\",\"z\"]")));
        assertEquals("", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"abc\",\"ab\"]")));
        assertEquals("z", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"z\",\"z\"]")));
        assertEquals("abdc", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"ab\",\"adc\"]")));
        assertEquals("wertf", new Lc269AlienOrder().alienOrder(ArrayParse.parseStringArray("[\"wrt\",\"wrf\",\"er\",\"ett\",\"rftt\"]")));
    }
}