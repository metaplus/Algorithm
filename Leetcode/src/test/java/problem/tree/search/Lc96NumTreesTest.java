package problem.tree.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc96NumTreesTest {

    @Test
    void numTrees() {
        assertEquals(5, new Lc96NumTrees().numTrees(3));
    }
}