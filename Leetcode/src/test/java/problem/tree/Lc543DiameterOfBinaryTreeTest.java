package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class Lc543DiameterOfBinaryTreeTest {

    @Test
    void diameterOfBinaryTree(){
        TreeNode node = TreeNode.parse("[1,2]");
        assertEquals(1,new Lc543DiameterOfBinaryTree().diameterOfBinaryTree(node));
    }
}