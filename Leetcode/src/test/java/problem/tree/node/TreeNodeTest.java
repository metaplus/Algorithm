package problem.tree.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {

    @Test
    void parse() {
        TreeNode node = TreeNode.parse("[8,9,-6,null,null,5,9]");
        assertEquals(node.val, 8);
    }
}