package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class Lc1026MaxAncestorDiffTest {

    @Test
    void maxAncestorDiff() {
        assertEquals(8,new Lc1026MaxAncestorDiff().maxAncestorDiff(TreeNode.parse("[8,null,1,5,6,2,4,0,null,7,3]")));
    }
}