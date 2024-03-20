package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc934ShortestBridgeTest {

    @Test
    void shortestBridge() {
        assertEquals(3, new Lc934ShortestBridge().shortestBridge(ArrayParse.parse2DIntArray("[[0,1,0,0,0,0],[0,1,1,1,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[1,1,0,0,0,0]]")));
        assertEquals(1, new Lc934ShortestBridge().shortestBridge(ArrayParse.parse2DIntArray("[[0,1],[1,0]]")));
    }
}