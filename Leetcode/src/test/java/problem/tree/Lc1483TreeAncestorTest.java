package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.tree.Lc1483TreeAncestor.TreeAncestor;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1483TreeAncestorTest {

    @Test
    void getKthAncestor() {
        TreeAncestor ancestor = new TreeAncestor(7, ArrayParse.parseIntArray("[-1,0,0,1,1,2,2]"));
        assertEquals(1, ancestor.getKthAncestor(3, 1));
        assertEquals(0, ancestor.getKthAncestor(5, 2));
        assertEquals(-1, ancestor.getKthAncestor(6, 3));
    }
}