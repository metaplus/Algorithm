package problem.tree.search;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class Lc538ConvertBSTTest {

    @Test
    void convertBST() {
        assertEquals(TreeNode.parse("[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]"),
                new Lc538ConvertBST().convertBST(TreeNode.parse("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]")));
    }
}