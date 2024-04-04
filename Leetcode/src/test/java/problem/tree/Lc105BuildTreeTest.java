package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc105BuildTreeTest {

    @Test
    void buildTree() {
        assertEquals(TreeNode.parse("[3,9,20,null,null,15,7]"), new Lc105BuildTree().buildTree(
                ArrayParse.parseIntArray("[3,9,20,15,7]"),
                ArrayParse.parseIntArray("[9,3,15,20,7]")));
    }
}