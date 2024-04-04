package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc101IsSymmetricTest {

    @Test
    void isSymmetric() {
        assertTrue(new Lc101IsSymmetric().isSymmetric(TreeNode.parse("[1,2,2,3,4,4,3]")));
        assertFalse(new Lc101IsSymmetric().isSymmetric(TreeNode.parse("[1,2,2,null,3,null,3]")));
    }
}