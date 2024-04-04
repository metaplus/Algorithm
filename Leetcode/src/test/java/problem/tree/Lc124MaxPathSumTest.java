package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc124MaxPathSumTest {

    @Test
    void maxPathSum() {
        assertEquals(2, new Lc124MaxPathSum().maxPathSum(TreeNode.parse("[2,-1]")));
        assertEquals(20, new Lc124MaxPathSum().maxPathSum(TreeNode.parse("[8,9,-6,null,null,5,9]")));
    }
}