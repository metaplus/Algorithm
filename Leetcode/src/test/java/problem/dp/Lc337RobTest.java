package problem.dp;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc337RobTest {

    @Test
    void rob() {
        assertEquals(7, new Lc337Rob().rob(TreeNode.parse("[4,1,null,2,null,3]")));
        assertEquals(7, new Lc337Rob().rob(TreeNode.parse("[3,2,3,null,3,null,1]")));
    }
}