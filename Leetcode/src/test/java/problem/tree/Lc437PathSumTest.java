package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc437PathSumTest {

    @Test
    void pathSum() {
        assertEquals(3, new Lc437PathSum().pathSum(TreeNode.parse("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8));
    }
}