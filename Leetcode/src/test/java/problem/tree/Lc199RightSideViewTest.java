package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc199RightSideViewTest {

    @Test
    void rightSideView() {
        assertEquals(ArrayParse.parseIntList("[1,3,4]"), new Lc199RightSideView().rightSideView(TreeNode.parse("[1,2,3,4]")));
    }
}