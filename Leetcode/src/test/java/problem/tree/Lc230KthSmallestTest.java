package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc230KthSmallestTest {

    @Test
    void kthSmallest() {
        assertEquals(2, new Lc230KthSmallest().kthSmallest(TreeNode.parse("[1,null,2]"), 2));
        assertEquals(1, new Lc230KthSmallest().kthSmallest(TreeNode.parse("[3,1,4,null,2]"), 1));
    }
}